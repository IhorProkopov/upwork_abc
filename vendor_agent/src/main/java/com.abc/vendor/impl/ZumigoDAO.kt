package com.abc.vendor.impl

import com.abc.model.VendorRequest
import com.abc.model.VendorResponse
import com.abc.model.zumigo.ZumigoRequest
import com.abc.model.zumigo.ZumigoResponse
import com.abc.vendor.VendorDAO
import org.springframework.stereotype.Service

@Service("zumigo")
class ZumigoDAO : VendorDAO {

    override fun makeRequest(request: VendorRequest): VendorResponse {
        request as ZumigoRequest
        return ZumigoResponse(isDeviceTrusted = true, uuid = request.uuid, userId = request.userId)
    }

}