package kr.co.sicc.gsp.svm.gms.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.sicc.gsp.svm.gms.common.login.LoginController;

import java.util.ArrayList;

public class LogMessage {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	public static void show(String title, Exception e, ArrayList<String> messages) {
		showTitle(title);
		for(String message : messages) {
			logger.debug(message);
		}
		showStackTrace(e);
		showLine();
	}
	
	public static void show(String title, Exception e) {
		showTitle(title);
		showStackTrace(e);
		showLine();
	}

	public static void show(Exception e) {
		showLine();
		showStackTrace(e);
		showLine();
	}
	
	public static void show(String messages) {
		showLine();
		logger.debug(messages);
		showLine();
	}

	private static void showTitle(String title) {
		logger.debug("--- " + title + " ----------------------------------------------------------------");
	}

	private static void showStackTrace(Exception e) {
		if(e != null) {
			logger.debug("Error Message : " + e.getMessage());
			logger.debug("Stack Trace ----------------------------------------------------------------------------------------");
			StackTraceElement[] lists = e.getStackTrace();
			for(StackTraceElement list : lists){
	            logger.debug(list.getClassName() + " : " + list.getMethodName() + " " + list.getLineNumber());
	        }
		}
	}
	
	private static void showLine() {
		logger.debug("----------------------------------------------------------------------------------------------------");
	}
}
