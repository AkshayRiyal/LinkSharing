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
        println("Resource id----------------" + id)
        Resource resource = Resource.get(id)
        println(resource)
        render(view: '/resource/show', model: [resource: resource])
    }
    
    def topPost() {
        render Resource.getTopPost()
    }
    
    def update(int id) {
        Resource resource = Resource.get(id);
    }
    
    
}
