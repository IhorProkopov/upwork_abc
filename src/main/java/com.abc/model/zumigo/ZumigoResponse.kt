package com.abc.model.zumigo

import com.abc.model.VendorResponse

data class ZumigoResponse(val isDeviceTrusted: Boolean,
                          val confidenceRatings: ConfidenceRatings = ConfidenceRatings(),
                          val customerDtls: CustomerDetails = CustomerDetails(),
                          val getLineIdentityResponse: GetLineIdentityResponse = GetLineIdentityResponse()) : VendorResponse

data class GetLineIdentityResponse(val mdn: String = "",
                                   val trxId: String = "",
                                   val subscriber: Subscriber = Subscriber(),
                                   val carrier: Map<String, String> = emptyMap(),
                                   val account: Account = Account(),
                                   val nameAddressValidation: NameAddressValidation = NameAddressValidation())

data class Subscriber(val firstName: String = "",
                      val lastName: String = "")

data class Account(val acctType: String = "",
                   val acctDuration: String = "",
                   val lineType: String = "",
                   val lineActivationDate: String = "",
                   val primaryAcctHolder: Boolean = false,
                   val serviceType: String = "",
                   val serviceStatus: String = "",
                   val billingAddress: Map<String, String> = emptyMap())

data class NameAddressValidation(val nameList: List<Map<String, String>> = emptyList(),
                                 val addressList: List<Map<String, String>> = emptyList())

data class CustomerDetails(val address: List<Map<String, String>> = emptyList(),
                           val customerInfo: List<CustomerInfo> = emptyList())

data class CustomerInfo(val customerName: Subscriber = Subscriber(),
                        val emailAddress: String = "",
                        val phoneNumber: List<Map<String, String>> = emptyList())

data class ConfidenceRatings(val firstNameScore: List<String> = emptyList(),
                             val lastNameScore: List<String> = emptyList(),
                             val addressScore: List<String> = emptyList())