package linksharing

import com.ttn.linksharing.DocumentResource
import com.ttn.linksharing.LinkResource
import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.Resource
import com.ttn.linksharing.ResourceRating
import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.util.Constant
import com.ttn.linksharing.util.Seriousness
import com.ttn.linksharing.util.Visibility
import grails.core.GrailsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class BootStrap {
@Autowired
    GrailsApplication grailsApplication
    

    def init = { servletContext ->
    
        User user1 = new User(firstName: "Akshay", lastName: "Riyal", userName: "admin", email: "admim@gmail.com", password: Constant.password, confirmPassword: Constant.password,
                active: true, admin: true)

        user1.save(flush:true)
        if (user1.hasErrors())
            log.error("User cannot Be created.")

/*

        try {
            createUser()
            createTopics()
            createResources()
            subscribeTopics()
            createReadingItems()
            createResourceRatings()
            createResourceRatings()
        }
        catch (Exception e) {
            println(e)
        }
*/
    }
    def destroy = {
    }
    
    
    void createTopics() {
        def users = User.all
        users.each() { user ->
            5.times {
                Topic topic = new Topic(name: "topic" + it, visibility: Visibility.PUBLIC, createdBy: user)
                
                if (topic.hasErrors())
                    log.error("Topic Cannot Be Created")
                topic.save()
                
            }
            
            
        }
    }
    
    void createUser() {
        
        if (User.count() == 0) {
            User user1 = new User(firstName: "Akshay", lastName: "Riyal", userName: "akshayr", email: "akshay@gmail.com", password: Constant.password, confirmPassword: Constant.password,
                    active: true, admin: true)
            //  user1.save( flush: true,failOnError: true,)
            user1.save(flush: true)
            if (user1.hasErrors())
                log.error("User cannot Be created.")
            else
                log.info("User created.")
            User user2 = new User(firstName: "Sam", lastName: "Srivastav", userName: "sams", email: "sam@gmail.com", password: "check123", confirmPassword: "check123",
                    active: true, admin: false)
            user2.save(failOnError: true, flush: true)
            
            if (user2.hasErrors())
                log.error("User cannot Be created.")
            else
                log.info("User created.")
        }
        
    }
    
    void createResources() {
        if (Resource.count() == 0) {
            def link = ["https://www.stackOverflow.com/grails", "https://www.stackOverflow.com/java"]
            def description = ["Grails", "Java"]
            def doc = ["/home/grails.doc", "/home/java.doc"]
            println(Topic.count())
            Topic.all.each { topic ->
                2.times {
                    Resource linkResource = new LinkResource(url: link[it], description: "resource"+it, createdBy: topic.createdBy, topic: topic)
                    Resource documentResource = new DocumentResource(filePath: doc[it], description: "resource"+it, createdBy: topic.createdBy, topic: topic)
                    linkResource.save(failOnError: true, flush: true)
                    documentResource.save(failOnError: true, flush: true)
                    if (linkResource.hasErrors())
                        log.error("Error while Saving LinkResource")
                    if (documentResource.hasErrors())
                        log.error("Error while Saving DocumentResource")
                }
            
            }
        }
        
        
        
    }
    
    void subscribeTopics() {
        User.all.each { user ->
            
            Topic.all.each { topic ->
                if (!(topic.createdBy == user)) {
                    if (Subscription.findByTopicAndUser(topic, user) == null) {
                        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Seriousness.SERIOUS)
                        subscription.save(flush: true)
                        if (subscription.hasErrors()) {
                            log.error("Subscription Cannot be done.Due to ${subscription.errors}")
                        } else {
                            log.info("${user} has subscribed to ${topic}")
                        }
                    }
                    
                }
                
            }
        }
    }
    
    
    void createReadingItems() {
        User.all.each { user ->
            
            Resource.all.each { resource ->
                
                if (Subscription.findAllByTopicAndUser(resource.topic, user) != null) {
                    
                    if (resource.createdBy != user) {
                        
                        if (ReadingItem.findByUserAndResource(user, resource) == null) {
                            
                            ReadingItem readingItem = new ReadingItem(resource: resource, user: user, isRead: false)
                            readingItem.save(flush: true)
                            println(readingItem.errors)
                        }
                    }
                }
            }
        }
    }
    
    void createResourceRatings() {
        ReadingItem.all.each { readingItem ->
            if (readingItem.isRead == false) {
                
                ResourceRating resourceRating = new ResourceRating(resource: readingItem.resource, score: 4, user: readingItem.user)
                resourceRating.save(flush: true)
            }
            
        }
    }
}
