package com.github.jwxa.dao;

import com.github.jwxa.model.shiro.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
public interface  UserInfoRepository extends CrudRepository<UserInfo,Long> {

    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
