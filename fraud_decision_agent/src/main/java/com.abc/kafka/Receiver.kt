package com.abc.kafka

import com.abc.model.VendorResponse
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var gson: Gson

    @KafkaListener(topics = arrayOf("\${decision.agent}"))
    fun receiveRequest(message: String) {
        println("received message='$message'")
        val vendorResponses = gson.fromJson(message, Array<VendorResponse>::class.java)

    }

}