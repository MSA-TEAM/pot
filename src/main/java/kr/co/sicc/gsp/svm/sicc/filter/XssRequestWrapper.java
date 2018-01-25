package kr.co.sicc.gsp.svm.sicc.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author kjp
 * 
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(XssRequestWrapper.class);

	public XssRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
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
				values[i] = escapeXml(value);
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
			encodedValues[i] = escapeXml(values[i]);
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
		return escapeXml(value);
	}

	@Override
	public String getHeader(String name) {
		// LOGGER.info("getHeader() :: name------------>"+name);
		String value = super.getHeader(name);
		if (value == null) {
			return null;
		}
		return escapeXml(value);
	}

	// xml 치환 - target : 전체 코드
	private String escapeXml(String input) {
		if (input == null) {
			return null;
		}
		return input.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("\'", "&#x27;");
	}

	// XSS 치환 - target : XSS 코드
	private String stripXSS(String value) {
		if (value != null) {
			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			// value = ESAPI.encoder().canonicalize(value);

			// Avoid null characters
			value = value.replaceAll("", "");

			// Avoid anything between script tags
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Remove any lonesome </script> tag
			scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			/*
			 * // Avoid anything in a src='...' type of expression scriptPattern
			 * = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
			 * Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			 * value = scriptPattern.matcher(value).replaceAll("");
			 * scriptPattern =
			 * Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
			 * Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			 * value = scriptPattern.matcher(value).replaceAll("");
			 */

			// Avoid eval(...) expressions
			scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid expression(...) expressions
			scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid javascript:... expressions
			scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid vbscript:... expressions
			scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid onload= expressions
			scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// quotation mark
			value = value.replaceAll("\"", "&quot;").replaceAll("\'", "&#x27;");

			// iframe
			scriptPattern = Pattern.compile("<iframe(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("</iframe>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("<iframe>(.*?)</iframe>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// object
			scriptPattern = Pattern.compile("<object(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("</object>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("<object>(.*?)</object>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		// LOGGER.info("stripXSS() :: value------------>"+value);
		return value;
	}

}
