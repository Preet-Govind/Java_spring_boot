package com.springboot_abhyaas.day1;

import java.util.Collections;

/* **************************
 * Author is Rd 
 * preet-govind.github.io
 * S1 means Session 1 and S2 means Session 2 
 * multiple sessions to demonstrate the progress or revisions in code time to time
 */


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {
	
	
	/* ******************
	 * S1
	 * ******************
	 */
	SearchValues sv = new SearchValues();
	DBUser dbu=new DBUser();
	//Two types of APIs can have same name like 
	// PostMethod and DeleteMethod API having same "/user/{ID}"
	//the only thing which matters is the type of method being used and the parameters in this case.
	
	// GetMapping will ensure the particular protocol runs on specific URL and gets a request served from the server.
	@GetMapping("/start")
	public String start() {
		return "first page";
	}
	
	//in case you need to pass multiple parameters
	//http://localhost:8080/search?q=a&q2=b
	@GetMapping("/search")
	public String search(@RequestParam String q) {
		System.out.println(q);
		return sv.fetch_req(q);
	}
	
	@GetMapping("/searchMultiName")
	public String search(@RequestParam String q, @RequestParam String q2) {
		System.out.println(q);
		System.out.println(q2);
		sv.fetch_req(q);
		String str=sv.fetch_req(q)+" , "+sv.fetch_req(q2);
		//return sv.fetch_req(q2);
		return str;
	}
	
	//@RequestMapping("/searchByName")
	@RequestMapping(path="/searchByName",method = RequestMethod.GET) //Another way of @GetMapping
	//@GetMapping("/searchByName")
	public User getUserByName(@RequestParam String q) {
		//return (new DBUser()).getUserByName(q);
		return dbu.getUserByName(q);
	}
//	public String getUserByName(@RequestParam String q) {
//	System.out.println("End Point hit");
//        return "Hi";
//	}
	
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return dbu.getAll();
	}
	
	//taking path variable annotn but can be taken as @RequestParam if wanted to 
	//use api_name?q= format in URL (below)
	
	/*
	 * S1
	 * 
	@GetMapping("/user/{id}")
	public User get1User(@PathVariable int id) {
		return dbu.get1User(id);
	}
	*/
	
	
	/* ******************
	 * S2
	 * ******************
	 */
	
	@RequestMapping("/addUserRM")//by default its RequestMethod.GET
	@ResponseStatus(HttpStatus.FORBIDDEN)//changing the status code to FORBIDDEN
	public User user_create(@RequestBody User user) {
		//System.out.println(user);
		return dbu.add_User(user);
	}
	
	// RequestMapping can be used with a bit of cutomisation in place of both , @GetMapping and @PostMapping
	
	//like above and below methods will do nearly the same things
	//except for the part @ResponseStatus
	@PostMapping("/addUserPM")
	@ResponseStatus(HttpStatus.FORBIDDEN)//changing the status code to FORBIDDEN
	// if an attribute is missing in POST Method in Postman then 
	public User users_create(@RequestBody User user) {
		return dbu.add_User(user);
	}
	
	//S2- revised from S1
	// returning Headers for a request of user details of user with {id}
	@GetMapping("/user/{id}")
	// ResponseEntity used to add some fields of the response , like cookies and all that,
	//here below <User> basically implies to ResponseBody , ResponseEntity has other fields encapsulating the ResponseBody
	public ResponseEntity<User> get1User(@PathVariable int id) {
		MultiValueMap<String,String> header=new LinkedMultiValueMap<>();// dont know exactly what will be feeding in header so.. MVMap
		header.put("Server",Collections.singletonList("code in header"));
		return (new ResponseEntity<User>(dbu.get1User(id),header,HttpStatus.I_AM_A_TEAPOT));
	}
	
	/*	Generic Error code 
	 * 2xx means everything is fine nearly
	 * 3xx means ~ ( 2xx ) ~ but server is not directly involved with the client
	 * 4xx means there's something wrong on user's side
	 * 5xx means there's something wrong on server's side
	 */
	
	@DeleteMapping("/delUser/{ID}")
	public boolean DelAUser(@PathVariable int ID) {
		return dbu.del_AUser(ID);
	}
	
	
	
}
