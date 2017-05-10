package com.ttn.linksharing

import com.ttn.linksharing.util.Constant
import com.ttn.linksharing.util.Visibility
import grails.test.mixin.*
import spock.lang.*

@TestFor(SubscriptionController)
@Mock(Subscription)
class SubscriptionControllerSpec extends Specification {
    
    def "testSaveWhenTopicNotFound"() {
        
        when:
        controller.save(1)
        
        then:
        response.text == "Subscription Failed"
    }
    
    def "testSaveWhenTopicFound"() {
        given:
        User user = new User(firstName: "akshay", lastName: "riyal", userName: "akshayr",
                email: "akshay@gmail.com", password: Constant.password,
                admin: false, active: true, photo: null,
                confirmPassword: Constant.password)
        user.save(flush: true)
        
        User user1 = new User(firstName: "Shikha", lastName: "Sharma", userName: "shikha",
                email: "shikha@gmail.com", password: Constant.password,
                admin: false, active: true, photo: null,
                confirmPassword: Constant.password)
        session.user = user1.userName
        Topic topic = new Topic(topicName: "topic1", visibility: Visibility.PUBLIC, createdBy: user)
        user.addToTopics(topic)
        topic.save(flush: true)
        
        when:
        controller.save(topic.id)
        then:
        response.text == "Successfull Subscription"
    }
    
    def "testUpdateWhenUserAndTopicDoesNotMatchInSubscription"() {
        
        given:
        User user = new User(firstName: "akshay", lastName: "riyal", userName: "akshayr",
                email: "akshay@gmail.com", password: Constant.password,
                admin: false, active: true, photo: null,
                confirmPassword: Constant.password)
        user.save(flush: true)
        Topic topic = new Topic(topicName: "topic1", visibility: Visibility.PUBLIC, createdBy: user)
        topic.save(flush: true)
        User user1 = new User(firstName: "Shikha", lastName: "Sharma", userName: "shikha",
                email: "shikha@gmail.com", password: Constant.password,
                admin: false, active: true, photo: null,
                confirmPassword: Constant.password)
        session.user = user1.userName
    
        when:
        controller.update(topic.id, "SERIOUS")
        
        then:
        response.text == "Subscription not found"
    }
}
