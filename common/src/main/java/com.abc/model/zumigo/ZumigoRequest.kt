package com.abc.model.zumigo

import com.abc.model.VendorRequest
import java.util.*

class ZumigoRequest(val requestData: String, uuid: UUID, userId: String) : VendorRequest(uuid, userId)