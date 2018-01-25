package kr.co.sicc.gsp.svm.sicc.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import kr.co.sicc.gsp.svm.gms.common.tools.ToolsServiceImpl;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.common.vo.BaseVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import net.minidev.json.JSONObject;

@Service
public class SiccToolsManager {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	//@Resource(name="sqlSession")
	SqlSession session;
	
	@Autowired
	private LocaleResolver localeResolver; 
	
	@Autowired
	private HttpServletRequest request;
	
    public String select(List<? extends BaseVO> vo_list) throws SiccException{
    	SiccToolsService toolsService;
    	Map<String, Object> map = new HashMap<String, Object>();

    	Locale locale = localeResolver.resolveLocale(request);
    	String lang = String.valueOf(locale.getLanguage());
    	
    	try {
            SiccToolsVO itemVo;
            for(BaseVO default_vo : vo_list){
            	itemVo = (SiccToolsVO) default_vo;
            	
            	toolsService = factory(itemVo.getSystem_cd());
                
            	if(validDefaultSetting(itemVo)){
                    continue;                
                }
                if("VOL_APPLICATION".equals(itemVo.getCode_find().trim()))
                	map.put(itemVo.getEtc_cond1(), toolsService.select(itemVo, session));
                else
                	map.put(itemVo.getCode_find(), toolsService.select(itemVo, session));
            }
            map.put("CMM_LANG", lang);
        } catch (SiccException e) {
        	throw SiccMessageUtil.getError(e);
        }
        return JSONObject.toJSONString(map);
    }
    
    private boolean validDefaultSetting(SiccToolsVO vo){
        if(null == vo.getSystem_cd() || vo.getSystem_cd().equals("")){
            return true;
        }
        
        if(null == vo.getCode_find() || vo.getCode_find().equals("")){
            return true;
        }
        
        return false;
    }
    
    private SiccToolsService factory(String content) throws SiccException{
    	Constructor<?> toolsClazz = null;
    	try {
    		StringBuilder className = new StringBuilder();
    		className.append("com.gms.");
    		if(content != null && "whole".equalsIgnoreCase(content)){
    			className.append("common.tools.WholeToolsServiceImpl");
    		}else if(content != null && "TCO".equalsIgnoreCase(content)){
    			className.append("common.tools.ToolsServiceImpl");
    		}else if(content != null){
				className.append(content.toLowerCase());
				className.append(".service.impl.");
				className.append(content.toUpperCase());
				className.append("ToolsServiceImpl");
    		}
    		
    		Class<?> clazz = Class.forName(className.toString());
			toolsClazz = clazz.getConstructor();
			
			return (SiccToolsService) toolsClazz.newInstance();
		} catch (ClassNotFoundException e) {
			logger.debug(e.getMessage());
		} catch (SecurityException e) {
			logger.debug(e.getMessage());
		} catch (InstantiationException e) {
			logger.debug(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.debug(e.getMessage());
		} catch (NoSuchMethodException e) {
			logger.debug(e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.debug(e.getMessage());
		} catch (InvocationTargetException e) {
			logger.debug(e.getMessage());
		}
    	return new ToolsServiceImpl();
    }
}

