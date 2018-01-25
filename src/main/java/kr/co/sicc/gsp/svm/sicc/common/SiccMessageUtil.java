package kr.co.sicc.gsp.svm.sicc.common;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

public class SiccMessageUtil {
	public static SiccException getError(String code){
		return new SiccException(code);
	}
	
	public static SiccException getError(String code, Object ... params){
		return new SiccException(code, params);
	}
	
	public static SiccException getError(Exception e){
		return new SiccException(MessageConstants.defaultGMSErrorCode, e);
	}
	
	public static SiccException getError(String code, Exception e){
		if(code != null){
			return new SiccException(code, e);
		}
		return new SiccException(MessageConstants.defaultGMSErrorCode, e);
	}
	
	public static SiccException getError(String code, Exception e, Object ... params){
		if(code != null){
			return new SiccException(code, e, params);
		}
		return new SiccException(MessageConstants.defaultGMSErrorCode, e, params);
	}
	
	public static void saveSuccess(Model model, String message, String showType){
		model.addAttribute("success", true);
		model.addAttribute("msg", message);
		model.addAttribute("msgShowType", showType);
	}
	public static void saveError(Model model, String message, String showType){
		model.addAttribute("success", false);
		model.addAttribute("msg", message);
		model.addAttribute("msgShowType", showType);
	}
	
	public static void saveSuccess(RedirectAttributes redirectAttr, String message, String showType){
		redirectAttr.addFlashAttribute("success", true);
		redirectAttr.addFlashAttribute("msg", message);
		redirectAttr.addFlashAttribute("msgShowType", showType);
	}
	public static void saveError(RedirectAttributes redirectAttr, String message, String showType){
		redirectAttr.addFlashAttribute("success", false);
		redirectAttr.addFlashAttribute("msg", message);
		redirectAttr.addFlashAttribute("msgShowType", showType);
	}
	
	public static void saveSuccess(SiccGenericVO vo, String message, String showType){
		vo.setSuccess(true);
		vo.setMsg(message);
		vo.setMsgShowType(showType);
	}
	public static void saveError(SiccGenericVO vo, String message, String showType){
		vo.setSuccess(false);
		vo.setMsg(message);
		vo.setMsgShowType(showType);
	}
	
	public static void saveSuccess(SiccToolsVO vo, String message, String showType){
		vo.setSuccess(true);
		vo.setMsg(message);
		vo.setMsgShowType(showType);
	}
	public static void saveError(SiccToolsVO vo, String message, String showType){
		vo.setSuccess(false);
		vo.setMsg(message);
		vo.setMsgShowType(showType);
	}
}
