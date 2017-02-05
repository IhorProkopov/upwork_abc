package com.abc.service

import com.abc.model.VendorResponse
import com.abc.model.rest.UserRequest
import java.util.*

interface VendorService {

    fun processRequest(request: UserRequest): Array<VendorResponse>

}