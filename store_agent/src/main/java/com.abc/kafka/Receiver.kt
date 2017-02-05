package com.abc.kafka

import com.abc.dao.ScoreDAO
import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var scoreDAO: ScoreDAO

    @Autowired
    lateinit var gson: Gson

    @KafkaListener(topics = arrayOf("\${store.user.request}"))
    fun receiveRequest(message: String) {
        println("receiveRequest: $message")
        scoreDAO.saveUserRequest(gson.fromJson(message, UserRequest::class.java))
    }

    @KafkaListener(topics = arrayOf("\${store.vendor.response}"))
    fun receiveVendorResponse(message: String) {
        println("receiveVendorResponse: $message")
        scoreDAO.storeVendorResponse(gson.fromJson(message, Array<VendorResponse>::class.java))
    }

    @KafkaListener(topics = arrayOf("\${store.decision}"))
    fun receiveDecision(message: String) {
        println("receiveDecision: $message")
        scoreDAO.storeDecision(gson.fromJson(message, DecisionResponse::class.java))
    }

}