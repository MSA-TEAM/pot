package kr.co.sicc.gsp.svm.sicc.security;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CsrfSecurityRequestMatcher implements RequestMatcher {

    private static Pattern allowedMethods = Pattern.compile("^(GET|POST)$");
    private static AntPathRequestMatcher[] antRequestMatchers = {
//	    new AntPathRequestMatcher("/loginProcess"),
//	    new AntPathRequestMatcher("/login_success"),
	    new AntPathRequestMatcher("/getSession")
	};
    
    @Override
    public boolean matches(HttpServletRequest request) {
        if(allowedMethods.matcher(request.getMethod()).matches()){
            return false;
        }
        
		for(AntPathRequestMatcher rm : antRequestMatchers) {
			if(rm.matches(request)) return false;
		}
		
		return true;
    }
}