package com.ttn.linksharing

import com.ttn.linksharing.vo.ResourceVO
import com.ttn.linksharing.vo.TopicVO

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
    def getTopPost = {
        out << render(template: '/topic/topshare', model: [resourceVOs: Resource.getTopPost()])
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
    def getTrendingTopic = {
        out << render(template: '/topic/displaytopic', model: [topics: Topic.getTrendingTopics()])
        
    }
    
    def getSubscribedTopics = {
        out << render(template: '/topic/displaytopic', model: [topics: User.findByUserName(session.user).subscriptions.topic])
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
    
    def getsearchedtopic = { attrs ->
        Topic topic = attrs.topic
        List<TopicVO> topicVOList = []
        /*List<Resource> resources=Resource.findAllByTopic(topic)*/
        topicVOList.add(new TopicVO(createdBy: topic.createdBy, id: topic.id, count: topic.resources.size(), visibility: topic.visibility, name: topic.name))
        out << render(template: '/topic/displaytopic', model: [topics: topicVOList])
    }
    def getsearchedtopicsubscribeduser = { attrs ->
        Topic topic = attrs.topic
        List<User> userList = topic.subscriptions*.user
        out << render(template: '/user/show', model: [userList: userList])
    }
    def getsearchedtopicresources = { attrs ->
        Topic topic = attrs.topic
        List<Resource> resourceList = Resource.findAllByTopic(topic)
        out << render(template: '/user/showresource', model: [msgList: resourceList])
    }
    
    def showSubscribe = {
        attrs ->
            if (session.user) {
                Topic topic = Topic.get(attrs.topicId)
                Subscription subscription = Subscription.findByTopicAndUser(topic, User.findByUserName(session.user))
                log.info(" in topicSubscribed : $topic $subscription")
                if (subscription) {
                    out << "<a href='${createLink(controller: 'subscription', action: 'delete', params: [topicId: attrs.topicId])}'>UnSubscribe</a>"
// out << "<a href='javascript:void(0)' onclick='updateSubscription(${attrs.topicId},deleteSubscription)'>Unsubscribe</a> "
                } else {
                    out << "<a href='${createLink(controller: 'subscription', action: 'save', params: [topicId: attrs.topicId])}'>Subscribe</a>"
// out << "<a href='javascript:void(0)' onclick='updateSubscription(${attrs.topicId},save)'>Subscribe</a> "
                }
            }
    }
}