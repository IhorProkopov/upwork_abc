package com.abc.kafka

import com.abc.model.rest.UserRequest
import com.abc.service.VendorService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var gson: Gson

    @Autowired
    lateinit var vendorService: VendorService

    @Autowired
    lateinit var sender: Sender

    @KafkaListener(topics = arrayOf("database.vendor"))
    fun receiveVendorResponse(message: String) {
        println("received message='$message'")
        val request = gson.fromJson(message, UserRequest::class.java)
        val res = vendorService.processRequest(request)
        sender.sendMessage("database.vendor.response", gson.toJson(res))
        sender.sendMessage("database.decision", gson.toJson(res))
    }

}