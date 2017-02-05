package com.abc.kafka

import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserResponse
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Component
class Receiver {

    @Autowired
    lateinit var gson: Gson

    @Autowired
    lateinit var decisionMap: ConcurrentHashMap<UUID, UserResponse>

    @KafkaListener(topics = arrayOf("decision.response"))
    fun receiveDecision(message: String) {
        println("receiveDecision='$message'")
        val decisionResponse = gson.fromJson(message, DecisionResponse::class.java)
        decisionMap.put(decisionResponse.id, decisionResponse)
    }

}