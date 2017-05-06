package com.ttn.linksharing

import com.ttn.linksharing.util.Seriousness
import com.ttn.linksharing.util.Visibility


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
            
            this.addToSubscriptions(subscription)
            if (subscription.hasErrors()) {
                log.error("Subscription cannot be created")
            }
        }
        
    }
    
    public String toString() {
        return this.name
    }
    
}