package com.ttn.linksharing

class UtilController {
    
    def index() {
        log.info("Info Log")
        log.warn("Warn Log")
        log.error("Error Log")
        log.info("params : " + params.id)
        render "Welcome to util Controller"
    }
}
