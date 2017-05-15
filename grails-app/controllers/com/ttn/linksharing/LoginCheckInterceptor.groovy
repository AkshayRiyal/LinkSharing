package com.ttn.linksharing


class LoginCheckInterceptor {
    
    LoginCheckInterceptor() {
        matchAll().excludes(controller: "login")
                .excludes(controller: 'resource', action: 'show')
                .excludes(controller: 'documentResource')
                .excludes(controller: 'topic', action: 'show')
                .excludes(controller: 'resource', action: 'searchByQuery')
        
    }
    
    boolean before() {
        if (session.user == null) {
            redirect(controller: "login", action: "index")
            return false
        }
        return true
    }
    
    boolean after() { true }
    
    void afterView() {
        // no-op
    }
}
