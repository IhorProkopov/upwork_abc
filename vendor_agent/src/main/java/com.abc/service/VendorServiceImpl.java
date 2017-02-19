package com.abc.service;

import com.abc.model.VendorResponse;
import com.abc.model.emailage.EmailAgeRequest;
import com.abc.model.rest.UserRequest;
import com.abc.model.zumigo.ZumigoRequest;
import com.abc.vendor.VendorDAO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("emailage")
    private VendorDAO emailageDAO;

    @Autowired
    @Qualifier("zumigo")
    private VendorDAO zumigoDAO;

    @Autowired
    private ExecutorService executorService;

    @Override
    public VendorResponse[] processRequest(UserRequest request) {
        List<Future<VendorResponse>> futures = request.getServiceType().stream().map(st -> {
            switch (st) {
                case emailage:
                    return StringUtils.isNotBlank(request.getEmail()) ?
                            executorService.submit(() -> emailageDAO.makeRequest(new EmailAgeRequest(request.getEmail(), request.getUuid(), request.getUserId()))) :
                            null;
                case zumigo:
                    return StringUtils.isNotBlank(request.getPhoneNumber()) ?
                            executorService.submit(() -> zumigoDAO.makeRequest(new ZumigoRequest(request.getUuid(), request.getUserId(), request.getPhoneNumber()))) :
                            null;
                default:
                    return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
        VendorResponse[] res = new VendorResponse[futures.size()];
        for (int x = 0; x < futures.size(); x++) {
            try {
                res[x] = futures.get(x).get();
                res[x].setShowVendorResponse(request.isShowVendorResponse());
            } catch (InterruptedException | ExecutionException e) {
                log.warn("Cannot get vendor response", e);
            }
        }
        return res;
    }


}