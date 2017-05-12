package com.ttn.linksharing

class LinkResourceController {

    def index() { }
    def save(String description,String link,int topicId)
    {
        LinkResource resource=new LinkResource(description: description,topic: Topic.get(topicId),url: link,createdBy: User.findByUserName(session.user))
        if(resource.save(flush:true))
        {
            flash.message="Link Successfully Created"
        }
        else {
            flash.error="Link Creation Failed"
        }
        redirect(controller:'user',action:'dashboard')
    }
}
