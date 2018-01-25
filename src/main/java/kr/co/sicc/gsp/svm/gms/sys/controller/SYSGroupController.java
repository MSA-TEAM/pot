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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.gms.sys.service.SYSGroupService;
import kr.co.sicc.gsp.svm.gms.sys.vo.SYSGroupVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;

@Controller
public class SYSGroupController extends SiccController {
	@Autowired
	SYSGroupService sysgroupService;

	public SYSGroupController() {
	}

	@RequestMapping(value = "/{lang}/sys/group/{cmd}")
	public String groups(Locale locale, Model model, @PathVariable String lang, @PathVariable String cmd,
			@ModelAttribute("sysGroupVo") SYSGroupVO vo, RedirectAttributes redirectAttr,
			SessionStatus status) throws SiccException {
		SYSGroupVO groupVo = new SYSGroupVO();
		try {
			SiccBeanUtils.copyProperties(groupVo, vo, model);
			String[] hold_keys = new String[]{"p_group_id"};
			switch (cmd) {
				case "list":
					groupVo.setForwardUrl("/sys/group/list");
					sysgroupService.list(groupVo);

					model.addAttribute("sysGroupVo", groupVo);
					model.addAttribute("pageSet", groupVo.getPageVo());
					break;
				case "input":
					groupVo.setForwardUrl("/sys/group/edit");
					groupVo = sysgroupService.input(groupVo);
	
					model.addAttribute("sysGroupVo", groupVo);
					break;
				case "edit":
					groupVo.setForwardUrl("/sys/group/edit");
					sysgroupService.edit(groupVo);
	
					model.addAttribute("sysGroupVo", groupVo);
					break;
				case "update":
					groupVo.setRedirectUrl("/sys/group/edit", lang);
					sysgroupService.update(groupVo);
					SiccMessageUtil.saveSuccess(redirectAttr, "Update Success", MessageConstants.SHOW_TYPE_POPUP);
					
					super.setRedirectAttribute(redirectAttr, groupVo, hold_keys);
					
					status.setComplete();
					break;
				case "insert":
					groupVo.setRedirectUrl("/sys/group/edit", lang);
					sysgroupService.insert(groupVo);
					SiccMessageUtil.saveSuccess(redirectAttr, "Insert Success", MessageConstants.SHOW_TYPE_POPUP);
					
					super.setRedirectAttribute(redirectAttr, groupVo, hold_keys);
					status.setComplete();
					break;
				case "delete":
					groupVo.setRedirectUrl("/sys/group/list", lang);
					sysgroupService.delete(groupVo);
					SiccMessageUtil.saveSuccess(redirectAttr, "Delete Success", MessageConstants.SHOW_TYPE_POPUP);
					
					super.setRedirectAttribute(redirectAttr, groupVo, hold_keys);
					status.setComplete();
					break;
				default:
			}
		} catch (SiccException e) {
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(redirectAttr, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return groupVo.getErrorUrl();
		}

		return groupVo.getUrl();
	}

	@RequestMapping(value = "/{lang}/sys/groups/data/{cmd}", method = RequestMethod.POST)
	@ResponseBody
	public SYSGroupVO listData(Locale locale, Model model, @PathVariable String cmd,
			@ModelAttribute("sysGroupVo") SYSGroupVO vo) throws SiccException {
		SYSGroupVO groupVo = new SYSGroupVO();
		try {
			SiccBeanUtils.copyProperties(groupVo, vo, model);
			switch (cmd) {
				case "list":
					break;
				default:
			}
		} catch (SiccException e) {
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(groupVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
		}
		return groupVo;
	}
}
