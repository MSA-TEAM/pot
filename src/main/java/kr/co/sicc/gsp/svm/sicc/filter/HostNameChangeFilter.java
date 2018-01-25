package kr.co.sicc.gsp.svm.sicc.filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HostNameChangeFilter implements Filter {
	
	protected FilterConfig 	config;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		ReplaceHostResponseWrapper responseWrapper = new ReplaceHostResponseWrapper((HttpServletResponse)resp, (HttpServletRequest)req);
		chain.doFilter(req, responseWrapper);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		
	}
	
	public static class ReplaceHostResponseWrapper extends HttpServletResponseWrapper {

		private HttpServletRequest request;
		public ReplaceHostResponseWrapper(HttpServletResponse response, HttpServletRequest request) {
			super(response);
			this.request = request;
		}
		
		@Override
		public void sendRedirect(String location) throws IOException
		{ 			
			try
			{
				URL oldURL = new URL(request.getRequestURL().toString());
				URL url = new URL(oldURL, location);
				final String originalStr = url.toString();
				final String urlStr = originalStr.toLowerCase();
				
				if ( true == urlStr.startsWith("http://") )
				{
					super.sendRedirect("https"+originalStr.substring(4));
				}
				else
				{
					super.sendRedirect(location);
				}
			}
			catch ( Exception ex )
			{
				System.out.println("redirect filter fail");
			}
		}
	}
}
