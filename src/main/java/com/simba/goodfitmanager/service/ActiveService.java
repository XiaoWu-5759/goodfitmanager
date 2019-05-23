package com.simba.goodfitmanager.service;

import com.simba.goodfitmanager.common.Response;

public interface ActiveService {
    Response activeByOne(String icid);

    Response activeByTwo(String icid1, String icid2);
}
