package com.ssafy.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest4")
public class TestController4 {
	//http://localhost:8080//mvc/rest4/test1
	
	//REST API에서 Detail 같은 페이지에 들어가고 싶다면?
	//http://localhost:8080//mvc/rest4/board/1
	//http://localhost:8080//mvc/rest4/board/2
	//http://localhost:8080//mvc/rest4/board/99
	
	//매개변수와 URL 경로에 있는 값의 이름을 일치시키지 않으면 오류가 뜬다.
	@GetMapping("/board/{id}")
	public String test1(@PathVariable int id) {
		return id+" is comitted..";
	}

	//게시글 등록
	//application/x-www-form-urlencoded: 폼으로 보내면 등록이 잘 된다!
//	@PostMapping("/board")
//	public String test2(User user) {
//		return user.toString();
//	}
	
	//JSON 형태로 데이터를 보낼 때도 있다.
//	{
//		"name": "Park",
//		"id": "Bzeromo",
//		"password": "1234"
//	}
	
	//게시글 등록
	@PostMapping("/board")
	public String test3(@RequestBody User user) {
		return user.toString();
	}
	
	@GetMapping("/test4")
	public ResponseEntity<String> test4() {
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("auth", "admin");
		
		//응답하려고 하는 데이터, 응답 상태코드, 응답 헤더 등
		return new ResponseEntity<String>("OK Data", headers, HttpStatus.OK);
	}
}
