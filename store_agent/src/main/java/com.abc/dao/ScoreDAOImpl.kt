package com.abc.dao

import com.abc.model.VendorResponse
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.UserRequest
import org.springframework.stereotype.Repository

@Repository
class ScoreDAOImpl : ScoreDAO {
    override fun saveUserRequest(request: UserRequest) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun storeVendorResponse(vendorResponse: VendorResponse) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun storeDecision(decision: DecisionResponse) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}