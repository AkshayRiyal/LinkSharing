package com.ttn.linksharing

abstract class Resource {
    String description
    Date dateCreated
    Date lastUpdated
    static belongsTo = [createdBy: User,topic:Topic]
    
    static hasMany = [resourceRatings:ResourceRating, readingItems:ReadingItem]
    
    static mapping = {
        description(type: 'text')
    }
    
    static constraints = {
        
    }
    
   /* String toString() {
        this.description
    }*/
}
