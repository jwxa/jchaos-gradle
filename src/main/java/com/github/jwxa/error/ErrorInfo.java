package com.github.jwxa.error;

import lombok.Data;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/15 ProjectName: jchaos-gradle Version: 1.0
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private Integer code;
    private String message;
    private String url;
    private T data;
    // 省略getter和setter
}