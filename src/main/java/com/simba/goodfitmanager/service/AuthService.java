package com.simba.goodfitmanager.service;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.pojo.User;

public interface AuthService {
    Response authRegister(User user);
}
