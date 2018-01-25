package kr.co.sicc.gsp.svm.sicc.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XssResponseWrapper extends HttpServletResponseWrapper {

	public XssResponseWrapper(HttpServletResponse response) {
		super(response);
		
//		try {
//			ServletOutputStream out = response.getOutputStream();
			
			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
