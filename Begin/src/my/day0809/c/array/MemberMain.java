package my.day0809.c.array;

import java.util.Scanner;

import my.util.MyUtil;

public class MemberMain {

	public static void main(String[] args) {

//		Member mbr1 = new Member();
//		Member mbr2 = new Member();
//		Member mbr3 = new Member();

		Member[] mbrArr = new Member[4];

		/*
		 * for(int i=0; i<mbrArr.length; i++) { System.out.println(mbrArr[i]); }
		 */

		Member mbr1 = new Member();
		mbr1.id = "leess";
		mbr1.passwd = "qwEr1234$";
		mbr1.name = "이순신";

		Member mbr2 = new Member();
		mbr2.id = "eomjh";
		mbr2.passwd = "qwEr1234!";
		mbr2.name = "엄정화";

		mbrArr[0] = mbr1;
		mbrArr[1] = mbr2;

		Scanner sc = new Scanner(System.in);
		int menuNo = 0;

		Member loginMbr = null;

		do {
//			String loginMsg = (loginMbr != null) ? "[" + loginMbr.name + "님 로그인중]" : "";
//			String login_logout = (loginMbr == null) ? "로그인" : "로그아웃";
//			4.내정보조회
			String loginMsg = "";
			String login_logout = "";
			String myInfoSearch = "";
			String myInfoUpdate = "";
			
			if (loginMbr == null) { // 로그인 안했을 경우
				login_logout = "로그인";
			} else { // 로그인 했을 경우
				loginMsg = "[" + loginMbr.name + "님 로그인중]";
				login_logout = "로그아웃";
				myInfoSearch = "4.내정보조회   ";
				myInfoUpdate = "5.내정보수정   ";
			}
			
			
			System.out.println("\n======= >> 메뉴" + loginMsg + " << =========\n" + "1. 회원가입\t 2." + login_logout + "\n"
					+ "3.모든회원조회\t" + myInfoSearch + myInfoUpdate+"6.프로그램종료\n" + "=================================");

			// 5. 내정보수정 만들어보기 
			
			
			System.out.print("▷ 선택하세요 => ");

			try {

				menuNo = Integer.parseInt(sc.nextLine());
				// "한글입력" 5 1 2 3
				if (!(1 <= menuNo && menuNo <= 6)) {
					System.out.println(">>[경고]메뉴에 없는 번호입니다.<<");
					continue;
				}

				switch (menuNo) {
				case 1: // 회원가입

					// 배열 mbrArr에 빈방(비어있는 즉, null로 되어진 방)이 있는지 없는지를 확인한 후
					// 빈방이 있으면 회원가입을 진행하고, 빈방이 없으면 정원마감이라는 메세지를 출력하도록 한다.

					if (Member.count < mbrArr.length) {

						Member mbr = new Member();

						for (;;) {
							System.out.print(" 1. 아이디 : ");
							String id = sc.nextLine();

							boolean isIdDuplicate = false;

							// 입력받은 id가 기존 회원이 저장된 mbrArr에 가서 동일한 id가 있는지 없는지를 검사해야한다.
							for (int i = 0; i < Member.count; i++) {
								if (mbrArr[i].id.equals(id)) {
									// 입력받은 id가 기존회원이 사용중인 id인 경우, 즉 중복된 id인 경우이다.
									isIdDuplicate = true;
									break;
								}
							} // end of for

							if (isIdDuplicate || id.length() == 0) {
								System.out.println(">>[경고]아이디가 중복되었거나 아이디를 입력하지 않으셨습니다. 새로운 아이디를 입력하세요.<<\n");
							} else {
								mbr.id = id;
								break;
							}
						} // end of for

						for (;;) {
							System.out.print(" 2. 비밀번호 : ");
							String passwd = sc.nextLine();
							if (!MyUtil.isCheckPasswd(passwd)) {
								System.out.println(">>[경고]비밀번호는 8글자 이상 15글자 이하에 대,소문자,숫자,특수문자가 혼합되어져야만 합니다.<<\n");
							} else {
								mbr.passwd = passwd;
								break;
							}
						} // end of for

						for (;;) {
							System.out.print(" 3. 성명 : ");
							String name = sc.nextLine();
							if (name.length() == 0) {
								System.out.println(">>[경고]성명은 필수 입력사항입니다.<<\n");
							} else {
								mbr.name = name;
								break;
							}
						} // end of for

						for (int i = 0; i < mbrArr.length; i++) {
							if (mbrArr[i] == null) {
								mbrArr[i] = mbr;
								break;
							} // end of if
						} // end of for

						System.out
								.println("\n>> 회원가입성공! [" + (++Member.count) + "번째 가입/정원 : " + mbrArr.length + "명]<<");
					} else {
						System.out.println(">>[경고] 정원마감으로 인해 더 이상 회원가입이 불가합니다. <<");
					}
					break;// switch의 break;이다.

				case 2: // 로그인 또는 로그아웃

					if (loginMbr == null) { // 로그인 시도를 해야한다.

						System.out.print("▷ID : ");
						String id = sc.nextLine();

						System.out.print("▷PW : ");
						String passwd = sc.nextLine();

						boolean isLoginSuccess = false;

						for (int i = 0; i < Member.count; i++) {
							if (mbrArr[i].id.equals(id) && mbrArr[i].passwd.equals(passwd)) {
								// 로그인시 입력해준 id롸 passwd가 배열속의 Member 객체에 존재하는 경우
								isLoginSuccess = true;
								loginMbr = mbrArr[i];
								loginMbr.point += 10;// 로그인 시 point를 10점씩 올려주고자 한다.

								break;
							} // end of if

						} // end of for

						if (isLoginSuccess) {
							System.out.println(">>로그인 성공!!<<\n");
						} else {
							System.out.println(">>로그인 실패!!<<\n");
						}
					} else {// 로그아웃
						loginMbr = null;
						System.out.println(">> 로그아웃 되었습니다.<<\n");
					}
					break;// switch의 break;
				/*
				 * case 3 : // 로그아웃
				 * 
				 * loginMbr = null; System.out.println(">> 로그아웃 되었습니다.<<\n"); break;
				 */
				case 3: // 모든회원조회

					if (loginMbr != null) {
						System.out.println("--------------------------------");
						System.out.println("아이디\t성명\t포인트");
						System.out.println("--------------------------------");

						String str_allMember_info = "";
						for (int i = 0; i < Member.count; i++) {
//						System.out.println(mbrArr[i].ShowInfo() + "\n");
							str_allMember_info += mbrArr[i].ShowInfo() + "\n";
						}
						System.out.println(str_allMember_info);
					} else {
						System.out.println(">>로그인이 필요한 메뉴입니다.<<\n");
					}
					break;

				case 4: // 내정보조회
					if (loginMbr != null)
					System.out.println(loginMbr.showMyInfo());
					else {
						System.out.println(">>[경고]메뉴에 없는 번호입니다.<<\n");
					}
					break;
					
				case 5: // 내정보수정

					if (loginMbr != null) {
						
												
						System.out.println("\n==" +loginMbr.name + "님 회원정보 변경하기 ==");
						
						String passwd = "";
						String name = "";
						
						for(;;) {
						System.out.print("1. 비밀번호 : ");
						passwd = sc.nextLine();
						if(!MyUtil.isCheckPasswd(passwd)) {
							System.out.println("[경고]비밀번호는 8글자 이상 15글자 이하에 대,소문자,숫자,특수문자가 혼합되어져야만 합니다. \n");
						}
						else {
							break;
						}
						
						}//end of for	
						
						for(;;) {
							
						
						System.out.println("2. 이름 : ");
						name = sc.nextLine();
							if(name.length() == 0) {
								System.out.println(">>[경고] 이름을 입력하세요. <<");
							}
							else {
								break;
							}
						}//end of for
						
						loginMbr.passwd = passwd;
						loginMbr.name = name;
						
						System.out.println(">> 정보 수정이 완료되었습니다.<<");
						
						
					}
					
					else 
						System.out.println(">>[경고]메뉴에 없는 번호입니다.<<\n");
					

					break;
					
/*
  	== 이순신님 회원정보 변경하기 ==
  	1. 비밀번호 : 
  	2. 이름 : 
  	만들어보기
 */

					

				case 6: // 프로그램 종료
					break;

				}

			} catch (NumberFormatException e) {
				System.out.println(">>[경고] 정수만 입력하세요.<<\n");
			}
		} while (!(menuNo == 6));
		// end of do~while

		sc.close();
		System.out.println("\n===프로그램 종료===");
	}// end of main(String[] args)

}
