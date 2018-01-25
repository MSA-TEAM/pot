package kr.co.sicc.gsp.svm.sicc.exception;

import java.util.Arrays;
import java.util.List;

import kr.co.sicc.gsp.svm.sicc.constants.ForwardConstants;

@SuppressWarnings("serial")
public class SiccException extends RuntimeException{
	private String code;
	private String url;
	private List<Object> params;
	
	public SiccException(){
		super();
		this.code = "";
		this.url = ForwardConstants.ERROR;
	}
	
	public SiccException(Exception e){
		super(e);
		this.code = "";
		this.url = ForwardConstants.ERROR;
	}
	
	public SiccException(String code){
		super(code);
		this.code = code;
		this.url = ForwardConstants.ERROR;
	}
	
	public SiccException(String code, Object ... params){
		super(code);
		this.code = code;
		this.url = ForwardConstants.ERROR;
		this.params = Arrays.asList(params);
	}
	
	public SiccException(String code, Exception e){
		super(code, e);
		this.code = code;
		this.url = ForwardConstants.ERROR;
	}
	
	
	public SiccException(String code, Exception e, Object ... params){
		super(code, e);
		this.code = code;
		this.url = ForwardConstants.ERROR;
		this.params = Arrays.asList(params);
	}
	
	public SiccException(String code, String url){
		super(code);
		this.code = code;
		this.url = url;
	}
	
	public String getCode(){
		if(code == null) code = "";
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public String getForward(){
		if(url == null || url.equals("")) url = ForwardConstants.ERROR;
		return url;
	}
	
	public void setForward(String url){
		this.url = url;
	}

	public Object[] getParams() {
		return params.toArray();
	}

	public void setParams(Object ... params) {
		this.params = Arrays.asList(params);
	}
}
