package com.ttn.linksharing.co

import grails.validation.Validateable

class SearchCO implements Validateable {
    String q
    Integer max=5
    Integer offset=0
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
