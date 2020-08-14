package com.lanxin.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

/**
 * 授权
 */
public class Demo2 {

    public static void main(String[] args) {
        SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();

        simpleAccountRealm.addAccount("yedong","123","admin");

        //创建SecurityManger环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();

        defaultSecurityManager.setRealm(simpleAccountRealm);

        //主体Subject主动提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("yedong","123");

        subject.login(token);

        System.out.println(subject.isAuthenticated());

        subject.checkRole("admin");

    }

}
