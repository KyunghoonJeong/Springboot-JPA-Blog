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
	
	
	
}
