package com.ttn.linksharing

class ResourceRatingController {
    
    def index() {
    }
    
    def rate(String resourceId, String score) {
        User user = User.findByUserName(session.user)
        Resource resource = Resource.get(resourceId)
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource)
        if (resourceRating) {
            resourceRating.score=score
        } else {
            resourceRating=new ResourceRating(user: user,resource: resource,score: score)
        }
        resourceRating.save(flush:true)
    render ""
    }
    
}
