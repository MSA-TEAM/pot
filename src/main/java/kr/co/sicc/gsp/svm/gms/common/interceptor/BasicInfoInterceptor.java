package kr.co.sicc.gsp.svm.gms.common.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.sicc.gsp.svm.gms.common.login.UserInfo;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;

@Component
public class BasicInfoInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	@Resource(name="sqlSession")
	SqlSession sql_session;

	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		Object obj = ((HandlerMethod)handler);
		RequestMapping rm = ((HandlerMethod)obj).getMethodAnnotation(RequestMapping.class);
		
		if(rm != null){
			HttpSession session = request.getSession();
			
			// BasicInfo 없을경우에만 DB조회
			if((BasicInfo)session.getAttribute("BasicInfo") == null) {				
				//  for local TEST 
				if(request.getServerName().equals("localhost")) {					
					try{						
						String service_url_addr = request.getServerName();	
						
						//service_url_addr = request.getServerName();	
						service_url_addr = "pot.jakarta.gsp.sicc.co.kr";						
						//service_url_addr = "pot.trackmeet.gsp.sicc.co.kr";						
						//service_url_addr = "pot.swimming.gsp.sicc.co.kr";						
						
						BasicInfoDAO mapper = sql_session.getMapper(BasicInfoDAO.class);						
						
						// 1. URL정보로 TENANT, 대회, 엠블럼 정보 가져오기 
						BasicInfo bInfo = new BasicInfo();			
						bInfo = mapper.TenantInfo(service_url_addr);
								
						// 2. 사용 서비스 시스템 정보 가져오기 
						List<BasicInfo> list = mapper.ServiceInfo(bInfo.getTenant_id());
						
						session.setAttribute("TenantInfo", bInfo); // 테넌트 정보
						session.setAttribute("ServiceInfoList", list); // 사용 서비스 정보 
						
					}catch(DataAccessException e){
						throw SiccMessageUtil.getError(e);
					}catch(ClassCastException e){
						throw SiccMessageUtil.getError(e);
					}
	
				// for prod
				} else {
					try{
						String service_url_addr = request.getServerName();
						BasicInfoDAO mapper = sql_session.getMapper(BasicInfoDAO.class);						
						
						// 1. URL정보로 TENANT, 대회, 엠블럼 정보 가져오기 
						BasicInfo bInfo = new BasicInfo();			
						bInfo = mapper.TenantInfo(service_url_addr);
								
						// 2. 사용 서비스 시스템 정보 가져오기 
						List<BasicInfo> list = mapper.ServiceInfo(bInfo.getTenant_id());
						
						session.setAttribute("TenantInfo", bInfo); // 테넌트 정보
						session.setAttribute("ServiceInfoList", list); // 사용 서비스 정보 
						
					}catch(DataAccessException e){
						throw SiccMessageUtil.getError(e);
					}catch(ClassCastException e){
						throw SiccMessageUtil.getError(e);
					}					
				}
			}  
						
			// 로긴 정보의 tenantId와 비교해서 basicInfo의 로긴 정보의 tenantID정보로 셋팅 
			UserInfo user = (UserInfo)session.getAttribute("userInfo");		
			if(user != null) {
			//if(!user.getAuthorities().isEmpty()) {
//				if(user.getTenantId().euqlas(bInfo.getTenantId())) {
//					bInfo.setTenantId(user.getTenantId());
//					bInfo.setCp_cd(user.getCp_cd());
//				}
			}
		}
		return true;
	}
}
