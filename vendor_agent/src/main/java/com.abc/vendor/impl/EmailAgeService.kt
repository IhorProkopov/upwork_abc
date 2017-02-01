package com.abc.vendor.impl

import com.abc.model.VendorRequest
import com.abc.model.VendorResponse
import com.abc.model.emailage.EmailAgeRequest
import com.abc.model.emailage.EmailAgeResponse
import com.abc.model.emailage.Query
import com.abc.model.emailage.Results
import com.abc.vendor.VendorService
import org.springframework.stereotype.Service
import java.util.*

@Service("emailage")
class EmailAgeService : VendorService {

//    @Autowired
//    lateinit var restTemplate: RestTemplate

    override fun makeRequest(request: VendorRequest): VendorResponse {
        request as EmailAgeRequest
        val results = listOf(Results(email = request.email.data, EAScore = Random().nextInt().toString()))
        return EmailAgeResponse(query = Query(email = request.email.data, results = results), uuid = request.uuid)
    }

}