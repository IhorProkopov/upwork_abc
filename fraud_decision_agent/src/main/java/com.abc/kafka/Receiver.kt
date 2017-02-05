package com.abc.kafka

import com.abc.model.VendorResponse
import com.abc.service.DecisionService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Value("\${webservice.decision}")
    private lateinit var webserviceTopic: String

    @Value("\${store.decision}")
    private lateinit var dbTopic: String

    @Autowired
    lateinit var decisionService: DecisionService

    @Autowired
    lateinit var sender: Sender

    @Autowired
    lateinit var gson: Gson

    @KafkaListener(topics = arrayOf("\${decision.process}"))
    fun receiveRequest(message: String) {
        val vendorResponses = gson.fromJson(message, Array<VendorResponse>::class.java)
        val res = decisionService.makeDecision(vendorResponses)
        sender.sendMessage(webserviceTopic, gson.toJson(res))
        sender.sendMessage(dbTopic, gson.toJson(res))
    }

}