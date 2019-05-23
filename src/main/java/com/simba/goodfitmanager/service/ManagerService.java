package com.simba.goodfitmanager.service;

import com.simba.goodfitmanager.common.Response;

public interface ManagerService {
    Response updateType(String icid, int type);

    Response queryByStyle(String style, String content, int pageNum, int pageSize);

    Response uploadExcel(String uploadFileName) throws Exception;
}
