package com.ttn.linksharing

import com.ttn.linksharing.util.Seriousness
import com.ttn.linksharing.util.Visibility


class SubscriptionController {
   
    def save(int topicid) {
            User user = User.findByUserName(session.user)
            Topic topic = Topic.findById(topicid)
        

            Subscription subscription = new Subscription(topic: topic, user: user)
            subscription.save(flush:true)
            if (subscription.errors.hasErrors()) {
                render subscription.errors.allErrors
        
            } else {
                render "Successfull Subscription"
            }
        
    }
    
   
    def delete(int id) {
        Subscription subscription = Subscription.get(id)
        if (subscription) {
            subscription.delete(flush:true)
            render "Subscription Deleted"
        } else {
            render "Subscription Doesnot Exist"
        }
    }
    
    def update(int id, String seriousness) {
        Subscription subscription = Subscription.get(id)
        if (subscription) {
          subscription.seriousness=Seriousness.stringToEnum(seriousness)
            subscription.save(flush:true)
            if(subscription.errors.hasErrors())
            {
                render " Subscription Updation Failed"
            }
            else {
                render "Subscription Updated Successfullys"
            }
        }
        else
        {
            render "Subscription not found"
        }
    }
}
