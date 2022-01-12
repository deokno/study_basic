package my.day08.a.random;

import java.util.*;

public class _4binggoMain {

	/*
	 * PC가 만들수 있는 숫자는 1 ~ 100 까지중 아무거나 1개를 만든다.
	 * 
	 * 예> 59 (PC가 랜덤하게 만든 숫자)
	 * 
	 * 1 부터 100 사이의 숫자입력 => 50엔터 1번시도 >> 50보다 큰값입니다.
	 * 
	 * 1 부터 100 사이의 숫자입력 => 71엔터 2번시도 >> 71보다 적은값입니다.
	 * 
	 * 1 부터 100 사이의 숫자입력 => 60엔터 3번시도 >> 60보다 적은값입니다.
	 * 
	 * 1 부터 100 사이의 숫자입력 => 58엔터 4번시도 >> 58보다 큰값입니다.
	 * 
	 * 1 부터 100 사이의 숫자입력 => 59엔터 5번시도 #### 빙고!! 5번만에 맞추었습니다. ####
	 * 
	 * 위와 같이 나오도록 하세요 1. 메일제목 : 과제3_숫자맞추기_이름 2. 첨부파일 : 과제3_숫자맞추기_이름.zip 3. 제출기한 :
	 * 2021.12.17. 18:00 까지 제출 4. 보내는 메일 주소 : tjdudgkr0959@naver.com
	 */

	public static void main(String[] args) {

		Random rnd = new Random();

		Scanner sc = new Scanner(System.in);

		int i = 0;
		int userNum = 0;
		int pcNum = rnd.nextInt(100 - 1 + 1) + 1;
		boolean bo = true;
		
		System.out.println("======= 빙고게임 시작=========\n");

		outer: while (bo) {

			while (true) {

				System.out.print(" 1부터 100 사이의 숫자 입력 => ");
				// userNum=sc.nextInt();
				// sc.nextLine();
				i++;
				try {
					userNum = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("숫자만 입력하세요.");
					continue;
				}

				if (userNum >= 1 && userNum <= 100) {

					if (pcNum > userNum) {
						System.out.print("\t" + (i) + "번시도 >> " + userNum + "보다 큰값입니다.\n");

					} else if (pcNum < userNum) {
						System.out.print("\t" + (i) + "번시도 >> " + userNum + "보다 작은값입니다.\n");

					} else if (pcNum == userNum) {
						System.out.print("#### 빙고!! " + i + "번만에 맞추었습니다. ####\n");
					/*새로만듬	
						System.out.print("또 할래?[y/n] => ");
						String yn = sc.nextLine();
						while(true)
						 
							  if("y".equalsIgnoreCase(yn)) {
								continue;
							  }
							  else if("n".equalsIgnoreCase(yn)) {
								  break outer; 
						  	  }
							  else {
								  System.out.println("y또는 n만 입력해주세요.");
							  }
						
					*/	
						  break outer;
					}

					break;

				} else
					System.out.println("1~100사이의 숫자만 입력해주세요.");

			}

		}

		sc.close();

		System.out.println("\n========게임종료=========");
	}

}
