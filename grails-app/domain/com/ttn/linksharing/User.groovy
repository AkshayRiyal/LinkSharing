package com.ttn.linksharing

import com.ttn.linksharing.co.SearchCO

class User {
    String firstName;
    String lastName;
    String email;
    String userName
    String password;
    boolean active=false;
    byte[] photo;
    boolean admin=false
    Date dateCreated
    Date lastUpdated
    static transients = ['fullName']
    def confirmPassword
    
    @Override
    String toString() {
        this.userName
        
    }
    
    String getFullName() {
        [firstName, lastName].findAll { it }.join(' ')
    }
    
    
    static hasMany = [topics       : Topic,
                      subscriptions: Subscription, readingItems: ReadingItem, resources: Resource]
    
    static constraints = {
        userName(unique: true)
        email(unique: true, blank: false, nullable: false, email: true)
        password(blank: false, nullable: false, size: 5..15)
        
        firstName(blank: false, nullable: false)
        lastName(blank: false, nullable: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        confirmPassword nullable: true, blank: true, validator: { confirmPassword, user ->
            if (!user.id && confirmPassword && !confirmPassword.equalsIgnoreCase(user.password))
                return "password mismatch"
        }
    }
    static mapping = {
        sort id: "desc" // or "asc"
    }
    static List<Topic> getSubscribedTopics(User user)
    {
        List<Topic> topicList=Subscription.createCriteria().list {
            projections{
                property('topic')
            }
            eq('user',user)
        }
        return topicList
    }
    
    List getUnReadResources(SearchCO co) {
        List list = []
        if (co.q) {
            list = User.createCriteria().list {
                projections {
                    readingItems
                            {
                                property('resource')
                            }
                
                }
                
                readingItems {
                    eq('isRead', false)
                }
                
                readingItems {
                    resource {
                        ilike('%description%', co.q)
                    }
                }
                
                eq('id', this.id)
                
                maxResults 5
                firstResult 0
            }
            
        } else {
            list = User.createCriteria().list {
                projections {
                    readingItems
                            {
                                property('resource')
                            }
                }
                readingItems {
                    eq('isRead', false)
                }
                eq('id', this.id)
                maxResults 5
                firstResult 0
            }
            
        }
        println list
        return list
    }
}