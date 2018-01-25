package kr.co.sicc.gsp.svm.gms.sys.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;


@Controller
public class SYSMainController extends SiccController{
	
	public SYSMainController(){
	}
	
	@RequestMapping(value="/{lang}/sys/common")
	public String apply(Locale locale, Model model, 
			@PathVariable String lang) throws SiccException{
		return "/sys/common/index";
	}
}