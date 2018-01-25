package kr.co.sicc.gsp.svm.sicc.security;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import kr.co.sicc.gsp.svm.gms.common.login.UserInfo;

public class SiccPermissionsEvaluator implements PermissionEvaluator {

	private static final Logger logger = LoggerFactory.getLogger(SiccPermissionsEvaluator.class);
	
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    	HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	String controlId = (String)req.getHeader("Referer");
    	UserInfo user = (UserInfo)authentication.getPrincipal();
        System.out.println("hasPermission - "+targetDomainObject);
        System.out.println("controlId : " + controlId);
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    	throw new UnsupportedOperationException();
    }
}
