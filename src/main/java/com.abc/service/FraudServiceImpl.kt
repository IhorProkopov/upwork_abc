package com.abc.service

import com.abc.dao.ScoreRepository
import com.abc.model.ErrorResponse
import com.abc.model.ServiceType
import com.abc.model.VendorResponse
import com.abc.model.emailage.EmailAgeRequest
import com.abc.model.emailage.EmailageRequestData
import com.abc.model.rest.DecisionResponse
import com.abc.model.rest.IdResponse
import com.abc.model.rest.UserRequest
import com.abc.model.rest.UserResponse
import com.abc.model.zumigo.ZumigoRequest
import com.abc.model.zumigo.ZumigoRequestData
import com.abc.vendor.VendorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class FraudServiceImpl : FraudService {

    @Autowired
    @Qualifier("emailage")
    lateinit var emailageService: VendorService

    @Autowired
    @Qualifier("zumigo")
    lateinit var zumigoService: VendorService

    @Autowired
    lateinit var scoreDAO: ScoreRepository

    @Autowired
    lateinit var decisionService: DecisionService

    override fun check(request: UserRequest): UserResponse = if (request.async) processAsync(request) else processSync(request)

    private fun processSync(request: UserRequest): DecisionResponse {
        val vendorResponse = makeRequestToVendor(request)
        scoreDAO.saveUserRequest(request)
        scoreDAO.storeVendorResponse(vendorResponse)
        val decision = decisionService.makeDecision(vendorResponse, request)
        scoreDAO.storeDecision(decision)
        return decision
    }

    private fun processAsync(request: UserRequest): IdResponse {
        val id = UUID.randomUUID().toString()
        return IdResponse(id)
    }

    private fun makeRequestToVendor(request: UserRequest): VendorResponse {
        return when (request.serviceType) {
            ServiceType.emailage -> emailageService.makeRequest(EmailAgeRequest(request.data as EmailageRequestData))
            ServiceType.zumigo -> zumigoService.makeRequest(ZumigoRequest(request.data as ZumigoRequestData))
            else -> {
                ErrorResponse("incorrent service type", 400)
            }
        }
    }

}