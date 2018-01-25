package kr.co.sicc.gsp.svm.sicc.filter;

import java.util.regex.Pattern;

public class XssRule {
	private static final String asc = "<";
//	private static final String asc = "&lt;";
	private static final String desc = ">";
//	private static final String desc = "&gt;";
	
	public static final Pattern[] XSS_RULE_SET = new Pattern[]{
			Pattern.compile(asc+"(\\s*)script"+desc+"(.*?)"+asc+"/script(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)script(.*?)"+desc, Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("eval\\((.*?)\\)", Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("expression\\((.*?)\\)", Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("javascript:", Pattern.MULTILINE),
			Pattern.compile("vbscript:", Pattern.MULTILINE),
			Pattern.compile("onload(.*?)=", Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onunload(.*?)=", Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onclick(.*?)=", Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onchange(.*?)=", Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile(asc+"(\\s*)iframe(.*?)"+desc, Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile(asc+"/iframe(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)iframe"+desc+"(.*?)"+asc+"/iframe(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)object(.*?)"+desc, Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile(asc+"/object(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)object"+desc+"(.*?)"+asc+"/object(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)img(\\s+)src(\\s*)=(.*?)on[a-zA-Z]+=(.*?)"+desc+"(.*?)"+asc+"/img(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)img(\\s+)on[a-zA-Z]+=(.*?)src(\\s*)=(.*?)"+desc+"(.*?)"+asc+"/img(\\s*)"+desc, Pattern.MULTILINE),
			Pattern.compile(asc+"(\\s*)img(\\s+)src(\\s*)=(.*?)on[a-zA-Z]+=(.*?)"+desc, Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile(asc+"(\\s*)img(\\s+)on[a-zA-Z]+=(.*?)src(\\s*)=(.*?)"+desc, Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile(asc+"(\\s*)a(\\s+)href(\\s*)=(.*?)"+desc, Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile(asc+"(\\s*)a(\\s+)href(\\s*)=(.*?)"+desc+"(.*?)"+asc+"/a(\\s*)"+desc, Pattern.MULTILINE) 
	};
}
