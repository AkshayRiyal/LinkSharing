package com.ttn.linksharing

import groovy.transform.ToString

@ToString
class ResourceRating {
    User user
    Integer score
    Date dateCreated
    Date lastUpdated
    static belongsTo = [resource: Resource]
    static constraints = {
        
        score(min: 1, max: 5)
        resource(unique: ['user'])
    }
    
}
