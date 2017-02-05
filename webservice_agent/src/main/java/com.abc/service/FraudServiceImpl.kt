package com.abc.service

import com.abc.kafka.Receiver
import com.abc.kafka.Sender
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.IdResponse
import com.abc.model.rest.UserRequest
import com.abc.model.rest.UserResponse
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Service
class FraudServiceImpl : FraudService {

    @Value("\${database.user.request}")
    private lateinit var dbEndpoint: String

    @Autowired
    lateinit var gson: Gson

    @Autowired
    lateinit var decisionMap: ConcurrentHashMap<UUID, UserResponse>

    @Autowired
    lateinit var sender: Sender

    @Autowired
    lateinit var receiver:Receiver

    override fun check(request: UserRequest): UserResponse {
        val jsonRequest = gson.toJson(request);
        sender.sendMessage(dbEndpoint, jsonRequest)
        sender.sendMessage("database.vendor", jsonRequest)
        return if (request.async) IdResponse(request.uuid) else awaitResponse(request.uuid)
    }

    tailrec private fun awaitResponse(uuid: UUID): DecisionResponse =
            if (decisionMap.containsKey(uuid)) decisionMap.remove(uuid) as DecisionResponse else awaitResponse(uuid)

}
