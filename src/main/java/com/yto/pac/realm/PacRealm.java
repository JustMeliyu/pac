package com.yto.pac.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class PacRealm extends AuthorizingRealm {

	private final String USER="sysadmin";
	private final String PASS="1qaz2wsx0p;/";
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object princpal = principals.getPrimaryPrincipal();
		Set<String> premissions = new HashSet<String>();
		if(princpal != null)
		{
			premissions.add("/admin/**");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(premissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginName = token.getPrincipal().toString();
		
		String password = new String((char[])token.getCredentials());
		
		if(USER.equals(loginName) && PASS.equals(password))
			
			return new SimpleAuthenticationInfo(loginName,password,this.getName());
		else
			return null;
	}

}
