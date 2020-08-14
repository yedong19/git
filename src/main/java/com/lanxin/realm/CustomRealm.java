package com.lanxin.realm;

import com.lanxin.dao.RoleDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private RoleDao roleDao;

    //封装授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
            Set<String> roles = roleDao.roles(username);
            Set<String> functions = roleDao.functions(username);
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setRoles(roles);
            simpleAuthorizationInfo.setStringPermissions(functions);
            return simpleAuthorizationInfo;
    }

    //封装认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
            String pass = roleDao.selectPassByName(username);
            if(pass!=null){
                SimpleAuthenticationInfo customRealm = new SimpleAuthenticationInfo(username, pass, "customRealm");
                //加盐
                customRealm.setCredentialsSalt(ByteSource.Util.bytes("~!@#$%^&"));
                return customRealm;
            }
            return null;
    }

    /*//验证
    public static void main(String[] args) {
        CustomRealm customRealm=new CustomRealm();
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(10);//加密次数
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        //盐值
        String str="~!@#$%^&";
        UsernamePasswordToken token = new UsernamePasswordToken("tom","123",str);
        subject.login(token);

        System.out.println(subject.isAuthenticated());

        //验证角色
        subject.checkRole("超管");
        //验证权限
        subject.checkPermissions("角色管理");
    }*/
}
