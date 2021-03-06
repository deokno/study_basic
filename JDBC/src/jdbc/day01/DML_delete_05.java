package jdbc.day01;

import java.sql.*;
import java.util.Scanner;

public class DML_delete_05 {

	public static void main(String[] args) {
		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.print("▷ 연결할 오라클 서버의 IP 주소 : " );
			String ip = sc.nextLine();
			// 211.238.142.72 강사님 아이피
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":1521:xe", "HR", "cclass");
			
			conn.setAutoCommit(false); // 수동 commit 으로 전환
			
			String sql = " select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday "
					   + " from jdbc_tbl_memo "
					   + " order by no desc "; // sql문 맨뒤에 ; 을 넣으면 오류이다. 
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("글번호\t글쓴이\t글내용\t작성일자");
			System.out.println("-----------------------------------------------------------------------");
			
			StringBuilder sb = new StringBuilder();
			
			while(rs.next()) {
				
				int no = rs.getInt(1);              // "1" 은 select 해온 첫번째 컬럼명이다.
				String name = rs.getString(2);		// "2" 은 select 해온 두번째 컬럼명이다.
				String msg = rs.getString(3);		// "3" 은 select 해온 세번째 컬럼명이다.
				String writeday = rs.getString(4);	// "4" 은 select 해온 네번째 컬럼명이다.
				
				
				sb.append(no);
				sb.append("\t"+name);
				sb.append("\t"+msg);
				sb.append("\t"+writeday+"\n");
				
			}// end of while(rs.next())
			
			System.out.println(sb.toString());
		
			///////////////////////////////////////////////////////////////////////
			
			System.out.print("▷ 삭제할 글번호 : ");
	        String no = sc.nextLine();
	        
	        sql = " select name, msg "
	        	+ " from jdbc_tbl_memo "
	        	+ " where no = ? ";	
	        
	        pstmt.close();
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, no);
	        
	        rs.close();
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	
	        	String name = rs.getString(1);
	        	String msg = rs.getString(2);
	        	
	        	System.out.println("\n=== 삭제하기 전 내용 ===");
	        	System.out.println("\n▶ 글쓴이 : "+ name);
	        	System.out.println("▶ 글내용 : "+msg);
	        	
	        	sql = " delete from jdbc_tbl_memo "
						+ " where no = ? ";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, no);
					
					int n = pstmt.executeUpdate();
					
					if(n==1) {
						// n==1 이라는 뜻은 delete 구문이 성공했다는 말이다.
						
						String yn = "";
						do {
							System.out.print("▷ 정말로 삭제하시겠습니까?[Y/N] : ");
							yn = sc.nextLine();
							
							if("y".equalsIgnoreCase(yn)) {
								conn.commit(); // 커밋
								System.out.println(">> 글번호 "+no+"번 글을 삭제 완료 했습니다. <<");
							}
							
							else if("n".equalsIgnoreCase(yn)) {
								conn.rollback(); // 롤백
								System.out.println(">> 글번호 "+no+"번 글을 삭제 취소 했습니다. <<");
							}
							
							else {
								System.out.println(">> Y 또는 N 만 입력하세요!! << \n");
							}
							
						} while( !("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn)) );
	        	}
	        	
	        	
	        }//end of if
	        else {
	        	System.out.println(">>> 글번호 "+no+" 은 존재하지 않습니다. <<< \n");
	        }
		} catch (ClassNotFoundException e) {
			
			System.out.println( ">> Ojdbc.jar 파일이 없습니다. <<");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// >>> 6. 사용하였던 자원을 반납하기  <<< //
			// 반납의 순서는 생성순서의 역순으로 한다.
			
			try {
				if(rs != null)
					rs.close();

				if(pstmt != null)
					pstmt.close();
				
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				
			}
		}
		
		sc.close();
		System.out.println("~~~ 프로그램 종료 ~~~");
		
		
		
		
		
	}// end of main

}
