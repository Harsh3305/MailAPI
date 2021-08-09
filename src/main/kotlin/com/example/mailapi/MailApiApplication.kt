package com.example.mailapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MailApiApplication

fun main(args: Array<String>) {
    runApplication<MailApiApplication>(*args)
}
