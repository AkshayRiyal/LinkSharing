package com.ttn.linksharing

import grails.converters.JSON

class UserController {
    
    def index()
    {
      render session.user
    }
}
