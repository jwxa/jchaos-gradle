package com.github.jwxa.mapper;

import com.github.jwxa.model.EoSymStaffDO;
import com.github.jwxa.model.EoSymStaffDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymStaffMapper {
    long countByExample(EoSymStaffDOExample example);

    int insert(EoSymStaffDO record);

    int insertSelective(EoSymStaffDO record);

    List<EoSymStaffDO> selectByExample(EoSymStaffDOExample example);

    EoSymStaffDO selectByPrimaryKey(String staffId);

    int updateByExampleSelective(@Param("record") EoSymStaffDO record, @Param("example") EoSymStaffDOExample example);

    int updateByExample(@Param("record") EoSymStaffDO record, @Param("example") EoSymStaffDOExample example);

    int updateByPrimaryKeySelective(EoSymStaffDO record);

    int updateByPrimaryKey(EoSymStaffDO record);
}