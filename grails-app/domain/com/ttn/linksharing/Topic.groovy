package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.util.Seriousness
import com.ttn.linksharing.util.Visibility
import com.ttn.linksharing.vo.TopicVO


class Topic {
    
    String name;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility;
    
    static belongsTo = [createdBy: User]
    static hasMany = [subscriptions: Subscription, resources: Resource]
    
    static constraints = {
        name(nullable: false, blank: false, unique: ['createdBy'])
        
        visibility(nullable: false, validator: {
            val ->
                val instanceof Visibility
        })
        
    }
    static mapping = {
        sort "name"
    }
    
    def afterInsert = {
        
        Topic.withNewSession {
            Subscription subscription = new Subscription(topic: this, user: createdBy)
            subscription.save(flush:true)
            /*this.addToSubscriptions(subscription)*/
            if (subscription.hasErrors()) {
                log.error("Subscription cannot be created")
            }
        }
        
    }
    
    public String toString() {
        return this.name
    }
    
    static List<TopicVO> getTrendingTopics() {
        
        List trendingTopics = Topic.createCriteria().list() {
            //createAlias('resources', 'rsc')
            projections {
                groupProperty("id")
                property("name")
                property("visibility")
                property("createdBy")
                resources {
                    count "id", "count"
                }
            }
            
            order("count", "desc")
            order("name", "desc")
            maxResults 3// This is just for pagination
            firstResult 0
        }
        
        List<TopicVO> topicVOList = []
        trendingTopics.each {
            topicVOList.add(new TopicVO(id: it.getAt(0), name: it.getAt(1), visibility: it.getAt(2), createdBy: it.getAt(3), count: it.getAt(4)))
        }
            return topicVOList
        }
        
        
        static List<User> getSubscribedUser(Long topicId) {
            List<User> userList = Subscription.createCriteria().list {
                projections {
                    property('user')
                }
                eq('topic', Topic.get(topicId))
            }
            
        }
        
    
}