package kr.co.sicc.gsp.svm.gms.common.main;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@Value("${settings.SICC_SYSTEM}")
	private String system_cd;
	
	public CommonController(){
	}
	
    @RequestMapping("/")
    public String main(HttpSession session, HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
    	StringBuffer url = new StringBuffer();
    	String lang = locale.getLanguage();
    	if( !"in".equalsIgnoreCase(lang) ){
    		lang = "en";
    	}
    	
    	if(system_cd != null){
    		url.append("redirect:/")
    		.append(lang)
    		.append("/")
    		.append(system_cd.toLowerCase())
    		.append("/common");
    	}
    	
        return url.toString();
    }
}
