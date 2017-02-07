package com.abc.model.vendor;

import com.abc.model.VendorResponse;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 07.02.2017.
 */
public class EmailAgeResponse extends VendorResponse{

    private Query query;
     private ResponseStatus responseStatus;


    public EmailAgeResponse(UUID uuid, String userId, Query query, ResponseStatus responseStatus) {
        super(uuid, userId);
        this.responseStatus = responseStatus;
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public class ResponseStatus {

        private String status;
        private String errorCode;
        private String description;

        public ResponseStatus(String status, String errorCode, String description) {
            this.status = status;
            this.errorCode = errorCode;
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class Results {

        private String email;
        private String ipaddress;
        private String eName;
        private String emailAge;
        private String domainAge;
        private String firstVerificationDate;
        private String lastVerificationDate;
        private String status;
        private String country;
        private String fraudRisk;
        private String EAScore;
        private String EAReason;
        private String EAStatusID;
        private String EAReasonID;
        private String EAAdviceID;
        private String EAAdvice;
        private String EARiskBandID;
        private String EARiskBand;
        private String source_industry;
        private String fraud_type;
        private String location;
        private String smfriends;
        private String totalhits;
        private String uniquehits;
        private String imageurl;
        private String emailExists;
        private String domainExists;
        private String company;
        private String title;
        private String domainname;
        private String domaincompany;
        private String domaincountryname;
        private String domaincategory;
        private String domaincorporate;
        private String domainrisklevel;
        private String domainrelevantinfo;
        private String domainrisklevelID;
        private String domainrelevantinfoID;
        private String ip_risklevelid;
        private String ip_risklevel;
        private String ip_riskreasonid;
        private String ip_riskreason;
        private String ip_reputation;
        private String ip_anonymousdetected;
        private String ip_isp;
        private String ip_org;
        private String ip_userType;
        private String ip_netSpeedCell;
        private String ip_corporateProxy;
        private String ip_continentCode;
        private String ip_country;
        private String ip_countryCode;
        private String ip_region;
        private String ip_city;
        private String ip_callingcode;
        private String ip_metroCode;
        private String ip_latitude;
        private String ip_longitude;
        private String ip_map;
        private String ipcountrymatch;
        private String ipriskcountry;
        private String ipdistancekm;
        private String ipdistancemil;
        private String ipaccuracyradius;
        private String iptimezone;
        private String ipasnum;
        private String ipdomain;
        private String custphoneInbillingloc;
        private String shipforward;
        private String citypostalmatch;
        private String shipcitypostalmatch;
        private List<Object> smlinks;

        public Results(String email, String ipaddress, String eName, String emailAge, String domainAge,
                       String firstVerificationDate, String lastVerificationDate, String status, String country,
                       String fraudRisk, String EAScore, String EAReason, String EAStatusID, String EAReasonID,
                       String EAAdviceID, String EAAdvice, String EARiskBandID, String EARiskBand,
                       String source_industry, String fraud_type, String location, String smfriends, String totalhits,
                       String uniquehits, String imageurl, String emailExists, String domainExists, String company,
                       String title, String domainname, String domaincompany, String domaincountryname,
                       String domaincategory, String domaincorporate, String domainrisklevel, String domainrelevantinfo,
                       String domainrisklevelID, String domainrelevantinfoID, String ip_risklevelid, String ip_risklevel,
                       String ip_riskreasonid, String ip_riskreason, String ip_reputation, String ip_anonymousdetected,
                       String ip_isp, String ip_org, String ip_userType, String ip_netSpeedCell, String ip_corporateProxy,
                       String ip_continentCode, String ip_country, String ip_countryCode, String ip_region, String ip_city,
                       String ip_callingcode, String ip_metroCode, String ip_latitude, String ip_longitude, String ip_map,
                       String ipcountrymatch, String ipriskcountry, String ipdistancekm, String ipdistancemil,
                       String ipaccuracyradius, String iptimezone, String ipasnum, String ipdomain,
                       String custphoneInbillingloc, String shipforward, String citypostalmatch,
                       String shipcitypostalmatch, List<Object> smlinks) {
            this.email = email;
            this.ipaddress = ipaddress;
            this.eName = eName;
            this.emailAge = emailAge;
            this.domainAge = domainAge;
            this.firstVerificationDate = firstVerificationDate;
            this.lastVerificationDate = lastVerificationDate;
            this.status = status;
            this.country = country;
            this.fraudRisk = fraudRisk;
            this.EAScore = EAScore;
            this.EAReason = EAReason;
            this.EAStatusID = EAStatusID;
            this.EAReasonID = EAReasonID;
            this.EAAdviceID = EAAdviceID;
            this.EAAdvice = EAAdvice;
            this.EARiskBandID = EARiskBandID;
            this.EARiskBand = EARiskBand;
            this.source_industry = source_industry;
            this.fraud_type = fraud_type;
            this.location = location;
            this.smfriends = smfriends;
            this.totalhits = totalhits;
            this.uniquehits = uniquehits;
            this.imageurl = imageurl;
            this.emailExists = emailExists;
            this.domainExists = domainExists;
            this.company = company;
            this.title = title;
            this.domainname = domainname;
            this.domaincompany = domaincompany;
            this.domaincountryname = domaincountryname;
            this.domaincategory = domaincategory;
            this.domaincorporate = domaincorporate;
            this.domainrisklevel = domainrisklevel;
            this.domainrelevantinfo = domainrelevantinfo;
            this.domainrisklevelID = domainrisklevelID;
            this.domainrelevantinfoID = domainrelevantinfoID;
            this.ip_risklevelid = ip_risklevelid;
            this.ip_risklevel = ip_risklevel;
            this.ip_riskreasonid = ip_riskreasonid;
            this.ip_riskreason = ip_riskreason;
            this.ip_reputation = ip_reputation;
            this.ip_anonymousdetected = ip_anonymousdetected;
            this.ip_isp = ip_isp;
            this.ip_org = ip_org;
            this.ip_userType = ip_userType;
            this.ip_netSpeedCell = ip_netSpeedCell;
            this.ip_corporateProxy = ip_corporateProxy;
            this.ip_continentCode = ip_continentCode;
            this.ip_country = ip_country;
            this.ip_countryCode = ip_countryCode;
            this.ip_region = ip_region;
            this.ip_city = ip_city;
            this.ip_callingcode = ip_callingcode;
            this.ip_metroCode = ip_metroCode;
            this.ip_latitude = ip_latitude;
            this.ip_longitude = ip_longitude;
            this.ip_map = ip_map;
            this.ipcountrymatch = ipcountrymatch;
            this.ipriskcountry = ipriskcountry;
            this.ipdistancekm = ipdistancekm;
            this.ipdistancemil = ipdistancemil;
            this.ipaccuracyradius = ipaccuracyradius;
            this.iptimezone = iptimezone;
            this.ipasnum = ipasnum;
            this.ipdomain = ipdomain;
            this.custphoneInbillingloc = custphoneInbillingloc;
            this.shipforward = shipforward;
            this.citypostalmatch = citypostalmatch;
            this.shipcitypostalmatch = shipcitypostalmatch;
            this.smlinks = smlinks;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIpaddress() {
            return ipaddress;
        }

        public void setIpaddress(String ipaddress) {
            this.ipaddress = ipaddress;
        }

        public String geteName() {
            return eName;
        }

        public void seteName(String eName) {
            this.eName = eName;
        }

        public String getEmailAge() {
            return emailAge;
        }

        public void setEmailAge(String emailAge) {
            this.emailAge = emailAge;
        }

        public String getDomainAge() {
            return domainAge;
        }

        public void setDomainAge(String domainAge) {
            this.domainAge = domainAge;
        }

        public String getFirstVerificationDate() {
            return firstVerificationDate;
        }

        public void setFirstVerificationDate(String firstVerificationDate) {
            this.firstVerificationDate = firstVerificationDate;
        }

        public String getLastVerificationDate() {
            return lastVerificationDate;
        }

        public void setLastVerificationDate(String lastVerificationDate) {
            this.lastVerificationDate = lastVerificationDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getFraudRisk() {
            return fraudRisk;
        }

        public void setFraudRisk(String fraudRisk) {
            this.fraudRisk = fraudRisk;
        }

        public String getEAScore() {
            return EAScore;
        }

        public void setEAScore(String EAScore) {
            this.EAScore = EAScore;
        }

        public String getEAReason() {
            return EAReason;
        }

        public void setEAReason(String EAReason) {
            this.EAReason = EAReason;
        }

        public String getEAStatusID() {
            return EAStatusID;
        }

        public void setEAStatusID(String EAStatusID) {
            this.EAStatusID = EAStatusID;
        }

        public String getEAReasonID() {
            return EAReasonID;
        }

        public void setEAReasonID(String EAReasonID) {
            this.EAReasonID = EAReasonID;
        }

        public String getEAAdviceID() {
            return EAAdviceID;
        }

        public void setEAAdviceID(String EAAdviceID) {
            this.EAAdviceID = EAAdviceID;
        }

        public String getEAAdvice() {
            return EAAdvice;
        }

        public void setEAAdvice(String EAAdvice) {
            this.EAAdvice = EAAdvice;
        }

        public String getEARiskBandID() {
            return EARiskBandID;
        }

        public void setEARiskBandID(String EARiskBandID) {
            this.EARiskBandID = EARiskBandID;
        }

        public String getEARiskBand() {
            return EARiskBand;
        }

        public void setEARiskBand(String EARiskBand) {
            this.EARiskBand = EARiskBand;
        }

        public String getSource_industry() {
            return source_industry;
        }

        public void setSource_industry(String source_industry) {
            this.source_industry = source_industry;
        }

        public String getFraud_type() {
            return fraud_type;
        }

        public void setFraud_type(String fraud_type) {
            this.fraud_type = fraud_type;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSmfriends() {
            return smfriends;
        }

        public void setSmfriends(String smfriends) {
            this.smfriends = smfriends;
        }

        public String getTotalhits() {
            return totalhits;
        }

        public void setTotalhits(String totalhits) {
            this.totalhits = totalhits;
        }

        public String getUniquehits() {
            return uniquehits;
        }

        public void setUniquehits(String uniquehits) {
            this.uniquehits = uniquehits;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getEmailExists() {
            return emailExists;
        }

        public void setEmailExists(String emailExists) {
            this.emailExists = emailExists;
        }

        public String getDomainExists() {
            return domainExists;
        }

        public void setDomainExists(String domainExists) {
            this.domainExists = domainExists;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDomainname() {
            return domainname;
        }

        public void setDomainname(String domainname) {
            this.domainname = domainname;
        }

        public String getDomaincompany() {
            return domaincompany;
        }

        public void setDomaincompany(String domaincompany) {
            this.domaincompany = domaincompany;
        }

        public String getDomaincountryname() {
            return domaincountryname;
        }

        public void setDomaincountryname(String domaincountryname) {
            this.domaincountryname = domaincountryname;
        }

        public String getDomaincategory() {
            return domaincategory;
        }

        public void setDomaincategory(String domaincategory) {
            this.domaincategory = domaincategory;
        }

        public String getDomaincorporate() {
            return domaincorporate;
        }

        public void setDomaincorporate(String domaincorporate) {
            this.domaincorporate = domaincorporate;
        }

        public String getDomainrisklevel() {
            return domainrisklevel;
        }

        public void setDomainrisklevel(String domainrisklevel) {
            this.domainrisklevel = domainrisklevel;
        }

        public String getDomainrelevantinfo() {
            return domainrelevantinfo;
        }

        public void setDomainrelevantinfo(String domainrelevantinfo) {
            this.domainrelevantinfo = domainrelevantinfo;
        }

        public String getDomainrisklevelID() {
            return domainrisklevelID;
        }

        public void setDomainrisklevelID(String domainrisklevelID) {
            this.domainrisklevelID = domainrisklevelID;
        }

        public String getDomainrelevantinfoID() {
            return domainrelevantinfoID;
        }

        public void setDomainrelevantinfoID(String domainrelevantinfoID) {
            this.domainrelevantinfoID = domainrelevantinfoID;
        }

        public String getIp_risklevelid() {
            return ip_risklevelid;
        }

        public void setIp_risklevelid(String ip_risklevelid) {
            this.ip_risklevelid = ip_risklevelid;
        }

        public String getIp_risklevel() {
            return ip_risklevel;
        }

        public void setIp_risklevel(String ip_risklevel) {
            this.ip_risklevel = ip_risklevel;
        }

        public String getIp_riskreasonid() {
            return ip_riskreasonid;
        }

        public void setIp_riskreasonid(String ip_riskreasonid) {
            this.ip_riskreasonid = ip_riskreasonid;
        }

        public String getIp_riskreason() {
            return ip_riskreason;
        }

        public void setIp_riskreason(String ip_riskreason) {
            this.ip_riskreason = ip_riskreason;
        }

        public String getIp_reputation() {
            return ip_reputation;
        }

        public void setIp_reputation(String ip_reputation) {
            this.ip_reputation = ip_reputation;
        }

        public String getIp_anonymousdetected() {
            return ip_anonymousdetected;
        }

        public void setIp_anonymousdetected(String ip_anonymousdetected) {
            this.ip_anonymousdetected = ip_anonymousdetected;
        }

        public String getIp_isp() {
            return ip_isp;
        }

        public void setIp_isp(String ip_isp) {
            this.ip_isp = ip_isp;
        }

        public String getIp_org() {
            return ip_org;
        }

        public void setIp_org(String ip_org) {
            this.ip_org = ip_org;
        }

        public String getIp_userType() {
            return ip_userType;
        }

        public void setIp_userType(String ip_userType) {
            this.ip_userType = ip_userType;
        }

        public String getIp_netSpeedCell() {
            return ip_netSpeedCell;
        }

        public void setIp_netSpeedCell(String ip_netSpeedCell) {
            this.ip_netSpeedCell = ip_netSpeedCell;
        }

        public String getIp_corporateProxy() {
            return ip_corporateProxy;
        }

        public void setIp_corporateProxy(String ip_corporateProxy) {
            this.ip_corporateProxy = ip_corporateProxy;
        }

        public String getIp_continentCode() {
            return ip_continentCode;
        }

        public void setIp_continentCode(String ip_continentCode) {
            this.ip_continentCode = ip_continentCode;
        }

        public String getIp_country() {
            return ip_country;
        }

        public void setIp_country(String ip_country) {
            this.ip_country = ip_country;
        }

        public String getIp_countryCode() {
            return ip_countryCode;
        }

        public void setIp_countryCode(String ip_countryCode) {
            this.ip_countryCode = ip_countryCode;
        }

        public String getIp_region() {
            return ip_region;
        }

        public void setIp_region(String ip_region) {
            this.ip_region = ip_region;
        }

        public String getIp_city() {
            return ip_city;
        }

        public void setIp_city(String ip_city) {
            this.ip_city = ip_city;
        }

        public String getIp_callingcode() {
            return ip_callingcode;
        }

        public void setIp_callingcode(String ip_callingcode) {
            this.ip_callingcode = ip_callingcode;
        }

        public String getIp_metroCode() {
            return ip_metroCode;
        }

        public void setIp_metroCode(String ip_metroCode) {
            this.ip_metroCode = ip_metroCode;
        }

        public String getIp_latitude() {
            return ip_latitude;
        }

        public void setIp_latitude(String ip_latitude) {
            this.ip_latitude = ip_latitude;
        }

        public String getIp_longitude() {
            return ip_longitude;
        }

        public void setIp_longitude(String ip_longitude) {
            this.ip_longitude = ip_longitude;
        }

        public String getIp_map() {
            return ip_map;
        }

        public void setIp_map(String ip_map) {
            this.ip_map = ip_map;
        }

        public String getIpcountrymatch() {
            return ipcountrymatch;
        }

        public void setIpcountrymatch(String ipcountrymatch) {
            this.ipcountrymatch = ipcountrymatch;
        }

        public String getIpriskcountry() {
            return ipriskcountry;
        }

        public void setIpriskcountry(String ipriskcountry) {
            this.ipriskcountry = ipriskcountry;
        }

        public String getIpdistancekm() {
            return ipdistancekm;
        }

        public void setIpdistancekm(String ipdistancekm) {
            this.ipdistancekm = ipdistancekm;
        }

        public String getIpdistancemil() {
            return ipdistancemil;
        }

        public void setIpdistancemil(String ipdistancemil) {
            this.ipdistancemil = ipdistancemil;
        }

        public String getIpaccuracyradius() {
            return ipaccuracyradius;
        }

        public void setIpaccuracyradius(String ipaccuracyradius) {
            this.ipaccuracyradius = ipaccuracyradius;
        }

        public String getIptimezone() {
            return iptimezone;
        }

        public void setIptimezone(String iptimezone) {
            this.iptimezone = iptimezone;
        }

        public String getIpasnum() {
            return ipasnum;
        }

        public void setIpasnum(String ipasnum) {
            this.ipasnum = ipasnum;
        }

        public String getIpdomain() {
            return ipdomain;
        }

        public void setIpdomain(String ipdomain) {
            this.ipdomain = ipdomain;
        }

        public String getCustphoneInbillingloc() {
            return custphoneInbillingloc;
        }

        public void setCustphoneInbillingloc(String custphoneInbillingloc) {
            this.custphoneInbillingloc = custphoneInbillingloc;
        }

        public String getShipforward() {
            return shipforward;
        }

        public void setShipforward(String shipforward) {
            this.shipforward = shipforward;
        }

        public String getCitypostalmatch() {
            return citypostalmatch;
        }

        public void setCitypostalmatch(String citypostalmatch) {
            this.citypostalmatch = citypostalmatch;
        }

        public String getShipcitypostalmatch() {
            return shipcitypostalmatch;
        }

        public void setShipcitypostalmatch(String shipcitypostalmatch) {
            this.shipcitypostalmatch = shipcitypostalmatch;
        }

        public List<Object> getSmlinks() {
            return smlinks;
        }

        public void setSmlinks(List<Object> smlinks) {
            this.smlinks = smlinks;
        }
    }

    public static class Query {
        private String email;
        private String queryType;
        private int count;
        private String created;
        private String lang;
        private String responseCount;
        private List<Results> results;

        public Query(String email, String queryType, int count, String created, String lang, String responseCount, List<Results> results) {
            this.email = email;
            this.queryType = queryType;
            this.count = count;
            this.created = created;
            this.lang = lang;
            this.responseCount = responseCount;
            this.results = results;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQueryType() {
            return queryType;
        }

        public void setQueryType(String queryType) {
            this.queryType = queryType;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(String responseCount) {
            this.responseCount = responseCount;
        }

        public List<Results> getResults() {
            return results;
        }

        public void setResults(List<Results> results) {
            this.results = results;
        }
    }

}
