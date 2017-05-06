package com.ttn.linksharing.util

import grails.validation.Validateable
import groovy.transform.ToString

@ToString
class UserCo implements Validateable{
    String username;
    String password;
}
