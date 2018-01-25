package kr.co.sicc.gsp.svm.sicc.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

public class SVMSiccUserUtil {
	public static SVMUserVO getUserInfo(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SVMUserVO user = null;
		if(auth != null && auth.getPrincipal() != null && !"anonymousUser".equals(String.valueOf(auth.getPrincipal()))){
			user = (SVMUserVO)SecurityContextHolder.getContext().getAuthentication().getDetails();
		}
		
		return user;
	}
	
	public static void setDefaultUserInfo(SiccGenericVO vo){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SVMUserVO user = null;
		if(auth != null && auth.getPrincipal() != null && !"anonymousUser".equals(String.valueOf(auth.getPrincipal()))){
			user = (SVMUserVO)SecurityContextHolder.getContext().getAuthentication().getDetails();
			
			vo.setUsername(user.getEmail());
			vo.setUser_ip(user.getUser_ip());
			//vo.setUser_group_id(user.getUserGroupId());
		}
		
	}
}
