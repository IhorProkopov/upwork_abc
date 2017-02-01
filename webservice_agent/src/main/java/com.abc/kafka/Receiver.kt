package com.abc.kafka

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

    @KafkaListener(topics = arrayOf("database.decision"))
    fun receiveDecision(message: String) {
        println("received message='$message'")
        val decisionResponse = gson.fromJson(message, UserResponse::class.java)
        decisionMap.put(decisionResponse.id, decisionResponse)
    }

}