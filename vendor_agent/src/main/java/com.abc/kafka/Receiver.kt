package com.abc.kafka

import com.abc.model.rest.UserRequest
import com.abc.service.VendorService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Value("\${store.vendor.response}")
    lateinit var dbEndpoint:String

    @Value("\${decision.process}")
    lateinit var decisionEndpoint:String

    @Autowired
    lateinit var gson: Gson

    @Autowired
    lateinit var vendorService: VendorService

    @Autowired
    lateinit var sender: Sender

    @KafkaListener(topics = arrayOf("\${vendor.interview}"))
    fun receiveVendorRequest(message: String) {
        println("receiveVendorRequest='$message'")
        val request = gson.fromJson(message, UserRequest::class.java)
        val res = vendorService.processRequest(request)
        sender.sendMessage(dbEndpoint, gson.toJson(res))
        sender.sendMessage(decisionEndpoint, gson.toJson(res))
    }

}