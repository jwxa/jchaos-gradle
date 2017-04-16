package com.github.jwxa.service;

import com.github.jwxa.model.shiro.UserInfo;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
public interface  UserInfoService {

    /**
     * 通过username查找用户信息
     */
    UserInfo findByUsername(String username);
}
