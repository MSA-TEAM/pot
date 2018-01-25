package kr.co.sicc.gsp.svm.sicc.menu;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

public class SiccMenuPreparer implements ViewPreparer{
	protected Logger logger = LoggerFactory.getLogger(SiccMenuPreparer.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LocaleResolver localeResolver; 
	
	@Autowired
	@Qualifier("SICC_SYSTEM")
	private String SICC_SYSTEM;
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext){
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			//attributeContext.putAttribute("sicc_menu", new Attribute(menuService.list(SICC_SYSTEM, authentication.getName(), localeResolver.resolveLocale(request).getLanguage())), true);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
			
	}
}
