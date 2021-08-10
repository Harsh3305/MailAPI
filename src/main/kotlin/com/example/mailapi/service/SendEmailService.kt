package com.example.mailapi.service

import com.example.mailapi.datasource.MockDatabase
import com.example.mailapi.model.CombineEmailWithPassword
import com.example.mailapi.model.EMailBody
import org.springframework.stereotype.Service
import java.util.*
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage




@Service
class SendEmailService (private val mockDatabase: MockDatabase) {
    fun sendMail (eMailBody: EMailBody) : EMailBody {

        sendEmail(mockDatabase.getEmail().email, eMailBody.getEmail(), eMailBody.getTitle(), eMailBody.getBody(), mockDatabase.getEmail().password)

        return eMailBody
    }

    fun sendMail (combineEmailWithPassword: CombineEmailWithPassword) : EMailBody{
        sendEmail(combineEmailWithPassword.emailID.email, combineEmailWithPassword.eMailBody.getEmail(), combineEmailWithPassword.eMailBody.getTitle(), combineEmailWithPassword.eMailBody.getBody(), combineEmailWithPassword.emailID.password)
        return combineEmailWithPassword.eMailBody
    }

    private fun sendEmail(user: String, to:String, title: String,
                  body: String, password: String) {
        val props = Properties()
        val host = "smtp.gmail.com"
        with (props) {
            put("mail.smtp.host", host)
            put("mail.smtp.port", "587") // for TLS
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
        }
        val auth = object: Authenticator() {
            override fun getPasswordAuthentication() =
                PasswordAuthentication(user, password)
        }
        val session = Session.getInstance(props, auth as javax.mail.Authenticator)
        val message = MimeMessage(session)
        with (message) {
            setFrom(InternetAddress(user))
            addRecipient(Message.RecipientType.TO, InternetAddress(to))

            setSubject(title)
            setText(body)
        }
        val transport = session.getTransport("smtp")
        with (transport) {
            connect(host, user, password)
            sendMessage(message, message.allRecipients)
            close()
        }
    }
}