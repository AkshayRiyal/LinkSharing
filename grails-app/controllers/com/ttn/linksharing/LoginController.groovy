package com.ttn.linksharing

class LoginController {
    
    def index() {
        //session.user="user1"
        if (session.user) {
            forward(controller: "User",action:"index")
        } else {
            render "Failure"
           /* render flash.error*/
        }
       
    }
    
    def loginHandler(String username, String password) {
        
        User user = User.findByUserNameAndPassword(username, password)
        if (user) {
            if (user.isActive()) {
                session.user = username
                redirect(controller: "User")
                
            } else {
                flash.error = 'Your account is not active'
                render flash.error
                
            }
        } else {
            flash.error = 'User not found'
            render flash.error
        }
    }
    
    def logOut() {
        session.invalidate()
        forward(controller: "login", action: "index")
    }
    
    def register() {
        User user1 = new User()
        user1.save(flush: true)
        if (user1.hasErrors()) {
            render flash.error = user1.errors.allErrors.collect { message(error: it) }
        }
        
    }
   
}
