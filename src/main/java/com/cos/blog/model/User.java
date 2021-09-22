package com.cos.blog.model;



import java.sql.Timestamp;  //이부분 security timestamp로 하면 오류남 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//클래스를 테이블화 시키려면 @Entity를 붙임 //user클래스가 자동으로 mySQL에 테이블이 생성이 된다.

//ORM -> Java(다른언어도 포함) Object 를 테이블로 매핑해주는 기술  !! 그냥 객체 생성만 해도 어노테이션을 통해서 테이블로 만들 수 있는 기술 !!!
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id  //primary key가 됨
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //넘버링 전략 : 해당 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다! 아이덴티티가 디비의 넘버링전략을 따라감을 의미함
	private int id; //시퀀스(오라클), auto_increment(my sql에서 넘버링하는 전략) 
	@Column(nullable = false, length =  30)  //아이디값은 널이 될 수 없고 길이는 30자 이내로 설정  
	private String username; //아이디값 
	@Column(nullable = false, length = 100) //비번은 좀 넉넉하게 (나중에 해쉬로 변경해서 암호화 하기 위해서 넉넉하게 해주는거)
	private String password;
	@Column(nullable = false, length = 50)
	private String email;  //전화번호 필요없고 이메일만
	
	@ColumnDefault("'user'") //컬럼디폴트는 쌍따옴표 안에 따옴표 하나 더 해야한ㄷ
	private String role; //Enum이라는 전략을 쓰는게 좋다. (도메인 만들 수 있음=> 범위가 정해져있다는 것을 의미) //롤은 회원가입했을 때 admin과 user를 구분할 수 있게끔 
	
	@CreationTimestamp //시간이 자동으로 입력되는 어노테이션 
	private Timestamp createDate; //자바 sql이 들고있는 하나의 
	
	

}
