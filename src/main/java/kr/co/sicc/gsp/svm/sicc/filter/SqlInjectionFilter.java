package kr.co.sicc.gsp.svm.sicc.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import kr.co.sicc.gsp.svm.sicc.util.GMSXssUtil;

public class SqlInjectionFilter extends OncePerRequestFilter{
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest processedRequest = request;		
		ReplaceClientRequestWrapper requestWrapper = new ReplaceClientRequestWrapper(processedRequest);		
		filterChain.doFilter(requestWrapper, response);		
	}

	private class ReplaceClientRequestWrapper extends HttpServletRequestWrapper{

		public ReplaceClientRequestWrapper(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		
		private String defaultRule(String src){
			return GMSXssUtil.escapeXml(GMSXssUtil.escapeXml(src));
		}
					
		@Override
		public Map<String, String[]> getParameterMap() {
			Map<String, String[]> returnMap = new HashMap<String, String[]>();

			@SuppressWarnings("unchecked")
			Map<String, String[]> params = super.getParameterMap();
			for (Map.Entry<String, String[]> entry : params.entrySet()) {
				String[] values = entry.getValue();

				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					values[i] = defaultRule(value);
				}

				returnMap.put(entry.getKey(), values);
			}

			return returnMap;
		}

		@Override
		public String[] getParameterValues(String parameter) {
			// LOGGER.info("getParameterValues() :: parameter------------>"+parameter);
			String[] values = super.getParameterValues(parameter);
			if (values == null) {
				return null;
			}
			int count = values.length;
			String[] encodedValues = new String[count];
			for (int i = 0; i < count; i++) {
				encodedValues[i] = defaultRule(values[i]);
			}
			return encodedValues;
		}

		@Override
		public String getParameter(String parameter) {
			// LOGGER.info("getParameter() :: parameter------------>"+parameter);
			String value = super.getParameter(parameter);
			if (value == null) {
				return null;
			}
			return defaultRule(value);
		}

		@Override
		public String getHeader(String name) {
			// LOGGER.info("getHeader() :: name------------>"+name);
			String value = super.getHeader(name);
			if (value == null) {
				return null;
			}
			return defaultRule(value);
		}
	}
}
