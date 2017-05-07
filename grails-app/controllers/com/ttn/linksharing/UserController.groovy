package com.ttn.linksharing

import com.ttn.linksharing.co.SearchCO
import grails.converters.JSON
import org.hibernate.criterion.Projection

class UserController {
    
    def index(SearchCO co) {
        render session.user
        User user = User.findByUserName(session.user)
        render user.getUnReadResources(co)
    }
    
    def UpdateIsRead(Long id, Boolean isRead) {
       if( ReadingItem.executeUpdate('Update ReadingItem set isRead=:read where id=:i',[read:isRead,i:id]))
           render "Success"
        else
           render "Failure"
    }
}