package com.ttn.linksharing.vo

import com.ttn.linksharing.User
import groovy.transform.ToString

@ToString
class TopicVO {
    int id
    String name
    String visibility
    int count
    User createdBy
}
