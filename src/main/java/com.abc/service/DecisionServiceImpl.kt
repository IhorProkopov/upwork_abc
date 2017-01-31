package com.abc.service

import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest
import org.springframework.stereotype.Service

@Service
class DecisionServiceImpl : DecisionService {
    override fun makeDecision(vendorResponse: VendorResponse, userRequest: UserRequest): DecisionResponse {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}