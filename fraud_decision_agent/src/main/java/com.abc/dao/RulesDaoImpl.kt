package com.abc.dao

import com.abc.model.decision.Rule
import org.springframework.stereotype.Repository

@Repository
class RulesDaoImpl : RulesDao {
    override fun getUsersRule(userId: String): List<Rule> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}