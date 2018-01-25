package kr.co.sicc.gsp.svm.gms.common.utils;

import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonParserUtil { 

	public static List<Map<String, String>> json2List(String jsonstr) throws SiccException {
		try {
            JSONParser jsonParser = new JSONParser();
            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
            Object jsonObject = jsonParser.parse(jsonstr);
            List<Map<String, String>> list = (List<Map<String, String>>)jsonObject;
            //books의 배열을 추출
            //JSONArray nodeArray = (JSONArray) jsonObject.get(node);
/*  
            for(int i=0; i<bookInfoArray.size(); i++){
                 //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject bookObject = (JSONObject) bookInfoArray.get(i);
                //JSON name으로 추출
                System.out.println("bookInfo: name==>"+bookObject.get("name"));
                System.out.println("bookInfo: writer==>"+bookObject.get("writer"));
                System.out.println("bookInfo: price==>"+bookObject.get("price"));
                System.out.println("bookInfo: genre==>"+bookObject.get("genre"));
                System.out.println("bookInfo: publisher==>"+bookObject.get("publisher"));
 
            }
*/            
            return list;
 
		} catch(ParseException e) {
			throw new SiccException("json2List", e);
		}
	}
}
