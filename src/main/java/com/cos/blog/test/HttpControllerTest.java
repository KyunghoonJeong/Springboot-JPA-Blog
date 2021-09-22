package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//사용자가 요청 => 응답(HTML 파일)
// @Controller 사용

//사용자가 요청 = > 응답(data를 응답)  => 레스트 컨트롤러
@RestController
public class HttpControllerTest {

	//인터넷 브라우저 요청은 get요청만 된다, 나머지는 포스트맨에서!
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) { member m 으로하면 일일이 안해도됨
	public String getTest(Member m) {
		
		return "get 요청: "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	//http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")   //이건 application/jason 방식이다!
	public String postTest(@RequestBody Member m) { //바디 데이터는 리퀘스트바디를 줘야함 
		//오브젝트에 각각 넣어줌 MessageConverter(스프링부트)가 해주게된다 !
		return "post 요청: "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
//		@PostMapping("/http/post") 이건  text/plain 방식!
//		public String postTest(@RequestBody String text) { //바디 데이터는 리퀘스트바디를 줘야함
//			return "post요청: " +text;
	
//	public String postTest(Member m) {
//		return "post요청: "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail() ;
//	}
	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m  ) {   //post나 put이나 delete 모두 바디를 통해 전달하기 때문에 리퀘스트바디 !
		return "put 요청 : "+m.getId()+","+m.getPassword();
		//http://localhost:8080/http/delete (delete)
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
