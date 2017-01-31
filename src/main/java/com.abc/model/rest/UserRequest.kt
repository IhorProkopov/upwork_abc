package com.abc.model.rest

import com.abc.model.RequestData
import com.abc.model.ServiceType

data class UserRequest(val serviceType: ServiceType, val data: RequestData, val async: Boolean)