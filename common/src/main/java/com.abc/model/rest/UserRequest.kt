package com.abc.model.rest

import com.abc.model.ServiceType
import java.util.*

data class UserRequest(val email:String, val phoneNumber:String, val serviceType: List<ServiceType>,
                       val async: Boolean, val uuid: UUID = UUID.randomUUID())