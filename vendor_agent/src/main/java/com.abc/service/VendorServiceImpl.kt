package com.abc.service

import com.abc.model.ServiceType
import com.abc.model.VendorResponse
import com.abc.model.emailage.EmailAgeRequest
import com.abc.model.rest.UserRequest
import com.abc.model.zumigo.ZumigoRequest
import com.abc.vendor.VendorDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class VendorServiceImpl : VendorService {

    @Autowired
    @Qualifier("emailage")
    lateinit var emailageDAO: VendorDAO

    @Autowired
    @Qualifier("zumigo")
    lateinit var zumigoDAO: VendorDAO

    override fun processRequest(request: UserRequest): Array<VendorResponse> =
            request.serviceType.mapNotNullTo(ArrayList<VendorResponse>()) {
                when (it) {
                    ServiceType.emailage -> if (!request.email.isNullOrEmpty())
                        emailageDAO.makeRequest(EmailAgeRequest(request.email, request.uuid, request.userId)) else null
                    ServiceType.zumigo -> if (!request.phoneNumber.isNullOrEmpty())
                        zumigoDAO.makeRequest(ZumigoRequest(request.phoneNumber, request.uuid, request.userId)) else null
                    else -> null
                }
            }.toTypedArray()

}