package com.ttn.linksharing.co

import com.ttn.linksharing.util.Visibility
import grails.validation.Validateable

class ResourceSearchCO extends SearchCO implements Validateable {
    long topicId
    String visibility
    static constraints = {
        topicId(nullable: true)
        visibility validator: { val, obj ->
            Visibility.stringToEnum(val) == Visibility.PUBLIC
        }
    }
}