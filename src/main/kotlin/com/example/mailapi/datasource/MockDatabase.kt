package com.example.mailapi.datasource

import com.example.mailapi.model.EmailID
import org.springframework.stereotype.Repository

@Repository
class MockDatabase() {
    private val emailId : EmailID = EmailID("Mail@Mail.com", "Mail Password")

    fun getEmail () : EmailID{
        return emailId
    }

}