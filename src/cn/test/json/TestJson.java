package cn.test.json;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {
	
	public static void main(String[] args) {
		String jsonStr = "{\"code\": 200, \"msg\": \"sucess\",\"content\":[{\"code\": 200, \"msg\": \"sucess\",\"content\":[0,1,2,3,4,5]},1,2,3,4,5]}";
//		JSONArray jsonArray = JSONArray.fromObject(jsonStr);
//		JSONObject jsonObject = jsonArray.getJSONObject(0);
//		Iterator<String> keys = jsonObject.keys();
//		while(keys.hasNext()){
//			String key = keys.next();
//			System.out.print("*****key为*****:"+key+"---");
//			String value = jsonObject.get(key).toString();
//			System.out.println("*****value为*****:"+value);
//		}
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Iterator<String> keys = jsonObject.keys();
//		while(keys.hasNext()){
//			String key = keys.next();
//			System.out.print("*****key为*****:"+key+"---:");
//			String value = jsonObject.get(key).toString();
//			if("content".equals(key)){
//				JSONArray jsonArray = JSONArray.fromObject(value);
//				JSONObject jsonObject2 = jsonArray.getJSONObject(0);
//				Iterator<String>  keys2 = jsonObject2.keys();
//				while(keys2.hasNext()){
//					String key2 = keys2.next();
////					System.out.print("*****key2为*****:"+key2+"---:");
//					String value2 = jsonObject2.get(key2).toString();
////					System.out.println("*****value2为*****:"+value2);
//				}
//				for(int x=1;x<jsonArray.size();x++){
//					jsonArray.getInt(x);
////					System.out.println("*****value2为*****:"+jsonArray.getString(x));
//				}
//				
//			} else {
////				System.out.println("*****value为*****:"+value);
//			}
//		}
		while(keys.hasNext()){
			System.out.println("******key为********:"+keys.next());
		}
        
	}
	@SuppressWarnings("all")
	public void test(){
		String str = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		jsonObject.getJSONArray("key");
		JSONObject.fromObject(str);
		
		
	}

}
