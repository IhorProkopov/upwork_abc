package com.abc.vendor

import com.abc.model.VendorRequest
import com.abc.model.VendorResponse
import com.abc.model.emailage.EmailAgeRequest
import com.abc.model.emailage.EmailAgeResponse

interface VendorService {

    fun makeRequest(request: VendorRequest) : VendorResponse

}