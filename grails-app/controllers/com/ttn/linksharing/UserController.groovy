package com.ttn.linksharing

import com.ttn.linksharing.co.SearchCO
import com.ttn.linksharing.co.UserCo
import grails.converters.JSON
import org.hibernate.criterion.Projection

class UserController {
    static defaultAction = "dashboard"
    def assetResourceLocator
    
    def dashboard(SearchCO co) {
        if(!co)
            co=new SearchCO()
        User user = User.findByUserName(session.user)
        List msgList = user.getUnReadResources(co)
        List<Topic> topicList = User.getSubscribedTopics(user)
        
        List<User> userList = []
        
        userList.add(User.findByUserName(session.user))
        log.info("${ReadingItem.countByUserAndIsRead(user,false)}")
        render(view: "/user/dashboard", model: [msgList: msgList,count:ReadingItem.countByUserAndIsRead(user,false), post: topicList, userList: userList])
    }
    
    def edit() {
        User user = User.findByUserName(session.user)
        List<User> userList = []
        userList.add(user)
        render(view: "edit", model: [userList: userList, topics: user.topics])
        
    }
    
    def updateInfo() {
        User user = User.findByUserName(session.user)
        user.lastName = params.lname
        user.firstName = params.fname
        user.userName = params.uname
    
        def file = request.getFile('image')
        if(file){
            user.photo = file.getBytes()
        }
    
        if (user.save(flush: true)) {
            flash.message = "Info updated."
            session.user = params.uname
        } else {
            flash.message = "Info cannot be updated"
        }
        
        redirect(controller: "user", action: "edit")
    }
    
    def updatePassword() {
        if (params.password != params.confirmPassword) {
            flash.error = "Password Doesnot Match"
        } else {
            User user = User.findByUserName(session.user)
            user.password = params.password
            user.confirmPassword = params.confirmPassword
            if (user.save(flush: true)) {
                flash.message = "Password updated."
            } else {
                flash.message = "Password cannot be updated"
            }
        }
        redirect(controller: "user", action: "edit")
        
    }
    
    def profile(int userId) {
        
        User user = User.get(userId)
        if(user) {
            Resource.findByCreatedBy(user)
            List<User> userList = []
            userList.add(user)
            render(view: 'profile', model: [userList: userList, topics: user.topics, resourcesCreated: Resource.findAllByCreatedBy(user)])
        }
    }
    
    def adminPanel(SearchCO co) {
        if(!co.offset)
            co.offset=0
        
        User user = User.findByUserName(session.user)
        if (user.admin) {
            List<User> userList = User.createCriteria().list(sort:co.sort,order:co.order,offset:co.offset,max:5){eq("admin",false)}
            render(view: 'admin', model: [userList: userList])
        } else {
            redirect(controller: "user", action: "dashboard")
        }
    }
    
    def activate(int userId, int status) {
        
        User user = User.get(userId)
       
        if (user) {
            if (status) {
                user.active = true
            } else {
                user.active = false
            }
            if (user.save(flush: true)) {
                flash.message = "User Status Updated"
            } else {
                flash.error = "Updation Failed"
            }
        } else {
            flash.error = "User Not Found"
        }
        redirect(controller: "user", action: "adminPanel")
    }
    def image(Long userId) {
        User user = User.load(userId)
        byte[] photo
        if (user?.photo == null) {
            photo = assetResourceLocator.findAssetForURI('user_img_default.png').byteArray
        } else {
            photo = user.photo
        }
        OutputStream out = response.getOutputStream()
        out.write(photo)
        out.flush()
        out.close()
    }
    
    
}
    
