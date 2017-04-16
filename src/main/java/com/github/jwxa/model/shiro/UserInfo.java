package com.github.jwxa.model.shiro;
/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 用户信息
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
@Entity
@Data
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue
    private long uid;//用户id;
    @Column(unique=true)
    private String username;//账号.

    private String name;//名称（昵称或者真实姓名，不同系统不同定义）

    private String password; //密码;
    private String salt;//加密密码的盐

    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.


    @ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

    @Override
    public String toString() {
        return "UserInfo [uid=" + uid + ", username=" + username + ", name=" + name + ", password=" + password
                + ", salt=" + salt + ", state=" + state + "]";
    }
}
