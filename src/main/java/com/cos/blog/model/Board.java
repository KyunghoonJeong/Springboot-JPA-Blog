package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity  
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //디비의 넘버링 전략을 따라간다 !
	private int id; 
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터를 쓸 때 사용
	private String content; //내용은 매우 길 수가 있다.  // 섬머노트라는 라이브러리를 사용할 것이다. 일반적인 글이 디자인이 돼서 들어간다. html태그가 섞여 디자인되기 때문에 굉장히 큰 용량이 된다. 
	
	@ColumnDefault("0") //조회수는 0부터 시작이라 컬럼 디폴트 값을 0으로 잡는다. 인트니까 홉따옴표 따로 필요없음
	private int count; // 조회수 
	
	//보드를 누가 적었는지 알아야함
//	private int userid ;  //  DB는 오브젝트를 저장할 수없다. 그래서 FK사용하는데 자바에서는  오브젝트를 저장할 수 있다. 자바에서 데이터베이스에 자료형에 맞춰서 테이블을 만들게 된다.  ORM을 사용하면 오브젝트 저장 가능하다. @를 통해서
	@ManyToOne //보드가 many고 유저가 one이라는 뜻 / 한명의 유저는 여러개의 게시글을 쓸 수 있다는 것을 의미!   one to one이면 한명당 하나의 게시글 !
	@JoinColumn(name="userid") //필드값은 유저아이디로 만들어지고 연관관계는 매니투원으로 만들어진다. 
	private User user; //조인컬럼을 통해서 원래 디비는 객체 인식이 안되나 이것을 통해 객체 인식이 가능해진다. 중간 다리 역할을 해줌
	
	@OneToMany(mappedBy="board", fetch= FetchType.EAGER) //하나의 게시글은 여러 개의 답변을 지닐 수 있음 //맵 바이 => 연관관계의 주인이 아니다 -> 난 fk가 아니니 db에 컬럼을 만들지 마세요 라는 의미이다.
	//	@JoinColumn(name="replyid")  //replyid라는 fk는 필요없기 때문에 이건 안써줘도 된다. //디폴트 패치값이 레이지긴 한데 이것이 의미하는 것은 필요할 때 가져온다는 것이고 Eager는 즉시 가져오는 것인데 댓글창이 바로 보이게끔 설정한다면 EAGER전략을 써야한다.
	private List<Reply> reply; //보드에서 값을 얻기 위해서만 필요한 것이다 => 맵바이 보드를 통해서 fk가 아님을 알림
	@CreationTimestamp
	private Timestamp createDate; //현재 시간 ! 자동으로 들어가게끔
	
	//이해가 잘 안가도 몇번 해보면 알 것이다.

}
