package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reply { //답변 테이블이니 아이디와 내용 

	@	Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
 private int id;	 
	
	@Column(nullable = false, length = 200) //내용은 200자 정도 
	private String content;
	
	
	//누가 어느 게시글의 답변이야 ? 연관관계 필요 !
	
	//하나의 게시글에는 여러가지 답글
	@ManyToOne //하나의 게시글에 여러 답글이 있을 수 있다.
	@JoinColumn(name="boardid")  //보드아이디라는 컬럼 이름이 
	private Board board; 
	
	//답변을 누가 적었는가
	
	@ManyToOne //하나의 유저는 여러개의 답변을 가질 수 있음 
	@JoinColumn(name="userid")
	private User user; 
	
	//답변을 적은 시간
	
	@CreationTimestamp //자동 시간 리로드 
	private Timestamp crateDate;
	
	//여기까지 reply 테이블까지 만들었다. 하지만 ORM은 특이해서 이것만 해주면 끝이 아니고 연관관계의 주인 설정도 해줘야한다.
	//연관관계의 주인 이라는 것은 FK를 누가 가졌는지에 대한 것이다.
	
	//마이 바티스였으면 상세보기 페이지에 작성자나 제목 내용 댓글을 가져와야 할때 해당 페이지 데이터를 다 들고 왔을 것이다
	//orm방식은 유저 보드 리플리 테이블 다 할 필요 없이 보드 테이블만 가져오면 된다. 
	
	//jpa는 자바프로그램과 디비 사이에서 어떤 역할을 해주는데 보드를 받으면 보드 중에 아이디 ~인게 필요하구나 하면서 다른 테이블과 조인까지 생각해 준다. (user 오브젝트의 정보) user +board를 조인문을 보냄
	// 결국 내가 원하는 보드인데 보드와 유저정보도 같이 준다.(조인을 하기 때문에)
	
	//만약 보드에 reply객체도 있다면 보드를 가져올 때 리플리도 조인하여 리플리의 정보도 함께 들고오게된다. 총 3개 정보를 가져옴 유저 보드 리플리!
	//마이 바티스는 다 가져오게끔 해야하는데 jpa를 사용하면 하나만 가져와도 나머지 정보를 가져오게 할 수 있는 것이다.
	
	//리플리 정보는 하나가 아니기 때문에 배열을 사용해서 정의를 해준다 !
	
	
}
