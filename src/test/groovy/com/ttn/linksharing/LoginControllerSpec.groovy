package com.ttn.linksharing

import com.ttn.linksharing.util.Constant
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
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
    
    
   /* def "CheckLoginHandlerUserIsAbleToLogin"() {
        setup:
        User user = new User(email: "check@gmail.com", userName: "check123", password: Constant.password, confirmPassword: Constant.password,firstName: "akshay", lastName: "riyal", photo: null,
                admin: true, active: true)
        user.save(flush: true)
        
        when:
        controller.loginHandler(user.userName, user.password)
        
        then:
        response.redirectedUrl == '/login/index'
    }
    
    def "CheckLoginHandlerUserIsNotActive"() {
        setup:
        User user = new User(userName: "userNew", password: Constant.PASSWORD,
                firstName: "Name", lastName: "Lname", email: "user@gmail.com", active: false)
        user.save(flush: true)
        
        when:
        controller.login(user.userName, user.password)
        
        then:
        flash.error == "User is not active"
    }
    
    def "CheckLoginHandlerUserIsNotFound"() {
        setup:
        User user = new User(userName: "aa", password: Constant.PASSWORD,
                firstName: "Name", lastName: "Lname", email: "aa@gmail.com")
        
        when:
        controller.login(user.userName, user.password)
        
        then:
        flash.error == "User not found"
    }*/
}
