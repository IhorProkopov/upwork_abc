package com.abc

import com.abc.model.rest.UserResponse
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
@Import(BaseConfiguration::class)
open class WebServiceApplication {

    @Bean
    open fun decisionMap(): ConcurrentHashMap<UUID, UserResponse> = ConcurrentHashMap()

}

fun main(args: Array<String>) {
    SpringApplication.run(WebServiceApplication::class)
}