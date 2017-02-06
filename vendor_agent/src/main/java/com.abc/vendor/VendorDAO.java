package com.abc.vendor;

import com.abc.model.VendorRequest;
import com.abc.model.VendorResponse;

public interface VendorDAO {

    VendorResponse makeRequest(VendorRequest request);

}
