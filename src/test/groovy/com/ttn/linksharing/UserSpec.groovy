package com.ttn.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {
    
    void "test one"() {
        expect:
        true
    }
    
    @Unroll("Executing #sno")
    void "testUserValidations"() {
        setup:
        User user = new User(email: email, userName: userName, password: password, firstName: fname, lastName: lname, photo: photo,
                admin: admin, active: active)
        when:
        Boolean result = user.validate()
        
        then:
        result == valid
        where:
        sno | email               | userName  | password   | fname    | lname   | photo | admin | active | valid
        1   | "123"               | "check"   | ""         | null     | ""      | null  | true  | false  | false
        2   | "akshay@gmail.com"  | "akshayr" | "check123" | "akshay" | "riyal" | null  | null  | null   | false
        3   | "akshay4@gmail.com" | "abcd"    | "098765"   | "akshay" | "riyal" | null  | true  | true   | true
    }
    
    
    def "EmailAddressAndUserNameOfUserShouldBeUnique"() {
        setup:
        String email = "akshay@gmail.com"
        String userName = "akshayr"
        String password = 'check123'
        User user = new User(email: email, userName: userName, password: password, firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: true)
        
        when:
        user.save()
        
        then:
        user.count() == 1
        
        when:
        User newUser = new User(email: email, userName: userName, password: password, firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: false)
        newUser.save()
        
        then:
        User.count() == 1
        newUser.errors.allErrors.size() == 2
        newUser.errors.getFieldErrorCount('email') == 1
        newUser.errors.getFieldErrorCount('userName') == 1
    }
    
    def "getUserFullName"() {
        expect:
        new User(firstName: firstName, lastName: lastName).fullName == name
        
        where:
        firstName | lastName | name
        "akshay"  | "riyal"  | "akshay riyal"
        ""        | "riyal"  | "riyal"
        
    }
    
    def "toStringCheck"() {
        expect:
        new User(userName: uname).toString() == result
        
        
        
        where:
        uname     | result
        "akshayr" | "akshayr"
    }
}
