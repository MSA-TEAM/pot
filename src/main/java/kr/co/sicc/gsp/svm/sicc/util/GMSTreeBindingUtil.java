package kr.co.sicc.gsp.svm.sicc.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.common.vo.TreeVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;


public class GMSTreeBindingUtil {
	private int level_cnt = 0;
	
	private void upLevelCount(){
		++level_cnt;
	}
	
	private int getLevelCount(){
		return level_cnt;
	}
	
	public static final List<List<TreeVO>> getJSON2TreeVO(String treeData)throws SiccException{
		JSONParser parser = null;
		JSONObject obj = null;
		List<List<TreeVO>> list = new ArrayList<>();
		
		try {
			parser = new JSONParser();
			
			obj = (JSONObject) parser.parse(treeData);
			JSONArray treeObj = (JSONArray)obj.get("children");
			GMSTreeBindingUtil.buildJsonObject2TreeVO(list, treeObj);

		} catch (ParseException e) {
			throw new SiccException(e);
		}
		
		return list;
	}
	
	private static final void buildJsonObject2TreeVO(List<List<TreeVO>> list, Object treeObj){
		JSONObject obj = null;
		TreeVO vo = null;
		JSONArray arr_check_obj = null;
		
		if(treeObj instanceof JSONArray){
			JSONArray arr = (JSONArray) treeObj;
			for(int i = 0 ; i < arr.size() ; i++){
				obj = (JSONObject) arr.get(i);
				
				GMSTreeBindingUtil.buildJsonObject2TreeVO(list, obj);
			}
		}else if(treeObj instanceof JSONObject){
			vo = new TreeVO();
			obj = (JSONObject) treeObj;
			List<TreeVO> tempVoList = null;
			
			vo.setName(String.valueOf(obj.get("name")));
			vo.setId(String.valueOf(obj.get("id")));
			vo.setDepth(String.valueOf(obj.get("depth")));
			vo.setParent_id(String.valueOf(obj.get("parent_id")));
			vo.setLeaf(Boolean.valueOf((String)obj.get("leaf")));
			
			if(list.get(Integer.valueOf(vo.getDepth())) == null){
				tempVoList = new ArrayList<>();
				tempVoList.add(vo);
				
				list.add(Integer.valueOf(vo.getDepth()), tempVoList);
			}else{
				tempVoList = (List<TreeVO>) list.get(Integer.valueOf(vo.getDepth()));
				tempVoList.add(vo);
				
				list.add(Integer.valueOf(vo.getDepth()), tempVoList);
			}
			
			arr_check_obj = (JSONArray)obj.get("children"); 
			
			if(arr_check_obj != null && arr_check_obj.size() > 0){
				GMSTreeBindingUtil.buildJsonObject2TreeVO(list, arr_check_obj);
			}
		}
		
	}
	
	
	public static final TreeVO buildTreeVO2JSON(List<Map<String, Object>> treeList)throws SiccException{
		TreeVO vo = null;
		try {
			vo = new TreeVO();
			
			vo.setId("rootNode");
			vo.setDepth("0");
			vo.setName("rootNode");
			
//			for(Map<String, Object> ele : treeList){
//				if(ele.get("DEPTH") != null && ele.get("DEPTH").equals("1")){
//					vo = new TreeVO();
//					SiccBeanUtils.copyProperties(vo, ele);
//				}
//			}
			
			GMSTreeBindingUtil.buildJSON2TreeVO(vo, treeList);
			
		} catch (IllegalAccessException e) {
			throw new SiccException(e);
		} catch (InvocationTargetException e) {
			throw new SiccException(e);
		}
		
		return vo;
	}
	
	
	private static final void buildJSON2TreeVO(TreeVO node, List<Map<String, Object>> treeList) throws IllegalAccessException, InvocationTargetException{
		TreeVO vo = null;
		for(Map<String, Object> ele : treeList){
			if(node.getId() != null && node.getId().equals(ele.get("PARENT_ID"))){
				vo = new TreeVO();
				SiccBeanUtils.populate(vo, ele);
				node.getChildren().add(vo);
				GMSTreeBindingUtil.buildJSON2TreeVO(vo, treeList);
			}
		}
	}
	
	public static final List<TreeVO> buildJSON2TreeVoList( String jsonArrayString ) throws SiccException{
		ObjectMapper mapper = new ObjectMapper();
		TreeVO treeVo = null;
		List<TreeVO> treeVoList = new ArrayList<TreeVO>();
		
		Object treeDataObject = null;
		JSONArray treeDataObjectArray = null;
		
		try {
			JSONParser jsonParser = new JSONParser();
			treeDataObject=jsonParser.parse(jsonArrayString);
			treeDataObjectArray=(JSONArray) treeDataObject;
			
			JSONObject jsonObject = null;
			for (int i = 0; i < treeDataObjectArray.size(); i++) {
				jsonObject = (JSONObject)treeDataObjectArray.get(i);
				treeVo = mapper.readValue(jsonObject.toJSONString(), TreeVO.class);
				treeVoList.add(treeVo);
			}
		} catch (JsonParseException e) {
			throw SiccMessageUtil.getError(e);
		} catch (JsonMappingException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ParseException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		}
		
		return treeVoList;
	}
}
