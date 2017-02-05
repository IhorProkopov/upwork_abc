package com.abc.model.emailage

import com.abc.model.VendorRequest
import java.util.*

class EmailAgeRequest(val email: String, uuid: UUID, userId:String) : VendorRequest(uuid, userId)