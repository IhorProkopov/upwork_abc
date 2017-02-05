package com.abc.dao

import com.abc.model.decision.MaxMin
import com.abc.model.decision.Rule
import org.springframework.stereotype.Repository

@Repository
class RulesDaoImpl : RulesDao {
    override fun getUsersRule(userId: String): List<Rule> {
        return listOf(Rule(listOf(MaxMin(100, 0)), listOf("US"), listOf("UA"), listOf(MaxMin(100, 0)),
                listOf(MaxMin(100, 0)), listOf(MaxMin(100, 0)), 100))
    }
}