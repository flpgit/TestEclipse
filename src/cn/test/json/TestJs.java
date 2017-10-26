package cn.test.json;

import java.util.Iterator;

import cn.test.vo.Member;
import net.sf.json.JSONObject;

public class TestJs {
	public static void main(String[] args) {
		String jsonStr = "{\"code\": 200, \"msg\": \"sucess\",\"content\":{\"code\": 200, \"msg\": \"sucess\",\"content\":\"返回结果\"}}";
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Iterator<String> iter = jsonObject.keys();
		Result vo = new Result();
		while(iter.hasNext()){
			String str = iter.next();
			if(str.contains("code")){
				vo.setCode(jsonObject.getString(str));
			}
			if(str.contains("msg")){
				vo.setMsg(jsonObject.getString(str));			
			}
			if(str.contains("content")){
				vo.setContent(jsonObject.getString(str));
			}
		}
		System.out.println("******vo类对象*******:"+vo);
		//		JSONObject jsonObject = JSONObject.fromObject("{\"testkey\":\"testvalue\"}");
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray = new JSONArray();
//		JSONArray jsonArray2 = new JSONArray();
//		jsonObject.put("key1","value1");
//		jsonObject.put("key2","value2");
//		jsonArray.add("code");
//		jsonArray.add("msg");
//		jsonArray.add("content");
//		jsonArray2.add("A");
//		jsonArray2.add("B");
//		jsonArray2.add("C");
////		jsonArray2.add(jsonObject);
//		jsonArray.add(jsonArray2);
//		jsonObject.put("jsonArray",jsonArray);
////		System.out.println("******jsonObject*******:"+jsonObject);
//		System.out.println("test");	
//		System.out.println("*****jsonArray2.get(0)******:"+jsonArray2.get(0));
//		System.out.println("*******jsonArray2.get(1)****:"+jsonArray2.get(1));
//		System.out.println("*****jsonArray2.getString(0)******:"+jsonArray2.getString(0));
//		System.out.println("******jsonArray2.getString(1)*****:"+jsonArray2.getString(1));
	}
}
