package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.util.Visibility
import org.hibernate.ObjectNotFoundException
import org.springframework.context.MessageSource


class TopicController {
    TopicService topicService
  def show (ResourceSearchCO co){
      Topic topic=Topic.read(co.topicId)
      if(topic)
        {
         if(topic.visibility==Visibility.PUBLIC)
         {
             render "Success!!!"
         }
            else {
             User user=User.findByUserName(session.user)
             Subscription subscription=Subscription.findByUserAndTopic(user,topic)
             if(subscription)
             {
                 render "Success!!!"
             }
             else
             {
                 flash.error="Topic is private"
                 /* redirect(controller:"login",action:"index")*/
             }
         }
        }
        else
        {
            flash.error="Topic doesnot exist"
           /* redirect(controller:"login",action:"index")*/
        }
      render (view:"/topic/show" )
        
    }
    
    def save(String name,String visibility)
    {
        Topic topic=new Topic(name: name,visibility: Visibility.stringToEnum(visibility),createdBy: User.findAllByUserName(session.user))
        topic.save(flush:true)
        if(!topic.hasErrors()) {
      
            flash.message = "Topic successfully created. "
        }
        else {
            //log.error(topic.errors.allErrors)
            flash.error="Topic cannot be created."
            
        }
       redirect(controller: 'user',action: 'dashboard')
      }
    def delete(int id)
    {
        try {
            Topic topic = Topic.load(id)
            topic.delete(flush: true)
                render "Topic of id:${id} is deleted"
            }
        catch (ObjectNotFoundException e)
        {
            render flash.error="Topic DoesNot Exist."
        }
    }
   
}
