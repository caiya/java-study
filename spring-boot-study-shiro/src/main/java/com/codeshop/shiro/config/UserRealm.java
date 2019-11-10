package com.codeshop.shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户领域对象，AuthorizingRealm（授权）已经继承了AuthenticatingRealm（认证），所以只需要继承重写AuthorizingRealm即可
 */
@Service("userRealm")
public class UserRealm extends AuthorizingRealm {
    public final static String USER_NAME = "admin";
    public final static String PASSWORD = "123456";
    public final static Set<String> USER_ROLES = new HashSet<>(); // 用户角色列表
    public final static Set<String> USER_PERMISSIONS = new HashSet<>(); // 用户权限列表

    static {
        USER_ROLES.add("admin");
        USER_ROLES.add("develop");
        USER_ROLES.add("test");

        USER_PERMISSIONS.add("system:users:add");
        USER_PERMISSIONS.add("system:users:edit");
        USER_PERMISSIONS.add("system:users:remove");
        USER_PERMISSIONS.add("system:users:list");
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal(); // 身份凭证：用户名
        String password  =new String((char[]) authenticationToken.getCredentials());//证明 例如 密码
        // 判断身份 & 证明是否正确
        if (!USER_NAME.equalsIgnoreCase(userName) || !PASSWORD.equalsIgnoreCase(password)) {
            // 如果用户名密码错误
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        // 认证通过
        // Object principal, Object credentials, String realmName
        return new SimpleAuthenticationInfo(USER_NAME, PASSWORD, getName());
    }

    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 这里应该根据userName从权限系统获取用户权限信息：角色 & 权限点

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.setRoles(USER_ROLES);

        simpleAuthorizationInfo.setStringPermissions(USER_PERMISSIONS);

        return simpleAuthorizationInfo;
    }

}
