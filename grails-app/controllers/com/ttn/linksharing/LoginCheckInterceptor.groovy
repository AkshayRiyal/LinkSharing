package com.ttn.linksharing


class LoginCheckInterceptor {
    
    LoginCheckInterceptor() {
      matchAll().excludes(controller: "login")
                 .excludes(controller:'resource')
                  .excludes(controller:'documentResource')
                  .excludes(controller:'topic')
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
