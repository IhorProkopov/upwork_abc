package com.abc.kafka

import com.abc.model.ErrorResponse
import com.abc.model.ServiceType
import com.abc.model.VendorResponse
import com.abc.model.emailage.EmailAgeRequest
import com.abc.model.emailage.EmailageRequestData
import com.abc.model.rest.UserRequest
import com.abc.model.zumigo.ZumigoRequest
import com.abc.model.zumigo.ZumigoRequestData
import com.abc.vendor.VendorService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @Autowired
    lateinit var gson: Gson

    @Autowired
    @Qualifier("emailage")
    lateinit var emailageService: VendorService

    @Autowired
    @Qualifier("zumigo")
    lateinit var zumigoService: VendorService

    @Autowired
    lateinit var sender: Sender

    @Autowired
    lateinit var vendorService: VendorService

    @KafkaListener(topics = arrayOf("database.vendor"))
    fun receiveVendorResponse(message: String) {
        println("received message='$message'")
        val request = gson.fromJson(message, UserRequest::class.java)
        val res = when (request.serviceType) {
            ServiceType.emailage -> emailageService.makeRequest(EmailAgeRequest(request.data as EmailageRequestData, request.uuid))
            ServiceType.zumigo -> zumigoService.makeRequest(ZumigoRequest(request.data as ZumigoRequestData, request.uuid))
            else -> {
                ErrorResponse("Incorrect service type", 400, request.uuid)
            }
        } as VendorResponse
        sender.sendMessage("database.vendor.response", gson.toJson(res))
        sender.sendMessage("database.decision", gson.toJson(res))
    }

}