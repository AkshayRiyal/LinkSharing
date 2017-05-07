package com.ttn.linksharing.co

import grails.validation.Validateable

class SearchCO implements Validateable {
    String q
    Integer max
    Integer offset
    String order
    String sort
    static constraints={
        q(nullable: true)
        max(nullable: true)
        offset(nullable: true)
        order(nullable: true)
        sort(nullable: true)
    }
    
}
