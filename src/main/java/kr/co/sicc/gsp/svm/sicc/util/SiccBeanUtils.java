package kr.co.sicc.gsp.svm.sicc.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.ui.Model;

import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.common.vo.BaseVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

public class SiccBeanUtils extends BeanUtils{
	/**
	  Map Data Binding
	  [data -> target]
	 * @param target
	 * @param data
	 * @throws SiccException
	 */
	public static void populate(Object target, Map<String, ? extends Object> data) throws SiccException {
		for (Entry<String, ? extends Object> ele : data.entrySet()) {
			try {
				BeanUtils.setProperty(target, ele.getKey().toLowerCase(), ele.getValue());
			} catch (IllegalAccessException e) {
				throw SiccMessageUtil.getError(e);
			} catch (InvocationTargetException e) {
				throw SiccMessageUtil.getError(e);
			}
		}
	}
	
	public static void copyProperties(BaseVO target, BaseVO data, Model model) throws SiccException{
		try {
			if(model.asMap().get("cmd") != null){
				SiccBeanUtils.copyProperties(target, model.asMap());
			}else{
				SiccBeanUtils.copyProperties(target, data);
			}
		} catch (IllegalAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (InvocationTargetException e) {
			throw SiccMessageUtil.getError(e);
		}	
	}
}
