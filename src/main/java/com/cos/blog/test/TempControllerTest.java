package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //레스트컨트롤러라는 애는 스트링 문자 그 자체를 리턴하나, 컨트롤러는 해당 경로 이하에 있는 파일을 리턴해준다 !
public class TempControllerTest {

	
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resources/static
		//리턴명을  /home.html 로 해야 붙어서 전체 풀 경로가 src/main/resources/static/home.html로 되는것이다
		return "/home.html";
	}
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		// 풀네임은 여기에 맞춰야함
		return "test";
	}
	
	
	
	
}
