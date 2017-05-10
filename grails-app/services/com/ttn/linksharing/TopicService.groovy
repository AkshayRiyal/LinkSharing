package com.ttn.linksharing

import com.ttn.linksharing.util.Visibility
import grails.transaction.Transactional

@Transactional
class TopicService {
    
    def serviceMethod() {
        
    }
    
    def save(String name, String visibility,String username) {
        Topic topic=new Topic(name: name,visibility: Visibility.stringToEnum(visibility),createdBy: User.findAllByUserName(username))
        topic.save(flush:true)
        if(!topic.hasErrors()) {
            true
        }
        else {
           return false
        
        }
    }
}
