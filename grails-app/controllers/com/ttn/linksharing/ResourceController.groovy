package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import org.hibernate.ObjectNotFoundException

class ResourceController {
    
    def index() {}
    
    def delete(int resourceId) {
        try {
            Resource resource = Resource.load(resourceId)
            resource.delete(flush: true)
           flash.message= "Post Deleted"
        }
        catch (ObjectNotFoundException e) {
            flash.error = "Resource DoesNot Exist."
        }
        finally{
            redirect(controller: 'user',action: 'dashboard')
        }
    }
    
    def search(ResourceSearchCO co) {
        if (co.q) {
            co.visibility = "public"
            List<Resource> resourceList = Resource.search(co).list()
            render resourceList
        }
    }
    
    def searchByQuery(String query) {
        println("--------------------Inside Search By Query")
        if (query || (session['user'] && User.findByUserName(session['user']).admin && !query)) {
            log.info("validated")
            List<Resource> resource=Resource.findResourceByQuery(query)
            println("Search Result ${resource}")
            render(view: '/resource/search', model: [searchResources: resource,
                                            query          : query])
        } else {
            flash.error = "Enter some text in searchBox"
            redirect(action: "index", controller: 'login')
        }
    }
    
    def show(long id) {
        
        //render Resource.getRatingInformation(id)
        Resource resource = Resource.get(id)
        render(view: '/resource/show', model: [resource: resource])
    }
    
    def topPost() {
        render Resource.getTopPost()
    }
    
    def update(String newDescription,int resourceId) {
        Resource resource = Resource.get(resourceId);
        if(resource)
        {
            resource.description=newDescription
            if(resource.save(flush:true))
            {
                flash.message="Resource Updated"
            }
            else{
                flash.message="Resource Updation Failed"
    
            }
            
        }
        redirect(controller: 'user',action: 'dashboard')
    
    }
    
    
}
