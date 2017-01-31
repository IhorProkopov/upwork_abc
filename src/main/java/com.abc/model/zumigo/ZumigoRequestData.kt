package com.abc.model.zumigo

import com.abc.model.RequestData

data class ZumigoRequestData(val verificationMethod: String = "",
                             val verificationCode: String = "",
                             val optInMethod: String = "",
                             val optInTimestamp: String = "",
                             val optInId: String = "") : RequestData