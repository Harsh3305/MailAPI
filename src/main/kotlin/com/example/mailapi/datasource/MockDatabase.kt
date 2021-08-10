package com.example.mailapi.datasource

import com.example.mailapi.model.EmailID
import org.springframework.stereotype.Repository

@Repository
class MockDatabase {
    private val emailAddress : String
    private val password : String
    private val emailId : EmailID
    constructor() {
        this.emailAddress =  "mail.bot.api@you-spam.com"
        this.password = "dEANNpQEtMmQZ4Y"

        this.emailId = EmailID(emailAddress, password)

    }
    constructor(emailAddress : String, password : String) {
        this.emailAddress = emailAddress
        this.password = password
        this.emailId = EmailID(emailAddress, password)
    }


    fun getEmail () : EmailID{
        return emailId
    }

}