package kr.co.sicc.gsp.svm.sicc.util;

import java.util.regex.Pattern;

import kr.co.sicc.gsp.svm.sicc.filter.XssRule;

public class GMSXssUtil {
	
	public static boolean validateXss(String src){
		if (src != null) {
			for(Pattern rule : XssRule.XSS_RULE_SET){
				if(rule.matcher(src).find()){
					return false;
				}
			}
		}
		
		return true; 
	}
	
	public static String escapeXml(String input) {
		if (input == null) {
			return null;
		}
							
		return input.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("\'", "&#x27;");
	}
	
	public static String escapeQuotationMark(String input){
		// Avoid null characters
		input = input.replaceAll("", "");
		// quotation mark
		input = input.replaceAll("\"", "&quot;").replaceAll("\'", "&#x27;");
		return input;
	}
}
