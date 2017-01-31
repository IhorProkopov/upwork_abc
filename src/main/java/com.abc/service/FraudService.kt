package com.abc.service

import com.abc.model.rest.UserRequest
import com.abc.model.rest.UserResponse

interface FraudService {

    fun check(request: UserRequest): UserResponse

}