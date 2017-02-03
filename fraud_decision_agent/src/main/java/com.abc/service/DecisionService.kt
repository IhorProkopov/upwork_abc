package com.abc.service

import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest

interface DecisionService {

    fun makeDecision(vendorResponses: Array<VendorResponse>): DecisionResponse

}