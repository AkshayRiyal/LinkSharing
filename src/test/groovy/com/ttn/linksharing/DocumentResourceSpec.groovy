package com.ttn.linksharing

import com.ttn.linksharing.util.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {
    
    def "validateDocumentResource"() {
        
        setup:
        User user = new User(email: "akshay@gmail.com", userName: "akshay", password: "check123", firstName: "akshay",
                lastName: "riyal")
        
        Topic topic = new Topic(topicName: "Grails", visibility: Visibility.PRIVATE, createdBy: user)
        
        DocumentResource documentResource = new DocumentResource(filePath: filePath, description: description,
                createdBy: user, topic: topic)
        
        when:
        Boolean result = documentResource.validate()
        
        then:
        result == valid
        
        where:
        description   | filePath      | valid
        "description" | '/ home/file' | true
        " "           | '/home/file'  | false
        null          | '/home/file'  | false
        "description" | ' '           | false
        "description" | null          | false
    }
    
    def "tostringCheck"() {
        setup:
        DocumentResource documentResource = new DocumentResource(filePath: filePath)
        
        when:
        result == documentResource.toString()
        
        then:
        noExceptionThrown()
        
        where:
        filePath          | result
        "/some/file/path" | "/some/file/path"
        ""                | ""
        null              | null
    }
}
