package com.abc.service;

import com.abc.model.VendorResponse;
import com.abc.model.emailage.EmailAgeRequest;
import com.abc.model.rest.UserRequest;
import com.abc.model.zumigo.ZumigoRequest;
import com.abc.vendor.VendorDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    @Qualifier("emailage")
    private VendorDAO emailageDAO;

    @Autowired
    @Qualifier("zumigo")
    private VendorDAO zumigoDAO;

    @Override
    public VendorResponse[] processRequest(UserRequest request) {
        List<VendorResponse> res = request.getServiceType().stream().map(st -> {
            switch (st) {
                case emailage:
                    return StringUtils.isNotBlank(request.getEmail()) ?
                            emailageDAO.makeRequest(new EmailAgeRequest(request.getEmail(), request.getUuid(), request.getUserId())) :
                            null;
                case zumigo:
                    return StringUtils.isNotBlank(request.getPhoneNumber()) ?
                            zumigoDAO.makeRequest(new ZumigoRequest(request.getPhoneNumber(), request.getUuid(), request.getUserId())) : null;
                default:
                    return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
        return res.toArray(new VendorResponse[res.size()]);
    }


}