package com.generator.form;

import java.util.HashMap;

import com.generator.utils.json.JsonUtils;

/**
 * @author someskumar.K
 *
 */


public class FormGenerator {
	
	public static String getFromFromJson(HashMap inputdata) {
		 int openDivCount=0;
		 int closeDicCount=0;
		String head = "";
		try {
			if(inputdata.containsKey("formdetails")){
				 head = getFormHead((HashMap) inputdata.get("formdetails"));
			}
		}
		catch(Exception ex) {
			
		}
		finally {
			
		}
		return head;
	}
	private static String getFormHead(HashMap data) throws Exception {
		String op = "";
		HashMap temp = null;
		if(data.containsKey("div")) {
			op = "<div ";
			temp = (HashMap) data.get("div");
			if(temp.containsKey("id")) {
				op = op+"id=\""+temp.get("id").toString()+"\" ";
			}
			if(temp.containsKey("class")) {
				op = op+"class=\""+temp.get("class").toString()+"\" ";
			}
			op = op+" >";
		}
		op = op + "<form ";
		if(data.containsKey("name")) {
			op += "name=\""+data.get("name")+"\" ";
		}
		
		return op+">";
	}
}
