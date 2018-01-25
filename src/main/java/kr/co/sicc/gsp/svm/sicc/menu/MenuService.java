package kr.co.sicc.gsp.svm.sicc.menu;

import java.util.List;

public interface MenuService {
	public List<MenuVO> list(String system, String user_id, String lang) throws Exception; 
}
