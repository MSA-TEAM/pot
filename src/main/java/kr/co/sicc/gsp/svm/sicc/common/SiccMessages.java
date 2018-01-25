package kr.co.sicc.gsp.svm.sicc.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component(value="siccMessages")
public class SiccMessages {
	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;
	
	private String code = "";
	private Locale locale = null;
	
	public SiccMessages(){
	}

	public String getMessage() {
		return messageSource.getMessage(code, null, locale);
	}
	
	public String getMessage(Object[] params) {
		return messageSource.getMessage(code, params, locale);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
