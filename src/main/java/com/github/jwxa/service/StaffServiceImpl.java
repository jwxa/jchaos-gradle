package com.github.jwxa.service;

import com.github.jwxa.dao.StaffRepository;
import com.github.jwxa.mapper.EoSymStaffMapper;
import com.github.jwxa.mapper.StaffMapper;
import com.github.jwxa.model.EoSymStaffDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/28 ProjectName: jchaos-gradle Version: 1.0
 */
@Service
@Slf4j
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private EoSymStaffMapper eoSymStaffMapper;

    /**
     * 缓存注解配置
     * JPA
     * @param id
     * @return
     */
    @Override
    @Cacheable(value="user-key",key = "#id")
    public EoSymStaffDO findByIdJPA(String id) {
        EoSymStaffDO staffDO = staffRepository.findByStaffId(id);
        log.info("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功,存入redis缓存中");
        return staffDO;
    }

    /**
     * Mybatis Mapper访问数据库
     * @param id
     * @return
     */
    @Override
    public EoSymStaffDO findByIdMybatis(String id) {
        return eoSymStaffMapper.selectByPrimaryKey(id);
    }

    /**
     * Mybatis 注解访问数据库
     * @param id
     * @return
     */
    @Override
    public EoSymStaffDO findByIdMybatisAnnotation(String id) {
        return staffMapper.findByStaffId(id);
    }
}
