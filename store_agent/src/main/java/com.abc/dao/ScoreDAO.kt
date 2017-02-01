package com.abc.dao

import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest

interface ScoreDAO {

    fun saveUserRequest(request: UserRequest)

    fun storeVendorResponse(vendorResponse: VendorResponse)

    fun storeDecision(decision: DecisionResponse)

}