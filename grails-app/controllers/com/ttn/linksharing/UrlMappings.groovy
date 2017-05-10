package com.ttn.linksharing

class UrlMappings {
    
    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        
        
        "/user"(controller: "User", action: "noAction")
        "/"(controller: "login" ,action: "index")
        "500"(view: '/error')
        "404"(view: '/notFound')
        "/errorTest"(redirect: [controller: 'topic', action: 'save'])
        "/test"(uri: "topic.test")
        "/util"(controller: "Util", action: "index")
        "/demo"(view:'/Demo')
    }
}
