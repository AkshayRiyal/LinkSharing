package com.ttn.linksharing

import com.ttn.linksharing.co.SearchCO
import grails.converters.JSON
import org.hibernate.criterion.Projection

class UserController {
    
    def dashboard(SearchCO co) {
      /*  render session.user
        User user = User.findByUserName(session.user)
        render user.getUnReadResources(co)*/
        User user=User.findByUserName(session.user)
        List msgList=user.getUnReadResources(co)
        List<Topic> topicList=User.getSubscribedTopics(user)
        
        List<User> userList=[]
        
        userList.add(User.findByUserName(session.user))
        render (view:"/user/dashboard",model: [msgList:msgList,post:topicList,userList:userList])
    }
    
    
}