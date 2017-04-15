package com.github.jwxa.service;

import com.github.jwxa.model.EoSymStaffDO;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/28 ProjectName: jchaos-gradle Version: 1.0
 */
public interface IStaffService {

    /**
     * 使用JPA映射查询
     * @param id
     * @return
     */
    EoSymStaffDO findByIdJPA(String id);

    /**
     * 以前常用的mybatis
     * @param id
     * @return
     */
    EoSymStaffDO findByIdMybatis(String id);

    /**
     * 使用mybatis注解
     * @param id
     * @return
     */
    EoSymStaffDO findByIdMybatisAnnotation(String id);
}
