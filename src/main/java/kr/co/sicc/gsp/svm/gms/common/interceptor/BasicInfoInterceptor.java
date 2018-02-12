package kr.co.sicc.gsp.svm.gms.common.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.sicc.gsp.svm.gms.common.login.UserInfo;

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
				BasicInfo bInfo = new BasicInfo();
			
				//  for local TEST 
				if(request.getServerName().equals("localhost") || request.getServerName().equals("192.168.99.100") ) { // http://192.168.99.100:8080/ : docker 
					String service_url_addr = request.getServerName() + ":" + request.getServerPort();
					//System.out.println("service_url_addr local .... " + service_url_addr);
					
					if(service_url_addr.equals("localhost:8080")) {
						bInfo.setTenant_id("JAKARTA");
						bInfo.setFile_path_nm("/images");
						bInfo.setImg_file_nm("top_logo_01.png");
					} else {
						bInfo.setTenant_id("SICC");
						bInfo.setFile_path_nm("/images");
						bInfo.setImg_file_nm("top_logo_02.png");
					}					
				
				// for prod
				} else {
					// "pot.jakarta.gsp.sicc.co.kr"
					// "vol.jakarta.gsp.sicc.co.kr"
					// "pot.trackMeet.gsp.sicc.co.kr"
					// "pot.swimming.gsp.sicc.co.kr"										
					
					String service_url_addr = request.getServerName();
					System.out.println("service_url_addr prod .... " + service_url_addr);
					
					BasicInfoDAO mapper = sql_session.getMapper(BasicInfoDAO.class);
					bInfo = mapper.BasicInfo(service_url_addr);  
					System.out.println("tenantID prod: "+bInfo.getTenant_id());
				}				
				session.setAttribute("BasicInfo", bInfo);	
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
