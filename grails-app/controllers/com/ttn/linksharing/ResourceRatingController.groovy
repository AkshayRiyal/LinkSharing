package com.ttn.linksharing

class ResourceRatingController {
    
    def index() {}
    
    def rate(int resourceId, int score) {
        User user = User.findByUserName(session.user)
        Resource resource = Resource.get(resourceId)
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource)
        
        if (resourceRating) {
            resourceRating.score = score
        } else {
            resourceRating = new ResourceRating(user: user, resource: resource, score: score)
        }
        if(resourceRating.save(flush: true))
        {
          
        }
        
        render ""
    }
}
