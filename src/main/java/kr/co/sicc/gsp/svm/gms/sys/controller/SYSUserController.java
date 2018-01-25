package kr.co.sicc.gsp.svm.gms.sys.controller;

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

import kr.co.sicc.gsp.svm.gms.sys.service.SYSUserService;
import kr.co.sicc.gsp.svm.gms.sys.vo.SYSUserVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;

@Controller
public class SYSUserController extends SiccController {
	
	@Autowired
	SYSUserService sysUserService;
	
	public SYSUserController(){
	}
	
	@RequestMapping(value="/{lang}/sys/user/{cmd}")
	public String users(
			Locale locale, Model model,
			@PathVariable String lang,
			@PathVariable String cmd,
			@ModelAttribute("sysUserVo") SYSUserVO vo,
			RedirectAttributes redirectAttributes
			) throws SiccException{
		SYSUserVO userVo = new SYSUserVO();
		try{
			SiccBeanUtils.copyProperties(userVo, vo, model);
			
			switch(cmd){
				case "list" :
					userVo.setForwardUrl("/sys/user/list");
					userVo = sysUserService.list(userVo);
					
					model.addAttribute("sysUserVo", userVo);
					model.addAttribute("pageSet", userVo.getPageVo());
					break;
				case "input" :
					userVo.setForwardUrl("/sys/user/edit");
					userVo = sysUserService.input(userVo);
					
					model.addAttribute("sysUserVo", userVo);
					break;
				case "edit":
					userVo.setForwardUrl("/sys/user/edit");
					userVo = sysUserService.edit(userVo);
					
					model.addAttribute("sysUserVo", userVo);
					break;
				case "insert" :
					userVo.setRedirectUrl("/sys/user/edit", lang);
					sysUserService.insert(userVo);
					
					SiccMessageUtil.saveSuccess(redirectAttributes, "Insert Success", MessageConstants.SHOW_TYPE_POPUP);
					redirectAttributes.addFlashAttribute("sysUserVo", userVo);
					break;
				case "update" :
					userVo.setRedirectUrl("/sys/user/edit", lang);
					sysUserService.update(userVo);
					
					SiccMessageUtil.saveSuccess(redirectAttributes, "Update Success", MessageConstants.SHOW_TYPE_POPUP);
					redirectAttributes.addFlashAttribute("sysUserVo", userVo);
					break;
				case "delete" :
					userVo.setRedirectUrl("/sys/user/list", lang);
					int cnt = sysUserService.delete(userVo);
					SiccMessageUtil.saveSuccess(redirectAttributes, getMessage("success.message.delete", locale, cnt), MessageConstants.SHOW_TYPE_POPUP);
					redirectAttributes.addFlashAttribute("sysUserVo", userVo);
					break;
				default:
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return userVo.getErrorUrl();
		}
		
		return userVo.getUrl();
	}
	
	@RequestMapping(value="/{lang}/sys/user/data/{cmd}", method=RequestMethod.POST)
	@ResponseBody
	public SYSUserVO listData(
			Locale locale, Model model,
			@PathVariable String lang,
			@PathVariable String cmd,
			@ModelAttribute("sysUserVo") SYSUserVO vo
			) throws SiccException{
		
		SYSUserVO userVo = new SYSUserVO();
		
		try{
			SiccBeanUtils.copyProperties(userVo, vo, model);
			
			switch(cmd){
				case "listData" :
					userVo = sysUserService.list(userVo);
					break;
				case "delete" :
					int cnt = sysUserService.delete(userVo);
					SiccMessageUtil.saveSuccess(userVo, getMessage("success.message.delete", locale, cnt), MessageConstants.SHOW_TYPE_POPUP);
					break;
				default:
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(model, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
		}
		
		return userVo;
	}
}
