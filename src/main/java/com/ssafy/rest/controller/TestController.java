package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.rest.model.dto.User;

@Controller
public class TestController {
	//http://localhost:8080//mvc/rest1/test1 : 404 Error, 뷰리졸버가 반환된 문자열을 가지고 View를 찾으려고 하니...
	@GetMapping("/rest1/test1")
	public String test1() {
		return "hi rest";
	}
	
	//http://localhost:8080//mvc/rest1/test2 : @ResponseBody를 붙여서 JSP 화면으로 반환하는게 아니라 데이터 그 자체를 반환
	@ResponseBody
	@GetMapping("/rest1/test2")
	public String test2() {
		return "hi rest";
	}
	
	//http://localhost:8080//mvc/rest1/test3 : Map을 JSON으로 바꿔주지 않으면 406 Error가 발생한다.
	@ResponseBody
	@GetMapping("/rest1/test3")
	public Map<String, String> test3() {
		//키 밸류 형태를 가지고 있는 맵을 반환
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("id", "bzeromo");
		data.put("password", "1234");
		data.put("name", "박영규");
		data.put("age", "25");
		
		return data; //jackson-databind를 추가하면 Map을 알아서 JSON으로 바꿔서 전달한다!
	}
	
	//http://localhost:8080//mvc/rest1/test4: jackson이 DTO도 알아서 JSON으로 변환해준다!
	@ResponseBody
	@GetMapping("/rest1/test4")
	public User test4() {
		User user = new User("bzeromo", "1234", "박영규");
		return user;
	}
	
	//http://localhost:8080//mvc/rest1/test5: jackson이 List마저 JSON으로 변환해준다!
	@ResponseBody
	@GetMapping("/rest1/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<User>();
		User user = new User("bzeromo", "1234", "박영규");
		
		list.add(user);
		list.add(new User("Czeromo", "123456", "차영규"));
		list.add(new User("Dzeromo", "12345678", "대영규"));
		list.add(new User("Ezeromo", "54321", "이영규"));
	
		return list;
	}
}
