package com.abc.dao

import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest
import org.springframework.stereotype.Repository

@Repository
class ScoreDAOImpl : ScoreDAO {
    override fun saveUserRequest(request: UserRequest) {
        println("saveUserRequest: $request")
    }

    override fun storeVendorResponse(vendorResponse: Array<VendorResponse>) {
        println("storeVendorResponse: $vendorResponse")
    }

    override fun storeDecision(decision: DecisionResponse) {
        println("storeDecision: $decision")
    }
}