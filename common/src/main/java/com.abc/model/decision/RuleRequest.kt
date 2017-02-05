package com.abc.model.decision

import com.abc.model.VendorResponse
import com.abc.model.vendor.EmailAgeResponse
import com.abc.model.vendor.ZumigoResponse

class RuleRequest(vendorResponses: Array<VendorResponse>) {

    var emailageScore: Int = 0
    var emailageCountry: String = ""
    var zumigoFN: Int = 0
    var zumigoLN: Int = 0
    var zumigoAdress: Int = 0

    init {
        for (vendorResponse in vendorResponses) {
            when (vendorResponse) {
                is EmailAgeResponse -> {
                    val results = vendorResponse.query.results
                    if (results.isNotEmpty()) {
                        emailageScore = results[0].EAScore.toInt()
                        emailageCountry = results[0].country
                    }
                }
                is ZumigoResponse -> {
                    zumigoAdress = vendorResponse.confidenceRatings.addressScore[0].toInt()
                    zumigoFN = vendorResponse.confidenceRatings.firstNameScore[0].toInt()
                    zumigoLN = vendorResponse.confidenceRatings.lastNameScore[0].toInt()
                }
            }
        }
    }

}