package kr.co.sicc.gsp.svm.sicc.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.sicc.gsp.svm.sicc.common.vo.ResponseVO;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;

public abstract class SiccController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("siccMessages")
	private SiccMessages siccMessages;
	
	public String getMessage(String code, Locale locale){
		try {
			System.out.println("1 : " + code + " : " + locale);
			siccMessages.setCode(code);
			siccMessages.setLocale(locale);
			
			return siccMessages.getMessage();
		} catch(NoSuchMessageException e) {
			return "Not found Message in properties";
		}
	}
	
	public String getMessage(String code, Locale locale, Object ... params){
		try {
			siccMessages.setCode(code);
			siccMessages.setLocale(locale);
			System.out.println("2 : " + code + " : " + locale);
			return siccMessages.getMessage(params);
		} catch(NoSuchMessageException e) {
			return "Not found Message in properties";
		}
	}
	
	public String getMessage(Locale locale){
		try {
			siccMessages.setCode(MessageConstants.defaultGMSErrorCode);
			siccMessages.setLocale(locale);
			System.out.println("3 : " + MessageConstants.defaultGMSErrorCode + " : " + locale);
			return siccMessages.getMessage();
		} catch(NoSuchMessageException e) {
			return "Not found Message in properties";
		}
	}
	
	protected ResponseEntity<String> responseVOtoJson(ResponseVO resvo) throws SiccException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
			
			return new ResponseEntity<String>(mapper.writeValueAsString(resvo), responseHeaders, HttpStatus.CREATED);
		} catch(JsonProcessingException e) {
			throw new SiccException("responseVOtoJson", e);
		}
	}

	protected String responseVOtoJsonString(ResponseVO resvo) throws SiccException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(resvo);
		} catch(JsonProcessingException e) {
			throw new SiccException("responseVOtoJsonString", e);
		}
	}
	
	protected void setRedirectAttribute(RedirectAttributes redirectAttr, Object vo, String[] _keys) throws SiccException{
		try {
			Map<String, Object> map = new HashMap<>(SiccBeanUtils.describe(vo));
			
			List<String> keys = new ArrayList<String>(Arrays.asList(_keys));
			keys.add("cmd");
			keys.add("page");
			
			for(Entry<String, Object> ele : map.entrySet()){
				if(ele.getKey().startsWith("search_") && (null != ele.getValue() && !"".equals(ele.getValue()))){
					redirectAttr.addAttribute(ele.getKey(), ele.getValue());
					continue;
				}else{
					stop:
					for(String key : keys){
						if(ele.getKey().equals(key) && (null != ele.getValue() && !"".equals(ele.getValue()))){
							redirectAttr.addAttribute(ele.getKey(), ele.getValue());
							break stop;
						}
					}
				}
			}
		} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
}
