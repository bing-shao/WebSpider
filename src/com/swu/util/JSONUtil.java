package com.swu.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @Title: JSONUtil
 * @package com.linewell.util
 * @Description: TODO
 * @author ljn@linewell
 * @date 2016-1-20 下午1:10:15
 * @version V1.0
 */
public class JSONUtil {

/**
 * 
 * @Title: toJson 
 * @Description: 将list<Object>类型的数据转换为json格式
 * @param List<Object>    设定文件
 * @return json
 * @author ljn@linewell    
 * @throws
 */
public static JSONArray toJson(List<Object> list){
	JSONArray json=new JSONArray();
	for (Object obj : list) {
		JSONObject jsonObject = JSONObject.fromObject(obj);
		json.add(jsonObject);
	}
	return json;
}
/**
 * 
 * @Title: 
 * @Description: 将一个对象转化为json格式
 * @param: Object  obj  
 * @return: JSONArray 
 * @author: ljn@linewell
 * @time: 下午4:16:36
 * @throws:
 */
public static JSONArray toJson(Object obj){
	JSONArray json=new JSONArray();
	JSONObject jsonObject = JSONObject.fromObject(obj);
	json.add(jsonObject);
	return json;
}
/**
 * 
 * @Title: 
 * @Description: 将一个字符串转化为json格式
 * @param: args    
 * @return: JSONObject 
 * @author: ljn@linewell
 * @time: 下午4:17:05
 * @throws:
 */
public static JSONObject stringToJson(String string){
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("msg", string);
	return jsonObject;
}
/**
 * 
 * @Title: 
 * @Description: TODO
 * @param: List<Object> list    
 * @return: JSONArray 
 * @author: lpan@linewell
 * @time: 下午4:17:44
 * @throws:
 */
public static JSONArray testJson(List<Object> list){
	JSONArray json=new JSONArray();
	for (Object obj : list) {
		@SuppressWarnings("unchecked")
		List<Object> oo=(List<Object>) obj;
		 for(Object o:oo){
		JSONObject jsonObject = JSONObject.fromObject(o);
		json.add(jsonObject);
	       }
		 }
	return json;
}

/**
 * 
 * @Title: 
 * @Description: 返回json列表
 * @param: args    
 * @return: JSONObject 
 * @author: ljn@linewell
 * @time: 下午1:01:25
 * @throws:
 */
public static JSONObject jsonList(String str,List<Object> list){
	JSONObject jsonObject=new JSONObject();
	jsonObject.put(str, list);
	return jsonObject;
	}
}

