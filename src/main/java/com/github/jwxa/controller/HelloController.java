package com.github.jwxa.controller;

import com.github.jwxa.error.MyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/15 ProjectName: jchaos-gradle Version: 1.0
 */
@Controller
@Slf4j
public class HelloController {
    /**
     * 使用Thymeleaf模板引擎渲染web视图
     * http://blog.didispace.com/springbootweb/
     *
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://github.com/jwxa");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    /**
     * 测试用-动态修改日志级别
     * http://blog.didispace.com/spring-boot-1-5-x-feature-1/
     *
     * @return
     */
    @RequestMapping(value = "/testLog", method = RequestMethod.GET)
    public String testLogLevel(ModelMap map) {
        log.debug("Logger Level ：DEBUG");
        log.info("Logger Level ：INFO");
        log.error("Logger Level ：ERROR");
        map.addAttribute("host", "http://github.com/jwxa");
        return "index";
    }

    /**
     * 统一异常处理
     * http://blog.didispace.com/springbootexception/
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/throwEx")
    public String throwEx() throws Exception {
        throw new Exception("发生错误");
    }

    /**
     * 统一异常处理2
     * http://blog.didispace.com/springbootexception/
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/throwExJson")
    public String json() throws MyException {
        throw new MyException("发生错误json");
    }

    /**
     * 登录页面
     * shiro
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 访问hello 如果没有权限则被重定向到login
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        log.info("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        log.info("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                log.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                log.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                log.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                log.info("else -- >" + exception);
            }
        }
        // 此方法不处理登录成功,由shiro进行处理.TODO 没有生效????
        map.put("msg", msg);
        return "/login";

    }
}
