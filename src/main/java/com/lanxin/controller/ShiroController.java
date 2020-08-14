package com.lanxin.controller;

import com.lanxin.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {

    @RequestMapping("/login")
    public Result login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return Result.ok();
        } catch (IncorrectCredentialsException e1) {
            return Result.flat(10001,"密码错误");
        }catch (AuthenticationException e2){
            return Result.flat(10002,"用户不存在");
        }

    }

    @RequestMapping("/unlogin")
    public Result unlogin(){
        return Result.flat(10009,"你没有登录");
    }

    @RequiresPermissions("新建员工")
    @RequestMapping("/add")
    public Result add(){
        System.out.println("添加数据");
        return Result.ok();
    }

    @RequiresPermissions("修改员工")
    @RequestMapping("/update")
    public Result update(){
        System.out.println("修改数据");
        return Result.ok();
    }

    @RequiresPermissions("员工删除")
    @RequestMapping("/delet")
    public Result delet(){
        System.out.println("删除数据");
        return Result.ok();
    }

    @RequestMapping("/select")
    public Result select(){
        System.out.println("查询数据");
        return Result.ok();
    }

}
