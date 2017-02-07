package com.abc.model.decision;

import com.abc.model.VendorResponse;
import com.abc.model.vendor.EmailAgeResponse;
import com.abc.model.vendor.ZumigoResponse;

import java.util.List;

/**
 * Created by Ihor on 07.02.2017.
 */
public class RuleRequest {

    private int emailageScore;
    private String emailageCountry;
    private int zumigoFN;
    private int zumigoLN;
    private int zumigoAdress;

    public RuleRequest(VendorResponse[] vendorResponses){
        for (VendorResponse vendorResponse : vendorResponses) {
            if (vendorResponse instanceof EmailAgeResponse){
                List<EmailAgeResponse.Results> results = ((EmailAgeResponse) vendorResponse).getQuery().getResults();
                if (!results.isEmpty()) {
                    emailageScore = Integer.parseInt(results.get(0).getEAScore());
                    emailageCountry = results.get(0).getCountry();
                }
            }
            if (vendorResponse instanceof ZumigoResponse){
                zumigoAdress = Integer.parseInt(((ZumigoResponse) vendorResponse).getConfidenceRatings().getAddressScore().get(0));
                zumigoFN = Integer.parseInt(((ZumigoResponse) vendorResponse).getConfidenceRatings().getFirstNameScore().get(0));
                zumigoLN = Integer.parseInt(((ZumigoResponse) vendorResponse).getConfidenceRatings().getLastNameScore().get(0));
            }
        }
    }

    public RuleRequest(int emailageScore, String emailageCountry, int zumigoFN, int zumigoLN, int zumigoAdress) {
        this.emailageScore = emailageScore;
        this.emailageCountry = emailageCountry;
        this.zumigoFN = zumigoFN;
        this.zumigoLN = zumigoLN;
        this.zumigoAdress = zumigoAdress;
    }

    public int getEmailageScore() {
        return emailageScore;
    }

    public void setEmailageScore(int emailageScore) {
        this.emailageScore = emailageScore;
    }

    public String getEmailageCountry() {
        return emailageCountry;
    }

    public void setEmailageCountry(String emailageCountry) {
        this.emailageCountry = emailageCountry;
    }

    public int getZumigoFN() {
        return zumigoFN;
    }

    public void setZumigoFN(int zumigoFN) {
        this.zumigoFN = zumigoFN;
    }

    public int getZumigoLN() {
        return zumigoLN;
    }

    public void setZumigoLN(int zumigoLN) {
        this.zumigoLN = zumigoLN;
    }

    public int getZumigoAdress() {
        return zumigoAdress;
    }

    public void setZumigoAdress(int zumigoAdress) {
        this.zumigoAdress = zumigoAdress;
    }
}
