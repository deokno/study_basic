package my.day05.f.For;

import java.util.Scanner;

import my.util.MyUtil;

public class MemberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" === 회원가입 하기 ===\n");

		String userid = "";
		for(;;) {
			
			System.out.print("1. 아이디 => ");
			userid = sc.nextLine();
			
			if(userid.length() == 0) {
				System.out.println(">> [경고] 아이디는 필수 입력 사항입니다. << \n");
			}
			else {
				break;
			}
		}
		
		String passwd = "";
				
		for(;;) {
		
		System.out.print("2. 암호 => ");
		passwd = sc.nextLine();
		
			if(!MyUtil.isCheckPasswd(passwd)) {
				System.out.println(">>[경고]암호는 8글자 이상의 대문자, 소문자, 숫자, 특수문자가 혼합되어져야만 통과한다.<<\n");
			}
			else {  
				break;
			}
			
		}
		// 암호는 8글자 이상의 대문자, 소문자, 숫자, 특수문자가 혼합되어져야만 통과한다.
		
		
		
		System.out.println();
		
		String name = "";
		for(;;) {
			
			System.out.print("3. 이름 => ");
			name = sc.nextLine();
			
			if(name.length() ==0) {
				System.out.println(">> [경고] 이름은 필수 입력 사항입니다. << \n");
			}
			else {
				break;
			}
		}

		Member mbr = new Member();
		mbr.userid = userid;
		mbr.passwd = passwd;
		mbr.name = name;
		
		mbr.ShowInfo();
		
		
		sc.close();
		
		}
	}



