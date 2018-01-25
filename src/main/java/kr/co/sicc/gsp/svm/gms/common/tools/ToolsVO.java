package kr.co.sicc.gsp.svm.gms.common.tools;

import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

@SuppressWarnings("serial")
public class ToolsVO extends SiccToolsVO{
	public ToolsVO(){
    }
	
	public ToolsVO(String system_cd, String code_find, String order){
		super(system_cd, code_find, order);
    }
	
	public ToolsVO(String system_cd, String code_find, String order, String ... etc_cond){
		super(system_cd, code_find, order, etc_cond);
	}
}

