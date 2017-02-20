package com.abc.model.decision;

import com.abc.model.rest.RuleDTO;
import com.google.gson.Gson;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@Entity(name = Rule.TABLE_NAME)
public class Rule {

    static final String TABLE_NAME = "rules";

    private static final Gson GSON = new Gson();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "emailage_score")
    private String emailageScore = "[]";
    @Column(name = "emailage_country")
    private String emailageCountry = "[]";
    @Column(name = "emailage_country_not_eq")
    private String emailageCountryNotEQ = "[]";
    @Column(name = "zumigo_fn")
    private String zumigoFN = "[]";
    @Column(name = "zumigo_ln")
    private String zumigoLN = "[]";
    @Column(name = "zumigo_adress")
    private String zumigoAdress = "[]";
    @Column
    private int score;
    @Column
    private OffsetDateTime time = OffsetDateTime.now();

    public Rule(List<MaxMin> emailageScore, List<String> emailageCountry, List<String> emailageCountryNotEQ,
                List<MaxMin> zumigoFN, List<MaxMin> zumigoLN, List<MaxMin> zumigoAdress, int score, int userId) {
        this.emailageScore = emailageScore == null ? "[]" : GSON.toJson(emailageScore);
        this.emailageCountry = emailageCountry == null ? "[]" : GSON.toJson(emailageCountry);
        this.emailageCountryNotEQ = emailageCountryNotEQ == null ? "[]" : GSON.toJson(emailageCountryNotEQ);
        this.zumigoFN = zumigoFN == null ? "[]" : GSON.toJson(zumigoFN);
        this.zumigoLN = zumigoLN == null ? "[]" : GSON.toJson(zumigoLN);
        this.zumigoAdress = zumigoAdress == null ? "[]" : GSON.toJson(zumigoAdress);
        this.score = score;
        this.userId = userId;
    }

    public Rule() {
    }

    public Rule(RuleDTO ruleDTO) {
        setEmailageCountry(ruleDTO.getEmailageCountry());
        setEmailageCountryNotEQ(ruleDTO.getEmailageCountryNotEQ());
        setEmailageScore(ruleDTO.getEmailageScore());
        setZumigoAdress(ruleDTO.getZumigoAdress());
        setZumigoFN(ruleDTO.getZumigoFN());
        setZumigoLN(ruleDTO.getZumigoLN());
        setScore(ruleDTO.getScore());
        setUserId(ruleDTO.getUser_id());
    }

    public boolean accept(RuleRequest ruleRequest) {
        return (getEmailageScore().isEmpty() || ruleRequest.getEmailageScore() != null) && (getEmailageScore().isEmpty() || getEmailageScore().stream().anyMatch(it -> it.getMax() >= ruleRequest.getEmailageScore()
                && it.getMin() <= ruleRequest.getEmailageScore())) &&
                (getEmailageCountry().isEmpty() || ruleRequest.getEmailageCountry() != null) &&
                (getEmailageCountry().isEmpty() || getEmailageCountry().stream().anyMatch(it -> it.equals(ruleRequest.getEmailageCountry()))) &&
                (getEmailageCountryNotEQ().isEmpty() || ruleRequest.getEmailageCountry() != null) &&
                (getEmailageCountryNotEQ().isEmpty() || getEmailageCountryNotEQ().stream().noneMatch(it -> it.equals(ruleRequest.getEmailageCountry()))) &&
                (getZumigoFN().isEmpty() || ruleRequest.getZumigoFN() != null) &&
                (getZumigoFN().isEmpty() || getZumigoFN().stream().anyMatch(it -> it.getMax() >= ruleRequest.getZumigoFN() && it.getMin() <= ruleRequest.getZumigoFN())) &&
                (getZumigoLN().isEmpty() || ruleRequest.getZumigoLN() != null) &&
                (getZumigoLN().isEmpty() || getZumigoLN().stream().anyMatch(it -> it.getMax() >= ruleRequest.getZumigoLN() && it.getMin() <= ruleRequest.getZumigoLN())) &&
                (getZumigoAdress().isEmpty() || ruleRequest.getZumigoAdress() != null) &&
                (getZumigoAdress().isEmpty() || getZumigoAdress().stream().anyMatch(it -> it.getMax() >= ruleRequest.getZumigoAdress() && it.getMin() <= ruleRequest.getZumigoAdress()));
    }

    public List<MaxMin> getEmailageScore() {
        return Arrays.asList(GSON.fromJson(emailageScore, MaxMin[].class));
    }

    public void setEmailageScore(List<MaxMin> emailageScore) {
        this.emailageScore = emailageScore == null ? "[]" : GSON.toJson(emailageScore);
    }

    public List<String> getEmailageCountry() {
        return Arrays.asList(GSON.fromJson(emailageCountry, String[].class));
    }

    public void setEmailageCountry(List<String> emailageCountry) {
        this.emailageCountry = emailageCountry == null ? "[]" : GSON.toJson(emailageCountry);
    }

    public List<String> getEmailageCountryNotEQ() {
        return Arrays.asList(GSON.fromJson(emailageCountryNotEQ, String[].class));
    }

    public void setEmailageCountryNotEQ(List<String> emailageCountryNotEQ) {
        this.emailageCountryNotEQ = emailageCountryNotEQ == null ? "[]" : GSON.toJson(emailageCountryNotEQ);
    }

    public List<MaxMin> getZumigoFN() {
        return Arrays.asList(GSON.fromJson(zumigoFN, MaxMin[].class));
    }

    public void setZumigoFN(List<MaxMin> zumigoFN) {
        this.zumigoFN = zumigoFN == null ? "[]" : GSON.toJson(zumigoFN);
    }

    public List<MaxMin> getZumigoLN() {
        return Arrays.asList(GSON.fromJson(zumigoLN, MaxMin[].class));
    }

    public void setZumigoLN(List<MaxMin> zumigoLN) {
        this.zumigoLN = zumigoLN == null ? "[]" : GSON.toJson(zumigoLN);
    }

    public List<MaxMin> getZumigoAdress() {
        return Arrays.asList(GSON.fromJson(zumigoAdress, MaxMin[].class));
    }

    public void setZumigoAdress(List<MaxMin> zumigoAdress) {
        this.zumigoAdress = zumigoAdress == null ? "[]" : GSON.toJson(zumigoAdress);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        if (score != rule.score) return false;
        if (emailageScore != null ? !emailageScore.equals(rule.emailageScore) : rule.emailageScore != null)
            return false;
        if (emailageCountry != null ? !emailageCountry.equals(rule.emailageCountry) : rule.emailageCountry != null)
            return false;
        if (emailageCountryNotEQ != null ? !emailageCountryNotEQ.equals(rule.emailageCountryNotEQ) : rule.emailageCountryNotEQ != null)
            return false;
        if (zumigoFN != null ? !zumigoFN.equals(rule.zumigoFN) : rule.zumigoFN != null) return false;
        if (zumigoLN != null ? !zumigoLN.equals(rule.zumigoLN) : rule.zumigoLN != null) return false;
        return zumigoAdress != null ? zumigoAdress.equals(rule.zumigoAdress) : rule.zumigoAdress == null;
    }

    @Override
    public int hashCode() {
        int result = emailageScore != null ? emailageScore.hashCode() : 0;
        result = 31 * result + (emailageCountry != null ? emailageCountry.hashCode() : 0);
        result = 31 * result + (emailageCountryNotEQ != null ? emailageCountryNotEQ.hashCode() : 0);
        result = 31 * result + (zumigoFN != null ? zumigoFN.hashCode() : 0);
        result = 31 * result + (zumigoLN != null ? zumigoLN.hashCode() : 0);
        result = 31 * result + (zumigoAdress != null ? zumigoAdress.hashCode() : 0);
        result = 31 * result + score;
        return result;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmailageScore(String emailageScore) {
        this.emailageScore = emailageScore;
    }

    public void setEmailageCountry(String emailageCountry) {
        this.emailageCountry = emailageCountry;
    }

    public void setEmailageCountryNotEQ(String emailageCountryNotEQ) {
        this.emailageCountryNotEQ = emailageCountryNotEQ;
    }

    public void setZumigoFN(String zumigoFN) {
        this.zumigoFN = zumigoFN;
    }

    public void setZumigoLN(String zumigoLN) {
        this.zumigoLN = zumigoLN;
    }

    public void setZumigoAdress(String zumigoAdress) {
        this.zumigoAdress = zumigoAdress;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public static class MaxMin {

        private int max;
        private int min;

        public MaxMin(int max, int min) {
            this.max = max;
            this.min = min;
        }

        public MaxMin() {
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

}
