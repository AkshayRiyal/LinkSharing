package com.ttn.linksharing

class LinkResource extends Resource{

    String url
    static constraints = {
        url(blank:false,url: true)
        
    }
   @Override
    String toString()
       {
           this.url
       }

}
