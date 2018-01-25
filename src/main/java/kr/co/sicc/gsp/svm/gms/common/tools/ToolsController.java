package kr.co.sicc.gsp.svm.gms.common.tools;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsManager;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;

@Controller
public class ToolsController extends SiccController{
	@Autowired
	SiccToolsManager toolsManager;
	
	public ToolsController(){}
	
	@RequestMapping(value="/{lang}/cmm/tools/tool")
	@ResponseBody
	public String tool(
			Locale locale, Model model, 
			@PathVariable String lang,
			@ModelAttribute("toolsVO") ToolsVO vo)throws SiccException{
		List<SiccToolsVO> list = new ArrayList<>(); 			
		try{
			
			ToolsVO element;
			for(Map<String, String> map : vo.getCondition()){
				element = new ToolsVO();
				SiccBeanUtils.copyProperties(element, map);
				element.setCp_cd(vo.getCp_cd());
				list.add(element);
			}
		}catch (IllegalAccessException e) {
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(locale), MessageConstants.SHOW_TYPE_POPUP);
			return null;
		}catch (InvocationTargetException e) {
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(locale), MessageConstants.SHOW_TYPE_POPUP);
			return null;
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return null;
		}
		return toolsManager.select(list);
	}
}
