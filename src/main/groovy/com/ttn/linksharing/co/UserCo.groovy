package com.ttn.linksharing.co

import grails.validation.Validateable
import groovy.transform.ToString

@ToString
class UserCo implements Validateable{
    String firstName;
    String lastName;
    String email;
    String userName
    String password;
    String confirmPassword
}
