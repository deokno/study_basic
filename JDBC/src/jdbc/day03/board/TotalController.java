package jdbc.day03.board;

import java.util.*;

public class TotalController {

	
	// field, attribute, property, 속성
	InterMemberDAO mdao = new MemberDAO();
	InterBoardDAO  bdao = new BoardDAO();
	
	
	// operation, method, 기능
	
	// *** 시작메뉴 메소드 생성하기 *** // 
	public void menu_Start(Scanner sc) {
		
		MemberDTO member = null;
		String s_Choice = "";
		
		
		
		do {
			String loginName = "";
			String login_logout = "로그인";
			if(member != null) {
				loginName = "["+member.getName()+"님 로그인중..]";
				login_logout = "로그아웃";
			}
		
			System.out.println("\n    >>> ----- 시작메뉴 "+ loginName +"----- <<< \n"
					 + "1. 회원가입     2."+ login_logout +"      3. 프로그램종료\n"
			         + "--------------------------------------\n");
	
			System.out.print("▷ 메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			switch (s_Choice) {
			case "1" : // 회원가입
					memberRegister(sc);
					
				break;
			
			case "2" :
					// 로그인
					if("로그인".equals(login_logout)) {
						
						member = login(sc); // 로그인 처리 하기
						
						if(member != null ) { // 로그인이 성공한 경우
							menu_board(member, sc); // 게시판 메뉴에 들어간다.
						}
						
					}
					// 로그아웃
					else {
						member = null;
						System.out.println(">> 로그아웃 되었습니다. <<\n");
					}
				
				
				break;
				
			case "3" : 	// 프로그램 종료
		
				break;
				
			default:
					System.out.println(">> 메뉴에 없는 번호입니다. 다시 선택하세요. << \n");
				break;
			}
			
			
		
		}while ( !("3".equals(s_Choice)) );		
		
				
	}// end of public void menu_Start(Scanner sc) 


	// *** 회원가입을 처리해주는 메소드 생성하기 *** //
	private MemberDTO memberRegister(Scanner sc) {
		
		System.out.println("\n >>> ----- 회원가입 ----- <<<");
		String userid = "";
		while(true) {
			System.out.print("1. 아이디 : ");
			userid = sc.nextLine();
			boolean isUse = mdao.isUse_userid(userid);
			if( !isUse ) {
				System.out.println(">> "+userid+" 아이디가 이미 사용중이므로 다른 아이디값을 입력하세요 << \n");
			}else {
				System.out.println(">> "+userid+" 아이디는 사용가능한 아이디입니다. << \n");
				break;
			}
		}
		
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		
		System.out.print("3. 성명 : ");
		String name = sc.nextLine();
		
		System.out.print("4. 연락처(휴대폰) : ");
		String mobile = sc.nextLine();
		
		
		MemberDTO member = new MemberDTO();
		member.setUserid(userid);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMobile(mobile);
		
		int n = mdao.memberRegister(member);
		
		if(n==1) {
			System.out.println(">> 회원가입 성공!! <<");
			menu_board(member, sc); //게시판 메뉴에 들어간다.
			return member;
		}
		else {
			return null;
		}
		
		
	}// end of private void memberRegister(Scanner sc) {
	



	// *** 로그인처리하기 메소드 생성하기 *** // 
	private MemberDTO login(Scanner sc) {
		
		MemberDTO member = null;
		
		System.out.println("\n >>> --- 로그인 --- <<<");
		
		System.out.print("▷ 아이디 : ");
		String userid = sc.nextLine();
		
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("userid", userid);
		paraMap.put("passwd", passwd);
		
		member = mdao.login(paraMap);
		if(member != null) {
			System.out.println("\n >> 로그인 성공 !! << \n");
		}else {
			System.out.println("\n >> 로그인 실패 !! << \n");
		}
			
		return member;
	}// end of private MemberDTO login(Scanner sc)
	
	
	// *** 게시판 메뉴 메소드 생성하기 *** //
	private void menu_board(MemberDTO member, Scanner sc) {
		
		String menuNo = "";
		String adminOnly_menu = ("admin".equals(member.getUserid()))?"10.모든회원정보보기":"";
		
		
		
		do {
			
			System.out.println("\n ----------- 게시판 메뉴 ["+member.getName()+"님 로그인중...] ------------ \n"
							 + "  1.글목록보기    2.글내용보기    3.글쓰기     4.댓글쓰기\n "
					         + " 5.글수정하기    6.글삭제하기    7.최근 1주일간 일자별 게시글 작성건수\n "
							 + " 8.이번달 일자별 게시글 작성건수   9. 나가기     "+ adminOnly_menu + "\n"
					         + "----------------------------------------------------- ");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			menuNo = sc.nextLine();
			
			
			switch (menuNo) {
			case "1":  // 글목록보기
				boardList();
				break;

			case "2":  // 글내용보기
				viewContents(sc, member.getUserid()); // member.getUserid() 내가 쓴 게시물의 조회수는 안올라가게 하려고 설정한다.
				break;
				
			case "3":  // 글쓰기
				
				break;
				
			case "4":  //댓글쓰기
				
				break;
				
			case "5":  // 글수정하기
				
				break;
				
			case "6":  // 글삭제하기    
				
				break;
				
			case "7":  // 최근 1주일간 일자별 게시글 작성건수
				
				break;
				
			case "8":  // 이번달 일자별 게시글 작성건수   
				
				break;
				
			case "9":  // 나가기
				
				break;
				
			case "10": // 모든정보조회하기(관리자전용)
				
				if("admin".equals(member.getUserid()) )  {
					
					System.out.println("[1:회원명의 오름차순   / 2:회원명의 내림차순 / \n"
							         + " 3:가입일자의 오름차순  / 4:가입일자의 내림차순] "  );
					System.out.println("▷ 정렬선택 : ");
					String sortChoice = sc.nextLine();
					
					// 1 또는 2 또는 3 또는 4 를 제외한 나머지가 sortChoice에 입력되면 1로보겠다.
					if(!("1".equals(sortChoice) || "2".equals(sortChoice) || 
					     "3".equals(sortChoice) || "4".equals(sortChoice)) ) {
						sortChoice = "1";
					}
						
					selectAllMember(sortChoice);  
					// 관리자를 제외한 모든 회원들을 선택한 정렬기준으로 보여주는 메소드 호출 
					
					
				}else {
					System.out.println(">> 메뉴에 없는 번호입니다. <<\n");
				}
				
				break;
				
			default:
				System.out.println(">> 메뉴에 없는 번호입니다. <<\n");
				break;
			} 
			
			
			
		} while( !("9".equals(menuNo)) );
			
		
		
	}// end of private void menu_board() ---------------
	
	
	
	



