package com.ttn.linksharing

class ReadingItem {
    Resource resource
    Boolean isRead
    static  belongsTo = [user:User,resource:Resource]
    static constraints = {
        isRead(nullable: false)
        user(nullable: false)
        resource(unique: ['user'], nullable: false)
        
    }
}
