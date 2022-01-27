package jdbc.day03.board;


public class BoardDTO { // BoardDTO 가 오라클의 jdbc_board(자식테이블) 테이블의 1개행을 의미하는 것이다. 
	// attribute, field, property, 속성
	
//	-----------------------------------------
// 	jdbc_board 테이블에 insert 및 select 하는 용도
	
	private int      boardNo;       // 글번호
	private String   fk_userid;     // 작성자아이디
	private String   subject;		// 글제목
	private String   contents;		// 글내용
	private String   writeday;		// 작성일자
	private int      viewcount;		// 조회수	
	private String   boardpasswd;	// 글암호
//	-----------------------------------------
	
	private MemberDTO member; 
	// 오라클의 jdbc_board 테이블과 jdbc_member 테이블을 join하여 select 하는 용도
	
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getFk_userid() {
		return fk_userid;
	}
	
	public void setFk_userid(String fk_userid) {
		this.fk_userid = fk_userid;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getWriteday() {
		return writeday;
	}
	
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	public int getViewcount() {
		return viewcount;
	}
	
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
	public String getBoardpasswd() {
		return boardpasswd;
	}
	
	public void setBoardpasswd(String boardpasswd) {
		this.boardpasswd = boardpasswd;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}
	
	
	
	
	
	
	
	
	
}
