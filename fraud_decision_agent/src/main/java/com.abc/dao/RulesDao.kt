package com.abc.dao

import com.abc.model.decision.Rule

interface RulesDao {

    fun getUsersRule(userId: String): List<Rule>

}