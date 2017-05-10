package com.ttn.linksharing

import com.ttn.linksharing.util.Constant
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([User])
@TestFor(LoginController)
class LoginControllerSpec extends Specification {
    def "CheckIndexActionIfUser'sSessionIsSetThenRequestIsForwardToUserIndexAction"() {
        setup:
        session.user = "akshayr" //User.findByUserName("admin")
        
        when:
        controller.index()
        
        then:
        response.forwardedUrl == "/user/index"
    }
    
    def "CheckIndexActionIfUser'ssSssionisnotSetThenErrorShouldbeRendered"() {
        when:
        controller.index()
        
        then:
        response.text == "Failure"
    }
    
    def "CheckLogoutUser'sSessionIsInvalidatedThenRedirectToLoginIndexAction"() {
        when:
        controller.logOut()
        
        then:
        response.forwardedUrl == "/"
    }
    
    
   def "CheckLoginHandlerUserIsAbleToLogin"() {
        setup:
        User user = new User(email: "check@gmail.com", userName: "checkusername", password: "check123", confirmPassword: "checkusername",firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: true)
        user.save(flush: true)
        
        when:
        controller.loginHandler(user.userName, user.password)
        
        then:
        response.redirectedUrl == '/user'
    }
    def "CheckLoginHandlerUserIsNotActive"() {
        setup:
        User user = new User(email: "check@gmail.com", userName: "checkusername", password: "check123", confirmPassword: "checkusername",firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: false)
        user.save(flush: true)
        
        when:
        controller.loginHandler(user.userName, user.password)
        
        then:
        flash.error == "Your account is not active"
    }
    
    def "CheckLoginHandlerUserIsNotFound"() {
        setup:
        User user = new User(email: "check@gmail.com", userName: "checkusername", password: "check123", confirmPassword: "checkusername",firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: true)
    
    
        when:
        controller.loginHandler(user.userName, user.password)
        
        then:
        flash.error == 'User not found'
    }
}
