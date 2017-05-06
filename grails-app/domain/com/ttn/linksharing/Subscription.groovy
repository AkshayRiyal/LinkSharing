package com.ttn.linksharing

import com.ttn.linksharing.util.Seriousness

class Subscription {
    Seriousness seriousness = Seriousness.SERIOUS;
    Date dateCreated
    Date lastUpdated
    static belongsTo = [user: User, topic: Topic]
    static constraints = {
        user(nullable: false)
        seriousness(nullable: false)
        user(nullable: false)
        topic(unique: ['user'])
    }
    static mapping = {
        user lazy: false
        topic lazy: false
    }
    String toString() {
        
        return "${user} subscribed ${topic}"
    }
}
