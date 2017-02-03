package com.abc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:application.properties")
@Import(BaseConfiguration::class)
open class FraudApplication

fun main(args: Array<String>) {
    SpringApplication.run(FraudApplication::class.java)
}