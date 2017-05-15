package com.ttn.linksharing

import grails.web.context.ServletContextHolder
import org.springframework.web.multipart.MultipartFile

class DocumentResourceController {
    
    def index() {}
    
    def download(int resourceId) {
        Resource resource = Resource.get(resourceId)
        def file = new File(resource.filePath)
        
        if (file.exists()) {
            response.setContentType("application/octet-stream")
            response.setHeader("Content-disposition", "attachment;filename=\"${file.name}\"")
            response.outputStream << file.bytes
       
        } else
        {
            flash.error="Error Downloading Post"
            redirect(controller: 'user', action: 'dashboard')
        }// appropriate error handling
    }
    
    def upload() {
       
        try {
           /* String path = "/home/akshay/3_projects/linksharing/documents/" + System.currentTimeMillis()*/
           String path="/home/akshay/"+params.document.getOriginalFilename()
            
       File convFile = new File(path)
            params.document.transferTo(convFile)
            DocumentResource resource = new DocumentResource(description: params.description, topic: Topic.get(params.topicId), filePath: path, createdBy: User.findByUserName(session.user))
            if (resource.save(flush: true)) {
                flash.message = "Document Successfully Shared"
            } else {
                flash.error = "Document Share Failed"
            }
            redirect(controller: 'user', action: 'dashboard')
        }
    catch (Exception e)
    {
        flash.error = "Error Uploading File"
        redirect(controller: 'user', action: 'dashboard')
    }
    }
}
 
