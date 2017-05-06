package com.ttn.linksharing

import com.ttn.linksharing.util.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {
    
    def "constraintsOfResourceItemExcludingUserUniqueness"() {
        
        given:
        ReadingItem resourceItemObj = new ReadingItem(resource: resource, user: user, isRead: isRead)
        
        when:
        boolean result = resourceItemObj.validate()
        
        then:
        result == excepted
        
        where:
        sno | resource           | user       | isRead | excepted
        1   | new LinkResource() | new User() | true   | true
        2   | null               | new User() | true   | false
        3   | new LinkResource() | null       | true   | false
        4   | new LinkResource() | new User() | null   | false
    }
    
    def "validatingUniqueReadingItem"() {
        
        given:
       
        User user1 = new User(email:"akshay@gmail.com", userName: "akshay", password: "check123", firstName: "akshay",
                lastName: "riyal")
        
        Topic topic = new Topic(name: "Grails", visibility: Visibility.PRIVATE, createdBy: user1)
        
        Resource resource = new LinkResource(url: "https://github.com/", description: "sdsdd", createdBy: user1, topic: topic)
        
        User user=new User(email:"akshay4@gmail.com", userName: "akshay", password: "check123", firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: false)
        
        ReadingItem readingItem = new ReadingItem(resource: resource, user: user, isRead: true)
        ReadingItem newReadingItem = new ReadingItem(resource: resource, user: user, isRead: false)
        
        when:
        readingItem.save(flush: true)
        newReadingItem.save(flush: true)
        
        then:
        
        ReadingItem.count() == 1
        newReadingItem.errors.allErrors.size() == 1
        newReadingItem.errors.getFieldErrorCount('resource') == 1
        
    }
    
    
}
