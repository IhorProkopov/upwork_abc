package com.abc.kafka

import com.abc.model.VendorResponse
import com.abc.service.DecisionService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var decisionService: DecisionService

    @Autowired
    lateinit var sender: Sender

    @Autowired
    lateinit var gson: Gson

    @KafkaListener(topics = arrayOf("\${decision.agent}"))
    fun receiveRequest(message: String) {
        println("receiveRequest='$message'")
        val vendorResponses = gson.fromJson(message, Array<VendorResponse>::class.java)
        val res = decisionService.makeDecision(vendorResponses)
        sender.sendMessage("decision.response", gson.toJson(res))
    }

}