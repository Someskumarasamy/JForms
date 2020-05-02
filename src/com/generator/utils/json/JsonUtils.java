package com.generator.utils.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {
	public static HashMap<String,Object>convertJson(JSONObject jsonobj){
		//This converts the given JSON Object to a combination of HashMap and List
		try {
			return JSONtoMap(jsonobj);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static HashMap<String, Object> JSONtoMap(JSONObject jsonobj)  throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = JSONtoList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = JSONtoMap((JSONObject) value);
            }   
            map.put(key.toLowerCase(), value);
        }   
        return map;
    }

    private static List<Object> JSONtoList(JSONArray array) throws Exception {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = JSONtoList((JSONArray) value);
            }
            else if (value instanceof JSONObject) {
                value = JSONtoMap((JSONObject) value);
            }
            list.add(value);
        }   
        return list;
    }
}
