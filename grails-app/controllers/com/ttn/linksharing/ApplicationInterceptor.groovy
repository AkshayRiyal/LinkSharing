package com.ttn.linksharing


class ApplicationInterceptor {
    ApplicationInterceptor() {
      //  matchAll()
    }
    
    boolean before() {
        true
    }
    
    boolean after() {
        log.info("Controller:${controllerName} Action:${actionName} Params:${params}")
        true
    }
    
    void afterView() {
        // no-op
    }
}
