package kr.co.sicc.gsp.svm.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
 
@Configuration
public class ErrorConfiguration extends ServerProperties
{
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container)
	{
		super.customize(container);
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/views/common/error/404.jsp"));
		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/views/common/error/500.jsp"));
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_IMPLEMENTED, "/WEB-INF/views/common/error/500.jsp"));
		container.addErrorPages(new ErrorPage(HttpStatus.BAD_GATEWAY, "/WEB-INF/views/common/error/502.jsp"));
		container.addErrorPages(new ErrorPage(HttpStatus.HTTP_VERSION_NOT_SUPPORTED, "/WEB-INF/views/common/error/500.jsp"));
	}
}