package com.github.jwxa.mapper;

import com.github.jwxa.model.EoSymStaffDO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/30 ProjectName: jchaos-gradle Version: 1.0
 */
public interface StaffMapper {


    @Select("SELECT * from T_EO_SYM_STAFF")
    @Results({
            @Result(property = "staffId",  column = "STAFF_ID"),
            @Result(property = "staffCode",  column = "STAFF_CODE"),
            @Result(property = "staffName", column = "STAFF_NAME"),
            @Result(property = "orgId", column = "ORG_ID"),
            @Result(property = "sex", column = "SEX"),
            @Result(property = "photo", column = "PHOTO"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "mobile", column = "MOBILE"),
            @Result(property = "phone", column = "PHONE"),
            @Result(property = "address", column = "ADDRESS"),
            @Result(property = "zip", column = "ZIP"),
            @Result(property = "certType", column = "CERT_TYPE"),
            @Result(property = "certNbr", column = "CERT_NBR"),
            @Result(property = "effDate", column = "EFF_DATE"),
            @Result(property = "expDate", column = "EXP_DATE"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "pwdStat", column = "PWD_STAT"),
            @Result(property = "pwdCtrl", column = "PWD_CTRL"),
            @Result(property = "pwdNewtime", column = "PWD_NEWTIME"),
            @Result(property = "pwdValidday", column = "PWD_VALIDDAY"),
            @Result(property = "pwdErrtimes", column = "PWD_ERRTIMES"),
            @Result(property = "pwdTrytimes", column = "PWD_TRYTIMES"),
            @Result(property = "memo", column = "MEMO"),
            @Result(property = "stat", column = "STAT"),
            @Result(property = "errTimeCursor", column = "ERR_TIME_CURSOR"),
            @Result(property = "pwdChange1", column = "PWD_CHANGE1"),
            @Result(property = "pwdChange2", column = "PWD_CHANGE2"),
            @Result(property = "pwdChange3", column = "PWD_CHANGE3"),
            @Result(property = "pwdChange4", column = "PWD_CHANGE4"),

    })
    List<EoSymStaffDO> getAll();

    @Select("SELECT * from T_EO_SYM_STAFF where staff_id = #{id}")
    @Results({
            @Result(property = "staffId",  column = "STAFF_ID"),
            @Result(property = "staffCode",  column = "STAFF_CODE"),
            @Result(property = "staffName", column = "STAFF_NAME"),
            @Result(property = "orgId", column = "ORG_ID"),
            @Result(property = "sex", column = "SEX"),
            @Result(property = "photo", column = "PHOTO"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "mobile", column = "MOBILE"),
            @Result(property = "phone", column = "PHONE"),
            @Result(property = "address", column = "ADDRESS"),
            @Result(property = "zip", column = "ZIP"),
            @Result(property = "certType", column = "CERT_TYPE"),
            @Result(property = "certNbr", column = "CERT_NBR"),
            @Result(property = "effDate", column = "EFF_DATE"),
            @Result(property = "expDate", column = "EXP_DATE"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "pwdStat", column = "PWD_STAT"),
            @Result(property = "pwdCtrl", column = "PWD_CTRL"),
            @Result(property = "pwdNewtime", column = "PWD_NEWTIME"),
            @Result(property = "pwdValidday", column = "PWD_VALIDDAY"),
            @Result(property = "pwdErrtimes", column = "PWD_ERRTIMES"),
            @Result(property = "pwdTrytimes", column = "PWD_TRYTIMES"),
            @Result(property = "memo", column = "MEMO"),
            @Result(property = "stat", column = "STAT"),
            @Result(property = "errTimeCursor", column = "ERR_TIME_CURSOR"),
            @Result(property = "pwdChange1", column = "PWD_CHANGE1"),
            @Result(property = "pwdChange2", column = "PWD_CHANGE2"),
            @Result(property = "pwdChange3", column = "PWD_CHANGE3"),
            @Result(property = "pwdChange4", column = "PWD_CHANGE4"),

    })
    EoSymStaffDO findByStaffId(String id);
}
