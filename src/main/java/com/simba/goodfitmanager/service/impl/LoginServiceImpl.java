package com.simba.goodfitmanager.service.impl;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.dao.AccountMapper;
import com.simba.goodfitmanager.pojo.Account;
import com.simba.goodfitmanager.pojo.AccountExample;
import com.simba.goodfitmanager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Response login(String name, String password) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria accountExampleCriteria = accountExample.createCriteria();
        accountExampleCriteria.andAccountNameEqualTo(name);
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if (accountList.size() == 0) {
            return ResponseGenerator.genErrorReponse("用户不存在");
        }
        accountExampleCriteria.andPasswordEqualTo(password);
        accountList = accountMapper.selectByExample(accountExample);
        if (accountList.size() == 0) {
            return ResponseGenerator.genErrorReponse("用户账号不匹配");
        }
        // 封装result
        Map<String,Object> result = new HashMap();
        result.put("accountName",accountList.get(0).getAccountName());
        String role = null;
        switch (accountList.get(0).getRole()){
            case 1:
                role = "4s";
                break;
            case 2:
                role = "admin";
                break;
            default:
                break;
        }
        result.put("role",role);
        // TODO: Token 缺少
        result.put("Token",null);
        return ResponseGenerator.genSucessReponse(result,"登录成功");

    }

    @Override
    public Response register(Account account) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria accountExampleCriteria = accountExample.createCriteria();
        accountExampleCriteria.andAccountNameEqualTo(account.getAccountName());
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if (accountList.size() != 0) {
            return ResponseGenerator.genErrorReponse("账户已存在");
        }
        accountMapper.insertSelective(account);
        // 封装结果集
        Map<String,Object> result = new HashMap<>();
        result.put("accountName",account.getAccountName());
        return ResponseGenerator.genSucessReponse(result,"注册成功");
    }

}
