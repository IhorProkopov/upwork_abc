package com.abc.model

import java.util.*

data class ErrorResponse(val message: String, val code: Int, val uuid: UUID)