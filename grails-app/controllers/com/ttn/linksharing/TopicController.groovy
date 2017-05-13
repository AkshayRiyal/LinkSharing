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
             println(topic)
    
             render (view: "/topic/show",model:[topic:topic] )
         
         }
        }
           
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
    def delete(int topicId)
    {
        try {
            Topic topic = Topic.get(topicId)
            println ("---------id===${topicId}----------------topic===${topic}")
            topic.delete(flush: true)
                flash.message="Topic ${topic.name} deleted."
            }
        catch (ObjectNotFoundException e)
        {
           flash.error="Topic DoesNot Exist."
        }
        redirect(controller: 'user',action: 'dashboard')
    }
   
}
