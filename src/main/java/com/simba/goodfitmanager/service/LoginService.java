package com.simba.goodfitmanager.service;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.pojo.Account;

public interface LoginService {
    Response login(String name, String password);


    Response register(Account account);
}
