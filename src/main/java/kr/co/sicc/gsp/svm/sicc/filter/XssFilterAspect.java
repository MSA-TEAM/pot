package kr.co.sicc.gsp.svm.sicc.filter;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.sicc.gsp.svm.sicc.common.vo.ResponseVO;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.util.GMSXssUtil;

@Aspect
public class XssFilterAspect {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object xssFilterAroundAdvice(ProceedingJoinPoint joint){
		Object mainObj = null;
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		HttpServletResponse response = attr.getResponse();
		
		String content_type = request.getContentType();
		boolean multipart_yn = false;
		if(content_type != null && content_type.indexOf("multipart/form-data") > -1){
			multipart_yn = true;
		}
		
		if(request != null){
			Entry<String, ? extends Object> obj = null;

			for (Object ele : request.getParameterMap().entrySet()) {
				obj = (Entry<String, ? extends Object>) ele;

				if (obj.getValue() instanceof String[]) {
					for (String param : (String[]) obj.getValue()) {
						if (GMSXssUtil.validateXss(param) == false) {
							ResponseVO vo = new ResponseVO();
							vo.setSuccess(false);
							vo.setMsg("입력된 문자중 시스템 공격성 문자 입력이 감지되었습니다.");
							vo.setMsgShowType(MessageConstants.SHOW_TYPE_POPUP);
							
							if(multipart_yn){
								return responseVOtoJson(vo);
							}else{
								return vo;
							}
						}
					}
				}
			}
		}
		
		try {
			mainObj = joint.proceed();
		} catch (Throwable e) {
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
		
		return mainObj;
	}
	
	private ResponseEntity<String> responseVOtoJson(ResponseVO resvo) throws SiccException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
			
			return new ResponseEntity<String>(mapper.writeValueAsString(resvo), responseHeaders, HttpStatus.CREATED);
		} catch(JsonProcessingException e) {
			throw new SiccException("responseVOtoJson", e);
		}
	}
}

