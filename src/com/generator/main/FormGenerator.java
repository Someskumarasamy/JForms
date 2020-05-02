package com.generator.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import org.json.JSONObject;

import com.generator.utils.json.JsonUtils;

/**
 * @author someskumar.K
 *
 */
public class FormGenerator {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put("formdetails",new HashMap(){{ this.put("div", new HashMap() {{
			this.put("id", "div_id");
		}});
		this.put("name", "String1"); this.put("action", "String2"); }});
		json.put("style",new HashMap<String,String>(){{this.put("width","10px");this.put("color","red");}});
		json.put("formelements",new LinkedHashSet() {
			{
				this.add(new HashMap(){
					{
						this.put("tag", "select");
						this.put("style", new HashMap<String,String>(){{this.put("width","10px");this.put("color","red");}});
						this.put("id", "hello");
						this.put("options",new LinkedHashSet() {{
							/*this.put("default", new ArrayList() {{
								this.add(new String[]{"hello","op"});
							}});
							this.put(key, value)*/
							this.add(new String[]{"hello","op","default"});
							this.add(new String[]{"hello1","opp"});
							this.add(new String[]{"hello2","oppp"});
							this.add(new String[]{"hello3","oppppp"});
						}});
						this.put("addASIT","{{action \"disableADMPIntegration\"}}");
					}
				});
			}
		});
		System.out.println(JsonUtils.convertJson(json));
		System.out.println("\n\n\n\n");
		System.out.println(com.generator.form.FormGenerator.getFromFromJson(JsonUtils.convertJson(json)));
	}

}
