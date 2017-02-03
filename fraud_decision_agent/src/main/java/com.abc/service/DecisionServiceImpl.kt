package com.abc.service

import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import org.springframework.stereotype.Service

@Service
class DecisionServiceImpl : DecisionService {
    override fun makeDecision(vendorResponses: Array<VendorResponse>): DecisionResponse {
        return DecisionResponse(0, vendorResponses[0].uuid)
    }
}