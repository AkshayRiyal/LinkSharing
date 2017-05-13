package com.ttn.linksharing

import com.ttn.linksharing.co.UserCo
import com.ttn.linksharing.vo.ResourceVO
import com.ttn.linksharing.vo.TopicVO

class LoginController {
    
    
    def index() {
        
        if (session.user) {
            forward(controller: "User", action: "dashboard")
        } else {
            
            
            List<ResourceVO> resourceVOS1 = Resource.getRecentPost()
            render(view: "/login/index", model:  [resourceVOs1: resourceVOS1])
        }
        
    }
    
    def loginHandler(String username, String password) {
        
        User user = User.findByUserNameAndPassword(username, password)
        println(user)
        if (user) {
         /*   if (user.isActive()) {*/
                session.user = username
                redirect(controller: "User", action: "dashboard")
           /*
            } else {
                flash.loginError = 'Your account is not active'
                redirect(controller: "Login")
                
            }*/
        } else {
            flash.loginError = 'User not found'
            redirect(controller: "Login")
        }
    }
    
    def logOut() {
        session.invalidate()
        forward(controller: "login", action: "index")
    }
    
    def register(UserCo userCo) {
        User user = new User()
        bindData(user, userCo)
        user.save(flush: true)
        if(user.password!=user.confirmPassword)
        {
            flash.signupError=["Passwords Doesn't Match"]
            redirect(controller: "Login")
    
        }
        else {
            if (user.hasErrors()) {
                flash.signupError = user.errors.allErrors.collect { message(error: it) }
            } else {
                flash.signupMessage = "You are registered successfully."
            }
            redirect(controller: "Login")
        }
  
    }
    
}
