package com.abc.model.rest;

import com.abc.model.decision.Rule;

import javax.persistence.Column;
import java.util.List;

public class RuleDTO {

    private int user_id;
    private List<Rule.MaxMin> emailageScore;
    private List<String> emailageCountry;
    private List<String> emailageCountryNotEQ;
    private List<Rule.MaxMin> zumigoFN;
    private List<Rule.MaxMin> zumigoLN;
    private List<Rule.MaxMin> zumigoAdress;
    private int score;

    public RuleDTO(int user_id, List<Rule.MaxMin> emailageScore, List<String> emailageCountry,
                   List<String> emailageCountryNotEQ, List<Rule.MaxMin> zumigoFN, List<Rule.MaxMin> zumigoLN,
                   List<Rule.MaxMin> zumigoAdress, int score) {
        this.user_id = user_id;
        this.emailageScore = emailageScore;
        this.emailageCountry = emailageCountry;
        this.emailageCountryNotEQ = emailageCountryNotEQ;
        this.zumigoFN = zumigoFN;
        this.zumigoLN = zumigoLN;
        this.zumigoAdress = zumigoAdress;
        this.score = score;
    }

    public RuleDTO() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Rule.MaxMin> getEmailageScore() {
        return emailageScore;
    }

    public void setEmailageScore(List<Rule.MaxMin> emailageScore) {
        this.emailageScore = emailageScore;
    }

    public List<String> getEmailageCountry() {
        return emailageCountry;
    }

    public void setEmailageCountry(List<String> emailageCountry) {
        this.emailageCountry = emailageCountry;
    }

    public List<String> getEmailageCountryNotEQ() {
        return emailageCountryNotEQ;
    }

    public void setEmailageCountryNotEQ(List<String> emailageCountryNotEQ) {
        this.emailageCountryNotEQ = emailageCountryNotEQ;
    }

    public List<Rule.MaxMin> getZumigoFN() {
        return zumigoFN;
    }

    public void setZumigoFN(List<Rule.MaxMin> zumigoFN) {
        this.zumigoFN = zumigoFN;
    }

    public List<Rule.MaxMin> getZumigoLN() {
        return zumigoLN;
    }

    public void setZumigoLN(List<Rule.MaxMin> zumigoLN) {
        this.zumigoLN = zumigoLN;
    }

    public List<Rule.MaxMin> getZumigoAdress() {
        return zumigoAdress;
    }

    public void setZumigoAdress(List<Rule.MaxMin> zumigoAdress) {
        this.zumigoAdress = zumigoAdress;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
