package com.github.jwxa.controller;

import com.github.jwxa.model.EoSymStaffDO;
import com.github.jwxa.service.IStaffService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用Swagger2构建RESTful API
 * http://blog.didispace.com/springbootswagger2/
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/28 ProjectName: jchaos-gradle Version: 1.0
 */
@RestController
public class HelloWorldController {
    @Autowired
    private IStaffService staffService;

    @ApiOperation(value="通过用户名查询用户信息，JPA实现")
    @RequestMapping(value = "/getStaffJPA", method= RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "用户名", required = true, dataType = "String" )
    public EoSymStaffDO getStaffJPA(@RequestParam("id") String id){
        return  staffService.findByIdJPA(id);
    }

    @ApiOperation(value="通过用户名查询用户信息，mybatis实现")
    @ApiImplicitParam(name = "id", value = "用户名", required = true, dataType = "String")
    @RequestMapping(value = "/getStaffMybatis", method= RequestMethod.GET)
    public EoSymStaffDO getStaffMybatis(@RequestParam("id") String id){
        return  staffService.findByIdMybatis(id);
    }

    @ApiOperation(value="通过用户名查询用户信息，mybatis注解实现")
    @ApiImplicitParam(name = "id", value = "用户名", required = true, dataType = "String")
    @RequestMapping(value = "/getStaffMybatisAnnotation", method= RequestMethod.GET)
    public EoSymStaffDO getStaffMybatisAnnotation(@RequestParam("id") String id){
        return  staffService.findByIdMybatisAnnotation(id);
    }


}