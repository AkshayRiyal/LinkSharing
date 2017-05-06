package com.ttn.linksharing

class DocumentResource extends Resource {
    String filePath
    
    static constraints = {
        filePath(blank: false)
    }
    @Override
    String toString() {
        this.filePath
    }
}
