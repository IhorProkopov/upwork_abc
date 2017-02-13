package com.abc.model.vendor;

import com.abc.model.VendorResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ZumigoResponse extends VendorResponse {

    private boolean isDeviceTrusted;
    private ConfidenceRatings confidenceRatings;
    private CustomerDetails customerDtls;
    private GetLineIdentityResponse getLineIdentityResponse;

    public ZumigoResponse(UUID uuid, int userId, boolean isDeviceTrusted, ConfidenceRatings confidenceRatings,
                          CustomerDetails customerDtls, GetLineIdentityResponse getLineIdentityResponse) {
        super(uuid, userId);
        this.isDeviceTrusted = isDeviceTrusted;
        this.confidenceRatings = confidenceRatings;
        this.customerDtls = customerDtls;
        this.getLineIdentityResponse = getLineIdentityResponse;

    }

    public boolean isDeviceTrusted() {
        return isDeviceTrusted;
    }

    public void setDeviceTrusted(boolean deviceTrusted) {
        isDeviceTrusted = deviceTrusted;
    }

    public ConfidenceRatings getConfidenceRatings() {
        return confidenceRatings;
    }

    public void setConfidenceRatings(ConfidenceRatings confidenceRatings) {
        this.confidenceRatings = confidenceRatings;
    }

    public CustomerDetails getCustomerDtls() {
        return customerDtls;
    }

    public void setCustomerDtls(CustomerDetails customerDtls) {
        this.customerDtls = customerDtls;
    }

    public GetLineIdentityResponse getGetLineIdentityResponse() {
        return getLineIdentityResponse;
    }

    public void setGetLineIdentityResponse(GetLineIdentityResponse getLineIdentityResponse) {
        this.getLineIdentityResponse = getLineIdentityResponse;
    }

    public static class ConfidenceRatings {
        private List<String> firstNameScore;
        private List<String> lastNameScore;
        private List<String> addressScore;

        public ConfidenceRatings(List<String> firstNameScore, List<String> lastNameScore, List<String> addressScore) {
            this.firstNameScore = firstNameScore;
            this.lastNameScore = lastNameScore;
            this.addressScore = addressScore;
        }

        public List<String> getFirstNameScore() {
            return firstNameScore;
        }

        public void setFirstNameScore(List<String> firstNameScore) {
            this.firstNameScore = firstNameScore;
        }

        public List<String> getLastNameScore() {
            return lastNameScore;
        }

        public void setLastNameScore(List<String> lastNameScore) {
            this.lastNameScore = lastNameScore;
        }

        public List<String> getAddressScore() {
            return addressScore;
        }

        public void setAddressScore(List<String> addressScore) {
            this.addressScore = addressScore;
        }
    }

    public class CustomerInfo {

        private Subscriber customerName;
        private String emailAddress;
        private List<Map<String, String>> phoneNumber;

        public CustomerInfo(Subscriber customerName, String emailAddress, List<Map<String, String>> phoneNumber) {
            this.customerName = customerName;
            this.emailAddress = emailAddress;
            this.phoneNumber = phoneNumber;
        }

        public Subscriber getCustomerName() {
            return customerName;
        }

        public void setCustomerName(Subscriber customerName) {
            this.customerName = customerName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public List<Map<String, String>> getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(List<Map<String, String>> phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    public class CustomerDetails {

        private List<Map<String, String>> address;
        private List<CustomerInfo> customerInfo;

        public CustomerDetails(List<Map<String, String>> address, List<CustomerInfo> customerInfo) {
            this.address = address;
            this.customerInfo = customerInfo;
        }

        public List<Map<String, String>> getAddress() {
            return address;
        }

        public void setAddress(List<Map<String, String>> address) {
            this.address = address;
        }

        public List<CustomerInfo> getCustomerInfo() {
            return customerInfo;
        }

        public void setCustomerInfo(List<CustomerInfo> customerInfo) {
            this.customerInfo = customerInfo;
        }
    }

    public class NameAddressValidation {
        private List<Map<String, String>> nameList;
        private List<Map<String, String>> addressList;

        public NameAddressValidation(List<Map<String, String>> nameList, List<Map<String, String>> addressList) {
            this.nameList = nameList;
            this.addressList = addressList;
        }

        public List<Map<String, String>> getNameList() {
            return nameList;
        }

        public void setNameList(List<Map<String, String>> nameList) {
            this.nameList = nameList;
        }

        public List<Map<String, String>> getAddressList() {
            return addressList;
        }

        public void setAddressList(List<Map<String, String>> addressList) {
            this.addressList = addressList;
        }
    }

    public class Account {
        private String acctType;
        private String acctDuration;
        private String lineType;
        private String lineActivationDate;
        private boolean primaryAcctHolder;
        private String serviceType;
        private String serviceStatus;
        private Map<String, String> billingAddress;

        public Account(String acctType, String acctDuration, String lineType, String lineActivationDate,
                       boolean primaryAcctHolder, String serviceType, String serviceStatus, Map<String, String> billingAddress) {
            this.acctType = acctType;
            this.acctDuration = acctDuration;
            this.lineType = lineType;
            this.lineActivationDate = lineActivationDate;
            this.primaryAcctHolder = primaryAcctHolder;
            this.serviceType = serviceType;
            this.serviceStatus = serviceStatus;
            this.billingAddress = billingAddress;
        }

        public String getAcctType() {
            return acctType;
        }

        public void setAcctType(String acctType) {
            this.acctType = acctType;
        }

        public String getAcctDuration() {
            return acctDuration;
        }

        public void setAcctDuration(String acctDuration) {
            this.acctDuration = acctDuration;
        }

        public String getLineType() {
            return lineType;
        }

        public void setLineType(String lineType) {
            this.lineType = lineType;
        }

        public String getLineActivationDate() {
            return lineActivationDate;
        }

        public void setLineActivationDate(String lineActivationDate) {
            this.lineActivationDate = lineActivationDate;
        }

        public boolean isPrimaryAcctHolder() {
            return primaryAcctHolder;
        }

        public void setPrimaryAcctHolder(boolean primaryAcctHolder) {
            this.primaryAcctHolder = primaryAcctHolder;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getServiceStatus() {
            return serviceStatus;
        }

        public void setServiceStatus(String serviceStatus) {
            this.serviceStatus = serviceStatus;
        }

        public Map<String, String> getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(Map<String, String> billingAddress) {
            this.billingAddress = billingAddress;
        }
    }

    public class Subscriber {
        private String firstName;
        private String lastName;

        public Subscriber(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public class GetLineIdentityResponse {
        private String mdn;
        private String trxId;
        private Subscriber subscriber;
        private Map<String, String> carrier;
        private Account account;
        private NameAddressValidation nameAddressValidation;

        public GetLineIdentityResponse(String mdn, String trxId, Subscriber subscriber, Map<String, String> carrier,
                                       Account account, NameAddressValidation nameAddressValidation) {
            this.mdn = mdn;
            this.trxId = trxId;
            this.subscriber = subscriber;
            this.carrier = carrier;
            this.account = account;
            this.nameAddressValidation = nameAddressValidation;
        }

        public String getMdn() {
            return mdn;
        }

        public void setMdn(String mdn) {
            this.mdn = mdn;
        }

        public String getTrxId() {
            return trxId;
        }

        public void setTrxId(String trxId) {
            this.trxId = trxId;
        }

        public Subscriber getSubscriber() {
            return subscriber;
        }

        public void setSubscriber(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        public Map<String, String> getCarrier() {
            return carrier;
        }

        public void setCarrier(Map<String, String> carrier) {
            this.carrier = carrier;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public NameAddressValidation getNameAddressValidation() {
            return nameAddressValidation;
        }

        public void setNameAddressValidation(NameAddressValidation nameAddressValidation) {
            this.nameAddressValidation = nameAddressValidation;
        }
    }

}
