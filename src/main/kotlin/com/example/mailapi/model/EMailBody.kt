package com.example.mailapi.model

class EMailBody (private var email:String, private var title : String, private var bodyOfMessage  :String) {

    fun getEmail () :String {
        return this.email
    }
    fun getBody () :String {
        return this.bodyOfMessage
    }
    fun getTitle () :String {
        return this.title
    }
}
