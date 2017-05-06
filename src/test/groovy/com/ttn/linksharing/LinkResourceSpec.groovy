package com.ttn.linksharing

import com.ttn.linksharing.util.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {
    
    def "validateLinkResource"() {
        
        setup:
        User user = new User(email: "akshay@gmail.com", userName: "akshay", password: "check123", firstName: "akshay",
                lastName: "riyal")
        
        Topic topic = new Topic(name: "Grails", visibility: Visibility.PRIVATE, createdBy: user)
        
        LinkResource linkResource = new LinkResource(url: url, description: description, createdBy: user, topic: topic)
        
        when:
        Boolean result = linkResource.validate()
        
        then:
        result == valid
        
        where:
        description   | url                        | valid
        "description" | 'http://www.tothenew.com/' | true
        " "           | 'http://www.tothenew.com/' | false
        null          | 'http://www.tothenew.com/' | false
        "description" | '://www.tothenew.com/'     | false
        "description" | ' '                        | false
        "description" | null                       | false
    }
    
    def "tostringCheck"() {
        
        setup:
        LinkResource linkResource = new LinkResource(url: url)
        
        expect:
        result == linkResource.toString()
        
        where:
        url                               | result
        "http://www.testLinkResource.com" | "http://www.testLinkResource.com"
    }
}