	// *** 글목록보기 메소드 생성하기 ***
	private void boardList() {
	
		
		List<BoardDTO> boardList = bdao.boardList();
		
		int boardCount = boardList.size();
		
		if(boardCount > 0) { // 게시글이 존재하는 경우
			System.out.println("\n >>> =========  [ 게시글 목록 ]  ========== <<<");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("글번호\t글제목    작성자\t작성일자\t\t    조회수");
			System.out.println("-----------------------------------------------------------------------");

			StringBuilder sb = new StringBuilder();
			
			for(BoardDTO board : boardList) {
						
				sb.append(board.getBoardNo() + "\t"+
						  board.getSubject() + "\t"+
						  board.getMember().getName()+"\t"+
						  board.getWriteday() + "  "+
						  board.getViewcount() + "\n");
				
			}// end of for
			
			System.out.println(sb.toString());
			
		}else {
			System.out.println(">>> 글목록이 없습니다. <<<\n");
		}
		
	}// end of private void boardList()  


	
	
	// *** 글내용보기 메소드 생성하기 ***
	private void viewContents(Scanner sc, String login_userid) {
		System.out.println("\n >>> 글내용 보기 <<<");
		
		System.out.print("▷ 글번호 : ");
		String boardno = sc.nextLine();
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("boardno", boardno);
		paraMap.put("fk_userid", login_userid);
		
		BoardDTO board = bdao.viewContents(paraMap);
		
		if(board != null) {
			// 존재하는 글 번호를 입력한 경우 
			System.out.println(" [글내용]");
			System.out.println(" ▷ 글번호 : " + board.getBoardNo() + "\n"
							  +" ▷ 작성자 : " + board.getMember().getName()+"\n"	
							  +" ▷ 글제목 : " + board.getSubject() + "\n"
					          +" ▷ 글내용 : " + board.getContents() + "\n"
							  +" ▷ 작성일자 : "+ board.getWriteday()+ "\n"
							  +" ▷ 조회수 : " + board.getViewcount()+ "\n");
			
		}
		
	}// end private void viewContents(Scanner sc, String userid) 


	
	
	
	
	
	
	
	
	// *** 관리자를 제외한 모든 회원들을 선택한 정렬기준으로 보여주는 메소드 생성하기 ***
	private void selectAllMember(String sortChoice) {
		
		System.out.println("\n >>> ================ 모든회원정보 ================== <<<");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("회원번호    아이디      성명      연락처     포인트    가입일자              탈퇴유무");
		System.out.println("-----------------------------------------------------------------------");
		
		List<MemberDTO> memberList = mdao.selectAllMember(sortChoice);
		
		int memberCount = memberList.size(); // admin을 제외한 회원수
		
		if(memberCount > 0) {
			
			StringBuilder sb = new StringBuilder();

			for(MemberDTO member : memberList) {
				
				String str_status = (member.getStatus() ==1 )?"가입중":"탈퇴";
				
				sb.append(member.getUserseq() + "\t"+
			              member.getUserid() + "\t  "+
			              member.getName() + "\t"+
			              member.getMobile() + "\t"+
			              member.getPoint() + " "+
			              member.getRegisterday() + "\t"+
								str_status +"\n");
				
			}// end of for
			
			System.out.println(sb.toString());
			
		}else {
			System.out.println("가입된 회원이 없습니다.");
		}
		
	}// end of private void selectAllMember(String sortChoice) ---------------------------
	


	
		
}
