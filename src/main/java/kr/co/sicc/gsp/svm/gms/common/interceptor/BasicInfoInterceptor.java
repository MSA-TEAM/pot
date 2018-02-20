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

				String service_url_addr = new String();	
				
				//  for local TEST 
				if(request.getServerName().equals("localhost")) {
					try{
						//service_url_addr = request.getServerName();	
						service_url_addr = "pot.jakarta.gsp.sicc.co.kr";						
						//service_url_addr = "pot.trackmeet.gsp.sicc.co.kr";						
						//service_url_addr = "pot.swimming.gsp.sicc.co.kr";						
						
						BasicInfoDAO mapper = sql_session.getMapper(BasicInfoDAO.class);
						List<BasicInfo> list = mapper.BasicInfo(service_url_addr);
					
						System.out.println("bInfo.size() : " + list.size());
						session.setAttribute("BasicInfoList", list);
						
					}catch(DataAccessException e){
						throw SiccMessageUtil.getError(e);
					}catch(ClassCastException e){
						throw SiccMessageUtil.getError(e);
					}	
					
// for local test					
//					String service_url_addr = request.getServerName() + ":" + request.getServerPort();
//					System.out.println("service_url_addr local .... " + service_url_addr);
					
//					List<BasicInfo> list = new ArrayList<BasicInfo>();
//					
//					BasicInfo bInfo = new BasicInfo();					
//					bInfo.setTenant_id("20180220");
//					bInfo.setService_url_addr("vol.jakarta.gsp.sicc.co.kr1");
//					list.add(bInfo);
//
//					BasicInfo bInfo1 = new BasicInfo();	
//					bInfo1.setTenant_id("20180221");
//					bInfo1.setService_url_addr("pot.jakarta.gsp.sicc.co.kr2");
//					list.add(bInfo1);
//					
//					System.out.println("bInfo.size() : " + list.size());
//					for(BasicInfo info:list) {
//						System.out.println("info.getTenant_id() : " + info.getTenant_id());
//						System.out.println("info.getService_url_addr() : " + info.getService_url_addr());
//					}						
//					session.setAttribute("BasicInfoList", list);
	
				// for prod
				} else {
					try{
						service_url_addr = request.getServerName();	
						//System.out.println("service_url_addr prod .... " + service_url_addr);
						
						BasicInfoDAO mapper = sql_session.getMapper(BasicInfoDAO.class);
						List<BasicInfo> list = mapper.BasicInfo(service_url_addr);
						
						System.out.println("bInfo.size() : " + list.size());
						session.setAttribute("BasicInfoList", list);
						
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
