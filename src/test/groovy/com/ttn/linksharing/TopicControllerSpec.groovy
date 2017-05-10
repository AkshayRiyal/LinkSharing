package com.ttn.linksharing

import com.ttn.linksharing.util.Constant
import com.ttn.linksharing.util.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([User, Topic, Subscription])
@TestFor(TopicController)
class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
    def "checkTopicShow"() {
        setup:
        User user = new User(email: "check@gmail.com", userName: "checkusername", password: "check123", confirmPassword: "checkusername",firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: false)

        user.save(flush:true)
        
        Topic topic = new Topic(name:'groovy', visibility: visible, createdBy: user)
        
        session.user = user.userName
        
        topic.save(flush: true)
        
        when:
       
        controller.show(topic.id)
        
        
        then:
        response.text == result
        
        where:
        visible            | result
        Visibility.PUBLIC  | "Success!!!"
        Visibility.PRIVATE | "Success!!!"
    }
    def "checkTopicSave"() {
        
        setup:
        User user = new User(email: "check@gmail.com", userName: "checkusername", password: "check123", confirmPassword: "check123",firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: false)

        user.save(flush:true)
        
        String topicName='groovy'
        String visibility=Visibility.stringToEnum("public")
        Topic topic = new Topic(name:topicName, visibility: visibility, createdBy: user)
        session.user = user.userName
        topic.save(flush:true)
        
        when:
        controller.save(topicName,visibility)
        
        then:
        flash.message == "Success"
    }
}
