package com.ttn.linksharing

import com.ttn.linksharing.co.UserCo
import com.ttn.linksharing.vo.ResourceVO
import com.ttn.linksharing.vo.TopicVO

class LoginController {
    def sendMailService
    
    def index() {
        
        if (session.user) {
            forward(controller: "User", action: "dashboard")
        } else {
            
            List<ResourceVO> resourceVOS1 = Resource.getRecentPost()
            render(view: "/login/index", model: [resourceVOs1: resourceVOS1])
        }
        
    }
    
    def loginHandler(String username, String password) {
        User user = User.findByUserNameAndPassword(username, password)
        if (user) {
            if (user.admin) {
                session.user = username
                redirect(controller: "User", action: "adminPanel")
                
            } else if (user.isActive()) {
                session.user = username
                redirect(controller: "User", action: "dashboard")
            } else {
                flash.error = 'Your account is not active'
                redirect(controller: "Login")
                
            }
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
        
        if (userCo.password != userCo.confirmPassword) {
            
            flash.signupError = ["Passwords Doesn't Match"]
            redirect(controller: "Login")
            
        } else {
            User user = new User()
            bindData(user, userCo)
            user.admin = false
            user.active = false
            user.save(flush: true)
            if (user.hasErrors()) {
                flash.signupError = user.errors.allErrors.collect { message(error: it) }
            } else {
                flash.signupMessage = "You are registered successfully."
            }
            redirect(controller: "Login")
        }
        
    }
    def forgotPassword()
    {
        render(view:'/login/forgotpassword')
    }
    def forgotPasswordMail(String email)
    {
       User user= User.findByEmail(email)
        if(user)
        {
            String body="You Password is ${user.password}"
            String subject="LinkSharing Forgot Password"
     sendMailService.sendInvitation("akshay.riyal@tothenew.com",email,body,subject)
            flash.message="Password will be sent on mail"
        }
        else{
            flash.error="Email is not registered"
        }
        redirect(view: "/login/forgotPassword")
    }
}
