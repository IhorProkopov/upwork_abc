package com.abc.model.decision

data class Rule(val emailageScore: List<MaxMin>,
                val emailageCountry: List<String>,
                val emailageCountryNotEQ: List<String>,
                val zumigoFN: List<MaxMin>,
                val zumigoLN: List<MaxMin>,
                val zumigoAdress: List<MaxMin>,
                val score: Int) {

    fun accept(ruleRequest: RuleRequest): Boolean =
            emailageScore.any { it.max >= ruleRequest.emailageScore && it.min <= ruleRequest.emailageScore } &&
                    emailageCountry.any { it == ruleRequest.emailageCountry } &&
                    emailageCountryNotEQ.all { it != ruleRequest.emailageCountry } &&
                    zumigoFN.any { it.max >= ruleRequest.zumigoFN && it.min <= ruleRequest.zumigoFN } &&
                    zumigoLN.any { it.max >= ruleRequest.zumigoLN && it.min <= ruleRequest.zumigoLN } &&
                    zumigoAdress.any { it.max >= ruleRequest.zumigoAdress && it.min <= ruleRequest.zumigoAdress }
}

data class MaxMin(val max: Int, val min: Int)