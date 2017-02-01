package com.abc.kafka

import com.abc.dao.ScoreDAO
import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.CountDownLatch
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var scoreDAO: ScoreDAO

    @Autowired
    lateinit var gson: Gson

    @KafkaListener(topics = arrayOf("database.request"))
    fun receiveRequest(message: String) {
        scoreDAO.saveUserRequest(gson.fromJson(message, UserRequest::class.java))
    }

    @KafkaListener(topics = arrayOf("database.vendor.response"))
    fun receiveVendorResponse(message: String) {
        scoreDAO.storeVendorResponse(gson.fromJson(message, VendorResponse::class.java))
    }

    @KafkaListener(topics = arrayOf("database.decision"))
    fun receiveDecision(message: String) {
        scoreDAO.storeDecision(gson.fromJson(message, DecisionResponse::class.java))
    }

}