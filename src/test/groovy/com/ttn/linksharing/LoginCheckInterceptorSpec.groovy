package com.ttn.linksharing


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginCheckInterceptor)
class LoginCheckInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test loginCheck interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"loginCheck")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
