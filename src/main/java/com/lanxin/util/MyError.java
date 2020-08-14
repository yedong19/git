package com.lanxin.util;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//拦截异常并统一处理
public class MyError {

    @ExceptionHandler(value = UnauthorizedException.class)//用于捕获Controller中抛出的不同类型的异常，从而达到异常全局处理的目的
    @ResponseBody
    public Result error(){
        return Result.flat(10010,"你的权限不足");
    }
}
