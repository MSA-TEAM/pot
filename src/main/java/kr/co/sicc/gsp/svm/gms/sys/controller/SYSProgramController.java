package kr.co.sicc.gsp.svm.gms.sys.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.gms.sys.service.SYSProgramService;
import kr.co.sicc.gsp.svm.gms.sys.vo.SYSProgramVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;

@Controller
public class SYSProgramController extends SiccController{
	@Autowired
	SYSProgramService sysProgramService;
	
	public SYSProgramController(){
	}
	
	@RequestMapping(value="/{lang}/sys/program/{cmd}")
	public String programs(
			Locale locale, Model model,
			@PathVariable String lang,
			@PathVariable String cmd,
			@ModelAttribute("sysProgramVo") SYSProgramVO vo,
			RedirectAttributes redirectAttributes
			) throws SiccException{
		
		SYSProgramVO programVo = new SYSProgramVO();
		
		try{
			SiccBeanUtils.copyProperties(programVo, vo);
			
			switch(cmd){
				case "listView":
					programVo.setForwardUrl("/sys/program/list");
					programVo = sysProgramService.list_view(programVo);
					model.addAttribute("sysProgramVo", programVo);
					break;
				case "list":
					programVo.setForwardUrl("/sys/program/list");
					programVo = sysProgramService.list(programVo);
					model.addAttribute("sysProgramVo", programVo);
					break;
				case "edit":
					programVo.setForwardUrl("/sys/program/edit");
					programVo = sysProgramService.edit(programVo);
					
					model.addAttribute("sysProgramVo", programVo);
					break;
				case "input" :
					programVo.setForwardUrl("/sys/program/edit");
					programVo = sysProgramService.input(programVo);
					
					model.addAttribute("sysProgramVo", programVo);					
					
					break;
				case "insert" :
					programVo.setRedirectUrl("/sys/program/edit", lang);
					sysProgramService.insert(programVo);
					
					redirectAttributes.addFlashAttribute("sysProgramVo", programVo);					
					
					break;
				case "update" :
					programVo.setRedirectUrl("/sys/program/edit", lang);
					sysProgramService.update(programVo);
					
					redirectAttributes.addFlashAttribute("sysProgramVo", programVo);					
					
					break;
				case "delete" :
					programVo.setRedirectUrl("/sys/program/list", lang);
					sysProgramService.delete(vo);	
					
					redirectAttributes.addFlashAttribute("sysProgramVo", programVo);
					
					break;
				default:
			}
		}catch (IllegalAccessException e) {
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(locale), MessageConstants.SHOW_TYPE_POPUP);
			return programVo.getErrorUrl();
		}catch (InvocationTargetException e) {
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(locale), MessageConstants.SHOW_TYPE_POPUP);
			return programVo.getErrorUrl();
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return programVo.getErrorUrl();
		}
		
		return programVo.getUrl();
	}

	@RequestMapping(value="/{lang}/sys/program/data/{cmd}", method=RequestMethod.POST)
	@ResponseBody 
	public SYSProgramVO listData(
			Locale locale, Model model,
			@PathVariable String lang,
			@PathVariable String cmd,
			@ModelAttribute("SYSProgramVO") SYSProgramVO vo
			)throws SiccException{
		SYSProgramVO programVo = new SYSProgramVO();
		try{
			SiccBeanUtils.copyProperties(programVo, vo, model);
			switch(cmd){
				case "listData" :
					if(programVo.getSearch_system_cd().equals(""))
						programVo.setSearch_system_cd("SYS");
					
					programVo = sysProgramService.list(programVo);
					break;
				case "delete" :
					//int cnt = sysProgramService.delete(programVo);
					//SiccMessageUtil.saveSuccess(programVo, getMessage("success.message.delete", locale, cnt));
					break;
				case "update" :
					sysProgramService.update(programVo);
					
					programVo.setCmd("edit");
					SiccMessageUtil.saveSuccess(programVo, "Update Success", MessageConstants.SHOW_TYPE_POPUP);
					break;
				case "insert" :
					sysProgramService.insert(programVo);
					
					programVo.setCmd("edit");
					SiccMessageUtil.saveSuccess(programVo, "Insert Success", MessageConstants.SHOW_TYPE_POPUP);
					break;
				default:
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(programVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
		}
		return programVo;
	}
}
