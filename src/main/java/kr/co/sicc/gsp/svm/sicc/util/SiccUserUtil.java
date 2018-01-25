package kr.co.sicc.gsp.svm.sicc.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import kr.co.sicc.gsp.svm.gms.common.login.UserInfo;
import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

public class SiccUserUtil {
	public static UserInfo getUserInfo(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo user = null;
		if(auth != null && auth.getPrincipal() != null && !"anonymousUser".equals(String.valueOf(auth.getPrincipal()))){
			user = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getDetails();
		}
		
		return user;
	}
	
	public static void setDefaultUserInfo(SiccGenericVO vo){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo user = null;
		if(auth != null && auth.getPrincipal() != null && !"anonymousUser".equals(String.valueOf(auth.getPrincipal()))){
			user = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getDetails();
			
			vo.setUsername(user.getUsername());
			vo.setUser_ip(user.getUser_ip());
			vo.setUser_group_id(user.getUserGroupId());
		}
		
	}
}
