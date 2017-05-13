package com.ttn.linksharing

class ReadingItemController {

    def index() { }
    def UpdateIsRead(Long id) {
        User user = User.findByUserName(session.user)
        Resource resource = Resource.get(id)
        if (user && resource) {
            ReadingItem readingItem = ReadingItem.findByResourceAndUser(resource, user)
           println(readingItem)
            if (readingItem) {
                readingItem.isRead = !readingItem.isRead
                if (readingItem.save(flush:true)) {
                    flash.message = "Status updated"
                } else {
                    flash.error = readingItem.errors.allErrors.collect { message(error: it) }.join('<br/>')
                }
    
            }
            else{
                new ReadingItem(resource: resource,user: user,isRead: true).save(flush:true)
            }
            redirect(controller: 'user', action: 'dashboard')
        }
         else {
            flash.error = "please Login to change the status"
            redirect(controller: 'user', action: 'dashboard')
        }
        
    }
}
