package com.lanxin.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

/**
 * 认证
 */
public class Demo1 {

    public static void main(String[] args) {
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();

        SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();

        //添加用户
        simpleAccountRealm.addAccount("yedong","123");

        simpleAccountRealm.addAccount("lizhi","321");

        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("yedong", "123");

        subject.login(token);

        System.out.println(subject.isAuthenticated());
    }
}
