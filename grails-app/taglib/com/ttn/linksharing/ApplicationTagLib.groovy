package com.ttn.linksharing

class ApplicationTagLib {
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"
    static defaultEncodeAs = "raw"
    
    def getSubscriptionCount = { attrs ->
        Long topicId = attrs.topicId
        Integer subscriptionCount = topicId ? Subscription.createCriteria().get {
            projections {
                count('id')
            }
            'topic' {
                eq('id', topicId)
            }
        } : 0
        String url = createLink(controller: 'subscription', action: 'index', params: ['topicId': topicId])
        out << "<a href='${url}'>${subscriptionCount}</a>"
    }
    def getTopPost={
     out<< render(template: '/topic/topshare',model:[resourceVOs:Resource.getTopPost()] )
    }
    def isResourceRead = { attrs, body ->
        User user = User.findByUserName(session.user)
        if (user) {
            Resource resource = Resource.get(attrs.resourceId)
            if (resource) {
                Integer count = ReadingItem.countByResourceAndIsReadAndUser(resource, true, user)
                if (count) {
                    out << "<a href='${createLink(controller: 'ReadingItem', action: 'updateIsRead', id: resource.id)}' class='custom-inline'>Mark as Un Read</a> "
                } else {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'updateIsRead', id: resource.id)}' class='custom-inline'>Mark as Read</a> "
                }
            }
        }
    }
    def getTrendingTopic={
        out<< render(template: '/topic/trendingtopic' ,model:[ trendingTopics:Topic.getTrendingTopics()])
        
    }
    /*  def isLoggedIn = { attrs, body ->
          if (session.user) {
              out << body()
          }
      }
      
      def getTrendingTopics = { attrs ->
          out << render(template: '/resource/trendingTopic', model: [topicVOList: topicVOList])
      }*/
      
      def getPostCount = { attrs ->
          Long topicId = attrs.topicId
          Integer postCount = topicId ? Resource.createCriteria().get {
              projections {
                  count('id')
              }
              'topic' {
                  eq('id', topicId)
              }
          } : 0
          String url = createLink(controller: 'resource', action: 'show', params: ['topicId': topicId])
          out << "<a href='${url}'>${postCount}</a> "
      }
    
}
