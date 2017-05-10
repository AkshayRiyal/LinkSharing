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
        out << "<a href='${url}'>${subscriptionCount}</a> "
    }
    
  /*  def isLoggedIn = { attrs, body ->
        if (session.user) {
            out << body()
        }
    }
    
    def getTrendingTopics = { attrs ->
        out << render(template: '/resource/trendingTopic', model: [topicVOList: topicVOList])
    }
    
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
    }*/
    
}
