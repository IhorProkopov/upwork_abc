package com.abc.model.decision;

import java.util.List;

public class Rule {

    private List<MaxMin> emailageScore;
    private List<String> emailageCountry;
    private List<String> emailageCountryNotEQ;
    private List<MaxMin> zumigoFN;
    private List<MaxMin> zumigoLN;
    private List<MaxMin> zumigoAdress;
    private int score;

    public Rule(List<MaxMin> emailageScore, List<String> emailageCountry, List<String> emailageCountryNotEQ,
                List<MaxMin> zumigoFN, List<MaxMin> zumigoLN, List<MaxMin> zumigoAdress, int score) {
        this.emailageScore = emailageScore;
        this.emailageCountry = emailageCountry;
        this.emailageCountryNotEQ = emailageCountryNotEQ;
        this.zumigoFN = zumigoFN;
        this.zumigoLN = zumigoLN;
        this.zumigoAdress = zumigoAdress;
        this.score = score;
    }

    public boolean accept(RuleRequest ruleRequest){
       return emailageScore.stream().anyMatch(it -> it.getMax() >= ruleRequest.getEmailageScore()
               && it.getMin() <= ruleRequest.getEmailageScore()) &&
       emailageCountry.stream().anyMatch(it -> it.equals(ruleRequest.getEmailageCountry())) &&
       emailageCountryNotEQ.stream().noneMatch(it -> it.equals(ruleRequest.getEmailageCountry())) &&
       zumigoFN.stream().anyMatch(it->it.getMax() >= ruleRequest.getZumigoFN() && it.getMin() <= ruleRequest.getZumigoFN()) &&
       zumigoLN.stream().anyMatch(it->it.getMax() >= ruleRequest.getZumigoLN() && it.getMin() <= ruleRequest.getZumigoLN()) &&
       zumigoAdress.stream().anyMatch(it-> it.getMax() >= ruleRequest.getZumigoAdress() && it.getMin() <= ruleRequest.getZumigoAdress());
    }

    public List<MaxMin> getEmailageScore() {
        return emailageScore;
    }

    public void setEmailageScore(List<MaxMin> emailageScore) {
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

    public List<MaxMin> getZumigoFN() {
        return zumigoFN;
    }

    public void setZumigoFN(List<MaxMin> zumigoFN) {
        this.zumigoFN = zumigoFN;
    }

    public List<MaxMin> getZumigoLN() {
        return zumigoLN;
    }

    public void setZumigoLN(List<MaxMin> zumigoLN) {
        this.zumigoLN = zumigoLN;
    }

    public List<MaxMin> getZumigoAdress() {
        return zumigoAdress;
    }

    public void setZumigoAdress(List<MaxMin> zumigoAdress) {
        this.zumigoAdress = zumigoAdress;
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

    public static class MaxMin{

        private int max;
        private int min;

        public MaxMin(int max, int min) {
            this.max = max;
            this.min = min;
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
