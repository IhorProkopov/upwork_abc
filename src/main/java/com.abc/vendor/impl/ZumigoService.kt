package com.abc.vendor.impl

import com.abc.model.VendorRequest
import com.abc.model.VendorResponse
import com.abc.model.zumigo.ZumigoRequest
import com.abc.model.zumigo.ZumigoResponse
import com.abc.vendor.VendorService
import org.springframework.stereotype.Service

@Service("zumigo")
class ZumigoService : VendorService{

    override fun makeRequest(request: VendorRequest): VendorResponse {
        request as ZumigoRequest
        return ZumigoResponse(isDeviceTrusted = true)
    }

}