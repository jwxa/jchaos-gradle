package com.github.jwxa.dao;

import com.github.jwxa.model.EoSymStaffDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/28 ProjectName: jchaos-gradle Version: 1.0
 */
public interface StaffRepository extends JpaRepository<EoSymStaffDO,String> {

    EoSymStaffDO findByStaffId(String staffId);

}
