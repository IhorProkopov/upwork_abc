package com.abc.controller

import com.abc.model.rest.UserRequest
import com.abc.model.rest.UserResponse
import com.abc.service.FraudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController

@RestController
class FraudController {

    @Autowired
    lateinit var fraudService: FraudService

    @RequestMapping(value = "/check", method = arrayOf(POST))
    fun check(@RequestBody request: UserRequest): UserResponse = fraudService.check(request)

}
