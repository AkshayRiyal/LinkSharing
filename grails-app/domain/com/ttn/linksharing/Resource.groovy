package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.util.Visibility
import com.ttn.linksharing.vo.RatingInfoVO
import org.grails.datastore.mapping.query.Query

abstract class Resource {
    String description
    Date dateCreated
    Date lastUpdated
    def ratingInfo
    
    
    static belongsTo = [createdBy: User, topic: Topic]
    
    static hasMany = [resourceRatings: ResourceRating, readingItems: ReadingItem]
    
    static mapping = {
        description(type: 'text')
    }
    
    static constraints = {
        
    }
    
    
    static namedQueries = {
        search { ResourceSearchCO co ->
            if (co.topicId) {
                eq('topic', Topic.get(co.topicId))
                topic {
                    eq('visibility', Visibility.stringToEnum(co.visibility))
                }
            }
            
        }
    }
    
    
   static RatingInfoVO getRatingInformation(long id) {
        List result = Resource.createCriteria().list {
            projections {
                resourceRatings {
                    count("score")
                    sum("score")
                    avg("score")
                }
                eq("id", id)
            }
        }
        
       println(result)
        return new RatingInfoVO(totalVotes: result.get(0).getAt(0), totalScore: result.get(0).getAt(1), averageScore: result.get(0).getAt(2))
    }
    
    
    static List getTopPost() {
        List list = Resource.createCriteria().list {
            projections {
                groupProperty("id")
                property('description')
                property('createdBy')
                property('topic')
                resourceRatings {
                    count('id', "count")
                }
                
            }
            order("count", "desc")
            maxResults 5 // This is just for pagination
            firstResult 0
        }
        println(list)
        return list
    }
    
}