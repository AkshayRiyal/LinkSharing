package com.ttn.linksharing

import grails.transaction.Transactional

@Transactional
class SendInvitationService {
    def mailService
    
    def sendInvitation(Topic topic, User user, String email) {
        try {
            sendMail {
                mailService.sendMail {
                    to email
                    from user.email
                    subject "LinkSharing Invitation"
                    body "Hey Buddy, just found this interesting topic : " + topic.name+" on linksharing."
                }
                return "Success"
            }
    
        }
        catch (Exception e)
        {
            println(e)
        }
    }
}