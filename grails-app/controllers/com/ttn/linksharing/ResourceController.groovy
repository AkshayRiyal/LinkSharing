package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import org.hibernate.ObjectNotFoundException

class ResourceController {
    
    def index() {}
    
    def delete(int id) {
        try {
            Resource resource = Resource.load(id)
            resource.delete(flush: true)
            render "Resource of id:${id} is deleted"
        }
        catch (ObjectNotFoundException e) {
            render flash.error = "Resource DoesNot Exist."
        }
    }
    
    def search(ResourceSearchCO co) {
        if (co.q) {
            co.visibility = "public"
            List<Resource> resourceList = Resource.search(co).list()
            render resourceList
        }
    }
    
    def show(long id) {
        render Resource.getRatingInformation(id)
        
    }
    
    def topPost() {
        render Resource.getTopPost()
    }
    def update(int id)
    {
      Resource resource= Resource.get(id);
    }
    
    
}
