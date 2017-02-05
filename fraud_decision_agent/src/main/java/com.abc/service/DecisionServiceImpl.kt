package com.abc.service

import com.abc.dao.RulesDao
import com.abc.model.VendorResponse
import com.abc.model.decision.Rule
import com.abc.model.decision.RuleRequest
import com.abc.model.rest.DecisionResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DecisionServiceImpl : DecisionService {

    @Autowired
    private lateinit var rulesDao: RulesDao

    override fun makeDecision(vendorResponses: Array<VendorResponse>): DecisionResponse {
        val rules = rulesDao.getUsersRule(vendorResponses[0].userId)
        val ruleRequest = RuleRequest(vendorResponses)
        return makeDecision(ruleRequest, rules, vendorResponses[0].uuid)
    }

    private fun makeDecision(ruleRequest: RuleRequest, rules: List<Rule>, uuid: UUID): DecisionResponse {
        val res = rules.find { it.accept(ruleRequest) }?.score ?: 0
        return DecisionResponse(res, uuid)
    }

}