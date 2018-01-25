package kr.co.sicc.gsp.svm.gms.common.error;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.common.vo.ResponseVO;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;

@Controller
public class ErrorController extends SiccController {
	public ErrorController(){
	}
	
    @RequestMapping("/404")
    public String pageNotFound(Locale locale, Model model) {
        return "/common/error/404";
    }
    @RequestMapping("/500")
    public String internalServerError(Locale locale, Model model) {
        return "/common/error/500";
    }
    @RequestMapping("/502")
    public String badGateway(Locale locale, Model model) {
        return "/common/error/502";
    }
    @RequestMapping("/dup_req")
    public String dupRequest(Locale locale, Model model) {
        return "/common/error/dup_request";
    }
    @RequestMapping("/xss_req")
    public String xssRequest(Locale locale, Model model) {
        return "/common/error/xss_request";
    }

    @RequestMapping("/xss_req_json")
    @ResponseBody
    public ResponseVO notLogin(Locale locale, HttpSession session, RedirectAttributes redirectAttributes){
    	ResponseVO resvo = new ResponseVO();    	
    	Locale locale2 = new Locale("in");
    	// 제3언어 일 때 영어로 셋팅
    	if(locale == null || !locale2.getLanguage().equals(locale.getLanguage())) {
    		locale = Locale.ENGLISH;
    	}
    	
    	SiccMessageUtil.saveError(resvo, getMessage("error.message.xss_request", locale), MessageConstants.SHOW_TYPE_POPUP);
    	resvo.setErrType("L");

    	return resvo;
    }
}
