package com.github.jwxa.controller;

import com.github.jwxa.error.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * @param map
     * @return
     */
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://github.com/jwxa");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    /**
     * 测试用-动态修改日志级别
     * http://blog.didispace.com/spring-boot-1-5-x-feature-1/
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
     *  统一异常处理
     * http://blog.didispace.com/springbootexception/
     * @return
     * @throws Exception
     */
    @RequestMapping("/throwEx")
    public String throwEx() throws Exception {
        throw new Exception("发生错误");
    }

    /**
     *  统一异常处理2
     * http://blog.didispace.com/springbootexception/
     * @return
     * @throws Exception
     */
    @RequestMapping("/throwExJson")
    public String json() throws MyException {
        throw new MyException("发生错误json");
    }

    /**
     * 登录页面
     * springboot-security
     * http://blog.didispace.com/springbootsecurity/
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 访问hello 被重定向到了 login
     * 因为没有登录，用户没有访问权限，
     * 通过输入用户名user和密码password进行登录后，跳转到了Hello World页面，
     * 再也通过访问http://localhost:8080/login?logout，就可以完成注销操作。
     * @return
     */
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
