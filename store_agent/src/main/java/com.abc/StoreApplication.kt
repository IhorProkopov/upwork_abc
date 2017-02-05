package com.abc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.context.support.AbstractApplicationContext



@SpringBootApplication
@PropertySource("classpath:common.properties")
@Import(BaseConfiguration::class)
open class StoreApplication

fun main(args: Array<String>) {
    SpringApplication.run(StoreApplication::class.java)
}

