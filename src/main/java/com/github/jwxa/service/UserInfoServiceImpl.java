package com.github.jwxa.service;

import com.github.jwxa.dao.UserInfoRepository;
import com.github.jwxa.model.shiro.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        log.info("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

}
