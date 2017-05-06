package com.ttn.linksharing

import org.hibernate.ObjectNotFoundException

class ResourceController {

    def index() { }
    def delete(int id)
    {
        try {
            Resource resource = Resource.load(id)
            resource.delete(flush:true)
            render "Resource of id:${id} is deleted"
        }
        catch (ObjectNotFoundException e)
        {
            render flash.error="Resource DoesNot Exist."
        }
    }
}
