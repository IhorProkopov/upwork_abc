package com.abc.service;

import com.abc.dao.RulesDAO;
import com.abc.model.VendorResponse;
import com.abc.model.decision.Rule;
import com.abc.model.rest.DecisionResponse;
import com.abc.model.vendor.EmailAgeResponse;
import com.abc.model.vendor.ZumigoResponse;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DecisionServiceImplTest {

    private static final int USER_ID = 1;
    private static final UUID UUID = java.util.UUID.randomUUID();
    private static final String EMAIL = "qwer@qwer.qwer";
    private static final int SCORE = 10;
    private static final int BIG_SCORE = 20;

    @Mock
    private RulesDAO rulesDao;

    @InjectMocks
    private DecisionServiceImpl target = new DecisionServiceImpl();

    @Test
    public void shouldAcceptRule() {
        Rule rule = new Rule(newArrayList(new Rule.MaxMin(1000, 100)), newArrayList("US"), newArrayList("UK"),
                newArrayList(new Rule.MaxMin(100, 10)), newArrayList(new Rule.MaxMin(100, 10)),
                newArrayList(new Rule.MaxMin(100, 10)), SCORE, USER_ID);
        Mockito.when(rulesDao.findByUserId(USER_ID)).thenReturn(newArrayList(rule));

        List results = Lists.newArrayList(new EmailAgeResponse.Results(EMAIL, null, null, null,
                null, null, null, null, "US", null,
                "150", null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null));
        EmailAgeResponse emailAgeResponse = (new EmailAgeResponse(UUID, USER_ID, new EmailAgeResponse.Query(EMAIL, null, 0, null,
                null, null, results), null));
        emailAgeResponse.setShowVendorResponse(true);

        ZumigoResponse.ConfidenceRatings ratings = new ZumigoResponse.ConfidenceRatings(newArrayList("50"),
                newArrayList("50"), newArrayList("50"));
        ZumigoResponse zumigoResponse = new ZumigoResponse(UUID, USER_ID, true, ratings, null, null);
        zumigoResponse.setShowVendorResponse(true);

        DecisionResponse res = target.makeDecision(new VendorResponse[]{emailAgeResponse, zumigoResponse});
        assertNotNull(res);
        assertTrue(10 == res.getScore());
        assertEquals(UUID, res.getId());
        assertNotNull(res.getEmailAgeResponse());
        assertNotNull(res.getZumigoResponse());
    }

    @Test
    public void sholdNotAcceptAnyRules() {
        Rule rule = new Rule(newArrayList(new Rule.MaxMin(1000, 100)), newArrayList("US"), newArrayList("UK"),
                newArrayList(new Rule.MaxMin(100, 10)), newArrayList(new Rule.MaxMin(100, 10)),
                newArrayList(new Rule.MaxMin(100, 10)), SCORE, USER_ID);
        Mockito.when(rulesDao.findByUserId(USER_ID)).thenReturn(newArrayList(rule));

        List results = Lists.newArrayList(new EmailAgeResponse.Results(EMAIL, null, null, null,
                null, null, null, null, "UK", null,
                "150", null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null));
        EmailAgeResponse emailAgeResponse = (new EmailAgeResponse(UUID, USER_ID, new EmailAgeResponse.Query(EMAIL, null, 0, null,
                null, null, results), null));

        ZumigoResponse.ConfidenceRatings ratings = new ZumigoResponse.ConfidenceRatings(newArrayList("50"),
                newArrayList("50"), newArrayList("50"));
        ZumigoResponse zumigoResponse = new ZumigoResponse(UUID, USER_ID, true, ratings, null, null);

        DecisionResponse res = target.makeDecision(new VendorResponse[]{emailAgeResponse, zumigoResponse});
        assertNotNull(res);
        assertTrue(0 == res.getScore());
        assertEquals(UUID, res.getId());
        assertNull(res.getEmailAgeResponse());
        assertNull(res.getZumigoResponse());
    }

    @Test
    public void shouldUseRuleWithHighestRank(){
        Rule rule = new Rule(newArrayList(new Rule.MaxMin(1000, 100)), newArrayList("US"), newArrayList("UK"),
                newArrayList(new Rule.MaxMin(100, 10)), newArrayList(new Rule.MaxMin(100, 10)),
                newArrayList(new Rule.MaxMin(100, 10)), BIG_SCORE, USER_ID);
        Rule partialRule = new Rule(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                newArrayList(new Rule.MaxMin(100, 10)), newArrayList(new Rule.MaxMin(100, 10)),
                newArrayList(new Rule.MaxMin(100, 10)), SCORE, USER_ID);
        Mockito.when(rulesDao.findByUserId(USER_ID)).thenReturn(newArrayList(partialRule, rule));

        List results = Lists.newArrayList(new EmailAgeResponse.Results(EMAIL, null, null, null,
                null, null, null, null, "US", null,
                "150", null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null));
        EmailAgeResponse emailAgeResponse = (new EmailAgeResponse(UUID, USER_ID, new EmailAgeResponse.Query(EMAIL, null, 0, null,
                null, null, results), null));

        ZumigoResponse.ConfidenceRatings ratings = new ZumigoResponse.ConfidenceRatings(newArrayList("50"),
                newArrayList("50"), newArrayList("50"));
        ZumigoResponse zumigoResponse = new ZumigoResponse(UUID, USER_ID, true, ratings, null, null);

        DecisionResponse res = target.makeDecision(new VendorResponse[]{emailAgeResponse, zumigoResponse});
        assertNotNull(res);
        assertTrue(20 == res.getScore());
        assertEquals(UUID, res.getId());
        assertNull(res.getEmailAgeResponse());
        assertNull(res.getZumigoResponse());
    }

}
