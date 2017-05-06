package com.ttn.linksharing

class User {
    String firstName;
    String lastName;
    String email;
    String userName
    String password;
    boolean active;
    byte[] photo;
    boolean admin
    Date dateCreated
    Date lastUpdated
    static transients = ['fullName']
    def confirmPassword
    
    @Override
    String toString() {
        this.userName
        
    }
    
    String getFullName() {
        [firstName, lastName].findAll { it }.join(' ')
    }
    
    
    static hasMany = [topics       : Topic,
                      subscriptions: Subscription, readingItems: ReadingItem, resources: Resource]
    
    static constraints = {
        userName(unique: true)
        email(unique: true, blank: false, nullable: false, email: true)
        password(blank: false, nullable: false, size: 5..15)
        
        firstName(blank: false, nullable: false)
        lastName(blank: false, nullable: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        confirmPassword nullable: true, blank: true, validator: { confirmPassword, user ->
            if (!user.id && confirmPassword && !confirmPassword.equalsIgnoreCase(user.password))
                return "password mismatch"
        }
    }
    static mapping = {
        sort id: "desc" // or "asc"
    }
}