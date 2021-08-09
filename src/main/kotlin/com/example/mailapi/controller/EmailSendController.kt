package com.example.mailapi.controller

import com.example.mailapi.model.EMailBody
import com.example.mailapi.service.SendEmailService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sendMail")
class EmailSendController (private val sendEmailService: SendEmailService){
    @GetMapping
    fun welcome() : String {
        return "Welcome to Mail API"
    }
    @PostMapping
    fun sendMail (eMailBody: EMailBody) : EMailBody {
        return sendEmailService.sendMail(eMailBody)
    }
}