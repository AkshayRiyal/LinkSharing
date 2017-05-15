package com.ttn.linksharing

import grails.transaction.Transactional

@Transactional
class SendMailService {
    def mailService
    
    def sendInvitation(String fromMail, String toMail,String mailBody,String mailSubject) {
        try {
            sendMail {
                mailService.sendMail {
                    to toMail
                    from fromMail
                    subject mailSubject
                    body mailBody
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