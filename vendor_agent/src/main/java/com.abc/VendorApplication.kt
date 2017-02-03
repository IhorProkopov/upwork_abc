package com.abc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource


@SpringBootApplication
@PropertySource("classpath:common.properties")
@Import(BaseConfiguration::class)
open class VendorApplication

fun main(args: Array<String>) {
    SpringApplication.run(VendorApplication::class)
}