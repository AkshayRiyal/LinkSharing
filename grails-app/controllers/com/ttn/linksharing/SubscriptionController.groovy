package com.ttn.linksharing

import com.ttn.linksharing.util.Seriousness
import com.ttn.linksharing.util.Visibility


class SubscriptionController {
   
    def save(int topicId) {
            User user = User.findByUserName(session.user)
            Topic topic = Topic.findById(topicId)
        

            Subscription subscription = new Subscription(topic: topic, user: user)
            subscription.save(flush:true)
        
            if (subscription.errors.hasErrors()) {
                flash.error="Subscription Failed"
        
            } else {
                flash.message="Subscribed New Topic"
            }
        redirect(controller:'user',action:'dashboard')
    }
    
   
    def delete(int topicId) {
      Topic topic = Topic.get(topicId)
        Subscription subscription = Subscription.findByTopicAndUser(topic,User.findByUserName(session.user))
        println("Subscription Object--------------"+topicId)
        if (subscription) {
            subscription.delete(flush:true)
            flash.message ="Un-subscribed to ${topic}"
        } else {
          flash.error="Action Failed"
        }
        redirect(controller:'user',action:'dashboard')
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
