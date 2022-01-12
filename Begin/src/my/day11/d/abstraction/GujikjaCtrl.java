package my.day11.d.abstraction;

import java.util.Scanner;

import my.util.MyUtil;

public class GujikjaCtrl {

	// == 구직자(gujikja) 신규 회원가입을 해주는 메소드 생성하기 == //

	Gujikja register(Scanner sc, Gujikja[] guArr) {

		String userid = null;
		String passwd;
		String name;
		String jubun;
// 아이디 공백 막기, 배열 빈방여부 확인 		
		boolean isUseridDuplicate;

		do {
			isUseridDuplicate = false;
			System.out.print("1. 아이디 : ");
			userid = sc.nextLine(); // userid 는 고유해야 한다.
									// "eomjh" "leess" "youks" 중복되었다.
			// == 중복아이디 검사하기 ==
			for (int i = 0; i < Gujikja.count; i++) {

				if (userid.equals(guArr[i].userid)) {
					System.out.println(">>[경고] 이미 사용중인 아이디입니다. <<\n");
					isUseridDuplicate = true;
					break;
				}

			} // end of for

//    		== 아이디는 반드시 공백만이 아닌 글자를 입력했는지 검사한다. == //
			if (userid.trim().isEmpty()) {
				System.out.println(">>[경고] 아이디는 필수 입력값 입니다.<<\n");
				isUseridDuplicate = true;
			}
		} while (isUseridDuplicate);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		do {

			System.out.print("2. 비밀번호 : ");
			passwd = sc.nextLine();

			if (!MyUtil.isCheckPasswd(passwd)) {
				System.out.println(">>[경고] 암호는 8글자 이상 15글자 이하의 대,소문자 및 숫자, 특수문자가 혼합되어야 합니다.<<\n");
			} else {
				break;
			}
		} while (true);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		do {

			System.out.print("3. 성명 : ");
			name = sc.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println(">>[경고] 성명은 필수 입력값 입니다.<<\n");
			} else
				break;

		} while (true);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		do {

			System.out.print("3. 주민번호 : ");
			jubun = sc.nextLine();

			if (!MyUtil.isCheckJubun(jubun)) {
				System.out.println(">>[경고] 주민번호 7자리를 올바르게 입력하세요.<<\n");
			} else {
				break;
			}
		} while (true);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Gujikja gu = new Gujikja();
		gu.userid = userid;
		gu.passwd = passwd;
		gu.name = name;
		gu.jubun = jubun;

		return gu;

	}// end of register()

	// == 모든 구직자의 정보를 보여주는 메소드 생성하기 == //
	void showAll(Gujikja[] guArr) {
		if (Gujikja.count == 0) {
			System.out.println(">> 현재 가입된 구직자가 아무도 없습니다. <<\n");

		} else {
			System.out.println("-------------------------------------------------------------");
			System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n", "아이디", "암호", "성명", "현재나이", "성별");
			System.out.println("-------------------------------------------------------------");
		}
		for (int i = 0; i < Gujikja.count; i++) {
			// guArr[i].showInfo();
			guArr[i].viewInfo();

		} // end of for

		System.out.println();

	}// end of showAll(Gujikja[] guArr)

	// == 연령대를 입력받아 해당 연령대에 속하는 구직자 정보를 출력해주는 메소드 생성하기 == //

	void showByAgeline(Gujikja[] guArr, int ageline) {

		if (Gujikja.count == 0) {
			System.out.println(">> 현재 가입된 구직자가 아무도 없습니다. <<\n");

		} else {
			System.out.println("-------------------------------------------------------------");
			System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n", "아이디", "암호", "성명", "현재나이", "성별");
			System.out.println("-------------------------------------------------------------");
		}

		boolean isFind = false;

		for (int i = 0; i < Gujikja.count; i++) {

			int stored_ageline = guArr[i].getAge() / 10 * 10;
			// 27 ==> 20
			// 25 ==> 20

			if (stored_ageline == ageline) {
				isFind = true;
				guArr[i].viewInfo();
			}

		} // end of for

		if (!isFind) {
			System.out.println(">> 검색하신"+ ageline +"연령대는 없습니다. <<");
		}
		System.out.println();

	}// end of showAll(Gujikja[] guArr)

	
	// == 성별(남 또는 여) 입력받아 해당 성별에 속하는 구직자 정보를 출력해주는 메소드 생성하기 ==//
	void showByGender(Gujikja[] guArr, String gender) { // gender <== "남" 또는 "여"
		
		if (Gujikja.count == 0) {
			System.out.println(">> 현재 가입된 구직자가 아무도 없습니다. <<\n");

		} else {
			System.out.println("-------------------------------------------------------------");
			System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n", "아이디", "암호", "성명", "현재나이", "성별");
			System.out.println("-------------------------------------------------------------");
		}


		for (int i = 0; i < Gujikja.count; i++) {

			if( gender.equals(guArr[i].getGender()) ) {
				guArr[i].viewInfo();
			}
		} // end of for

		
		System.out.println();

	} // end of void showByGender(Gujikja[] guArr, String gender) 
	
	// 특정 연령대에 속하는 특정 성별을 가지는 구직자들만 조회해주는 메소드 생성하기
	
	void showByAgelineGender(Gujikja[] guArr, int ageline,String gender) {
		

			if (Gujikja.count == 0) {
				System.out.println(">> 현재 가입된 구직자가 아무도 없습니다. <<\n");

			} else {
				System.out.println("-------------------------------------------------------------");
				System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n", "아이디", "암호", "성명", "현재나이", "성별");
				System.out.println("-------------------------------------------------------------");
			}

			boolean isFind = false;

			for (int i = 0; i < Gujikja.count; i++) {

				int stored_ageline = guArr[i].getAge()/10*10;
				String stored_gender = guArr[i].getGender();
				
				if(stored_ageline == ageline && stored_gender.equals(gender)) {
					guArr[i].viewInfo();
				}
				
			} // end of for
			
			if(!isFind) {
			
				System.out.println(">> 검색하신 연령 "+ageline+"대에 속하는 "+gender+"자는 없습니다. << \n");
			}
		
			System.out.println();

		}// end of void showByAgelineGender(Gujikja[] guArr, int ageline,String gender)
		
		
	
}

