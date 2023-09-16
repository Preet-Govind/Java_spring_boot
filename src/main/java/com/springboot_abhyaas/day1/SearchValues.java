package com.springboot_abhyaas.day1;
//day 1 , shift 1
import java.util.HashMap;

//instead of using database , using HashMap , test specific
public class SearchValues {

	private static HashMap<String, String> store = new HashMap<>();

	public SearchValues(){ 
		//making constructor , so i dont have to call 
		//this block to init HM with these values.
		store.put("a", "a_value");
		store.put("b", "b_value");
		store.put("c", "val_c");
		System.out.println(store+" are hashmap elements");
		
	}

	public String fetch_req(String akshar) {
		//Stor();
		return store.get(akshar);

	}

}
