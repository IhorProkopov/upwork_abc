package com.abc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class FraudApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(FraudApplication::class.java)
}