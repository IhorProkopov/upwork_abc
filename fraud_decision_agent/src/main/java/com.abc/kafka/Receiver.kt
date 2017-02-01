package com.abc.kafka

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var gson: Gson

    @KafkaListener(topics = arrayOf("database.decision"))
    fun receiveRequest(message: String) {
        println("received message='$message'")

    }

}