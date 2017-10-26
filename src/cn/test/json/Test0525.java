package cn.test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test0525 {
	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<>();
//		map.put("1", "A");
//		map.put("2", "B");
//		map.put("3", "C");
//		JSONObject jsonObject = new JSONObject();
////		jsonObject.put("testmap",map);
////		System.out.println("***map.toString()****:"+jsonObject.toString());
//		jsonObject.putAll(map);
//		System.out.println("***直接放入map***:"+jsonObject.toString());
//		JSONArray jsonArray = new JSONArray();
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
//		list.add("5");
//		jsonArray.addAll(list);
//		System.out.println("****放入list集合*****:"+jsonArray.toString());
//		JSONArray jsonArray2 = JSONArray.fromObject(list);
//		String str = "{\"json\":\"testJson\",\"test001\":001}";
//		JSONObject jsonObject2 = JSONObject.fromObject(str);
//		Iterator<String> keysIterator = jsonObject2.keys();
//		Set<String> keysSet = jsonObject2.keySet();
//		jsonArray.get(0);
//		jsonObject.get("json");
//		jsonObject.size();
//		jsonObject.getJSONArray("json");
//		jsonObject.getJSONObject("testJson");
//		jsonArray.get(0);
//		jsonArray.remove(0);
//		JSONArray jsonArray = new JSONArray();
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
//		list.add("5");
//		jsonArray.addAll(list);
//		System.out.println("****jsonArray.addAll(list)****:"+jsonArray);
//		jsonArray.remove(1);
//		System.out.println("****jsonArray.remove(index)****:"+jsonArray);
//		boolean flag1 = jsonArray.remove("5");
//		System.out.println("****jsonArray.remove(object)****:"+jsonArray+"*********"+flag1);
//		boolean flag2 = jsonArray.remove("6");
//		System.out.println("****jsonArray.remove(object)****:"+jsonArray+"*********"+flag2);
//		JSONObject jsonObject = new JSONObject();
//		Map<String, Object> map = new HashMap<>();
//		map.put("1", "A");
//		map.put("2", "B");
//		map.put("3", "C");
//		map.put("4", "D");
//		map.put("5", "E");
//		map.put("8", new ArrayList<>().add(800));
//		jsonObject.putAll(map);
//		jsonObject.put("5", "第二个5喽");
//		System.out.println("******jsonObject.put(map)*******:"+jsonObject.toString());
//		jsonObject.put("6", 100);
//		System.out.println("******jsonObject.put(map)+put(\"6\",011)*******:"+jsonObject.toString());
//		jsonObject.remove("4");
//		System.out.println("******jsonObject.remove(\"4\")*******:"+jsonObject.toString());
//		jsonObject.clear();
//		System.out.println("******jsonObject.clear()*******:"+jsonObject.toString());
//		System.out.println("******jsonObject.size()******:"+jsonObject.size());
//		System.out.println("*****isJSONArray()*****:"+((JSONArray)jsonObject.get("8")).isArray());
		String str0 = "{\"code\":200,\"msg\":\"success\",\"content\":[{\"yuyi\":{\"action\":\"不理解\",\"destination\":\"\",\"talker\":\"\",\"ai\":{\"relate\":[{\"key\":\"异响\",\"key_weight\":60},{\"key\":\"发动机\",\"key_weight\":78},{\"key\":\"汽车\",\"key_weight\":64}],\"weight\":[{\"key\":\"异响\",\"key_weight\":29},{\"key\":\"发动机\",\"key_weight\":38},{\"key\":\"汽车\",\"key_weight\":31}],\"master_confidence\":80}},\"daan\":{\"retCode\":\"000000\",\"retMsg\":\"成功\",\"answerType\":\"2\",\"confidence\":\"61\",\"id\":\"1269\",\"question\":\"车子异响\",\"answers\":{\"node_type\":\"1\",\"children\":[{\"node_type\":\"2\",\"children\":[{\"node_type\":\"1\",\"children\":[{\"node_type\":\"2\",\"node_name\":\"低速行驶胎噪大，嗡嗡响\",\"pid\":\"102\",\"id\":\"103\",\"knowledge_id\":\"605\",\"qa_id\":\"78\",\"sa_group_id\":\"78\"},{\"node_type\":\"2\",\"node_name\":\"行驶轻踩刹车有吱吱异响\",\"pid\":\"102\",\"id\":\"104\",\"knowledge_id\":\"606\",\"qa_id\":\"79\",\"sa_group_id\":\"79\"},{\"node_type\":\"2\",\"node_name\":\"行驶深加油门前部嘎嘎嘎异响\",\"pid\":\"102\",\"id\":\"105\",\"knowledge_id\":\"607\",\"qa_id\":\"80\",\"sa_group_id\":\"80\"},{\"node_type\":\"2\",\"node_name\":\"驶拐弯前部有嘣嘣异响\",\"pid\":\"102\",\"id\":\"106\",\"knowledge_id\":\"608\",\"qa_id\":\"81\",\"sa_group_id\":\"81\"},{\"node_type\":\"2\",\"node_name\":\"车辆高速行驶发出哨声异响\",\"pid\":\"102\",\"id\":\"107\",\"knowledge_id\":\"609\",\"qa_id\":\"82\",\"sa_group_id\":\"82\"}],\"node_name\":\"哪种情况最相近，请选择\",\"pid\":\"101\",\"id\":\"102\",\"qa_id\":\"1\"}],\"node_name\":\"行驶中\",\"pid\":\"100\",\"id\":\"101\",\"qa_id\":\"77\",\"sa_group_id\":\"77\"},{\"node_type\":\"2\",\"children\":[{\"node_type\":\"1\",\"children\":[{\"node_type\":\"2\",\"node_name\":\"原地加油门车身底部隆隆响\",\"pid\":\"109\",\"id\":\"110\",\"knowledge_id\":\"610\",\"qa_id\":\"84\",\"sa_group_id\":\"83\"},{\"node_type\":\"2\",\"node_name\":\"紧急制动时有“嘎嘎”的响声\",\"pid\":\"109\",\"id\":\"111\",\"knowledge_id\":\"611\",\"qa_id\":\"85\",\"sa_group_id\":\"84\"},{\"node_type\":\"2\",\"node_name\":\"车辆玻璃升降器摩擦响声\",\"pid\":\"109\",\"id\":\"112\",\"knowledge_id\":\"612\",\"qa_id\":\"86\",\"sa_group_id\":\"85\"},{\"node_type\":\"2\",\"node_name\":\"凉车着车后车辆前部吱吱异响\",\"pid\":\"109\",\"id\":\"113\",\"knowledge_id\":\"613\",\"qa_id\":\"87\",\"sa_group_id\":\"86\"}],\"node_name\":\"哪种情况最相近，请选择\",\"pid\":\"108\",\"id\":\"109\",\"qa_id\":\"1\"}],\"node_name\":\"非行驶中\",\"pid\":\"100\",\"id\":\"108\",\"qa_id\":\"83\",\"sa_group_id\":\"77\"}],\"node_name\":\"车子处于何种状态\",\"pid\":\"0\",\"id\":\"100\",\"qa_id\":\"8\"}}}]}";
		JSONObject jsonObject1 = JSONObject.fromObject(str0);
		String code = jsonObject1.getString("code");
		String msg = jsonObject1.getString("msg");
		System.out.println("***code****:"+code+"  ******msg:"+msg);
		JSONArray jsonArray1 = jsonObject1.getJSONArray("content");
		System.out.println("****jsonArray1*****:"+jsonArray1.toString());
		JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
		System.out.println("***jsonObject2****:"+jsonObject2);
		JSONObject jsonObject3 = jsonObject2.getJSONObject("daan");
		String answerType = jsonObject3.getString("answerType");
		System.out.println("****nodeType*****:"+answerType);
		String retMsg = jsonObject3.getString("retMsg");
		System.out.println("*****retMsg*****:"+retMsg);
		JSONObject jsonObjectAnswer = jsonObject3.getJSONObject("answers");
		System.out.println("******jsonObjectAnswer******:"+jsonObjectAnswer);
		String node_name1 = jsonObjectAnswer.getString("node_name");
		System.out.println("****node_name1*****:"+node_name1);
		JSONArray jsonArrayChildren = jsonObjectAnswer.getJSONArray("children");
		System.out.println("*****jsonArrayChildren******:"+jsonArrayChildren);
		for(int x=0;x<jsonArrayChildren.size();x++){
			JSONObject jsonObjectA = jsonArrayChildren.getJSONObject(x);
			String node_typeA = jsonObjectA.getString("node_type");
			System.out.println("*****jsonObjectA中的node_typeA*****:"+node_typeA);
			String node_nameA = jsonObjectA.getString("node_name");
			System.out.println("*****jsonObjectA中的node_nameA*****:"+node_nameA);
			JSONArray jsonArrayChildrenA = jsonObjectA.getJSONArray("children");
			for(int y=0;y<jsonArrayChildrenA.size();y++){
				JSONObject jsonObjectB = jsonArrayChildrenA.getJSONObject(y);
				String node_nameB = jsonObjectB.getString("node_name");
				System.out.println("*****jsonObjectB中node_nameB*******:"+node_nameB);
				String node_typeB = jsonObjectB.getString("node_type");
				System.out.println("*****jsonObjectB中node_typeB*******:"+node_typeB);
				JSONArray jsonArrayChildrenB = jsonObjectB.getJSONArray("children");
				for(int z=0;z<jsonArrayChildrenB.size();z++){
					JSONObject jsonObjectC = jsonArrayChildrenB.getJSONObject(y);
					String node_nameC = jsonObjectC.getString("node_name");
					System.out.println("*****jsonObjectC中node_nameC*******:"+node_nameC);
					String node_typeC = jsonObjectC.getString("node_type");
					System.out.println("*****jsonObjectC中node_typeC*******:"+node_typeC);
				}
			}
		}
	}
}
