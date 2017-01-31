package com.abc.kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class Sender {

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(topic: String, message: String) {
        val future = kafkaTemplate.send(topic, message)

        // you can register a callback with the listener to receive the result
        // of the send asynchronously
        future.addCallback(
                object : ListenableFutureCallback<SendResult<String, String>> {
                    override fun onSuccess(
                            result: SendResult<String, String>) {
                        println("sent message='$message' with offset=${result.getRecordMetadata().offset()}")
                    }
                    override fun onFailure(ex: Throwable) {
                        println("Failure")
                    }
                })
    }
}