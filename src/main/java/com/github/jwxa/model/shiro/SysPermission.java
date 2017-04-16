package com.github.jwxa.model.shiro;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * 权限信息
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
@Entity
@Data
public class SysPermission implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id@GeneratedValue
    private long id;//主键.
    private String name;//名称.

    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;

    @Override

    public String toString() {
        return "SysPermission [id=" + id + ", name=" + name + ", resourceType=" + resourceType + ", url=" + url
                + ", permission=" + permission + ", parentId=" + parentId + ", parentIds=" + parentIds + ", available="
                + available + ", roles=" + roles + "]";
    }
}
