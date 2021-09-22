package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Data  //getter, setter 한방에 만들어줌(롬복)
//@AllArgsConstructor //생성자 만들어줌(롬북)
@NoArgsConstructor //빈 생성자 만들어줌  => Member m1 = new Member(); 를 가능하게 해줌 => ()안에 데이터 안들어가는 것이 가능
//@RequiredArgsConstructor  //리콰이어아규먼트컨스트럭쳐는 아래 파이널 변수에 대한 생성자 만드는 방식
public class Member {
	private int id;
	private  String username;
	private String password;
	private  String email;   //데이터베이스에서 가져온 이값들을 변경할 일이 없으니 final붙이는 경우가 있다.
	//private는 이 값들을 직접 바꿀 수 없고 메소드를 통해서 변경할 수 있게끔 함. 그렇게 하기 위해서 게터 세터를 사용
	
	//원래는 올아규먼트컨스트럭쳐로 생성자 만들 수 있으나 빌더를 살펴보기 위해서 진행
	//빌더가 있으면 Member객체의 형식을 맞추지 않아도 원하는 것만 넣을 수 있게됨. 롬복이 있으면 이노테이션 하나로 쉽게 빌더가 만들어짐
	//빌더 사용법 예시는 컨트롤러에서 Member m = Member.builder().username("ssar").builder(); 이런 형태로 데이터 값 원하는 것을 넣을 수 있고 편하게 원하는 정보를 원하는 장소에 넣을 수 있게된다.
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	
	
	//롬복을 설치했으니 한방에 
	
	
//	public int getId() {
//		return id;
//	}
//	public Member(int id, String username, String password, String email) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
	
	
	
	
	

}
