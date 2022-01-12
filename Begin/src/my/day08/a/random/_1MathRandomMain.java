package my.day08.a.random;

import java.util.Scanner;

public class _1MathRandomMain {

	public static void main(String[] args) {
		
		// === 랜덤한 정수를 뽑아낸다 === //
		
		double random = Math.random();
		System.out.println("random => " + random);
		// random => 0.7432232401397381
		// random => 0.6488214583705312
		// random => 0.8671423339028984

	/*
        	java.lang.Math.random() 메소드는 
        	0.0 이상 1.0 미만의 실수(double)값을 랜덤하게 나타내어주는 메소드이다. 
           	즉,  0.0 <= 임의의 난수(실수) < 1.0 
           
        	1 부터 10까지중 랜덤한 정수를 얻어와 본다.
        
           랜덤한 정수 = (int)(Math.random()*구간범위)+시작값;
        
        	0.0        (int)(0.0*(10-1+1))+1         ==>  1
	        0.23346438 (int)(0.23346438*(10-1+1))+1  ==>  3
	        0.67835431 (int)(0.67835431*(10-1+1))+1  ==>  7
	        0.99999999 (int)(0.99999999*(10-1+1))+1  ==> 10
	        
	        3 부터 7까지중 랜덤한 정수를 얻어와 본다.
	        
	        0.0        (int)(0.0*(7-3+1))+3         ==>  3
	        0.23346438 (int)(0.23346438*(7-3+1))+3  ==>  4
	        0.67835431 (int)(0.67835431*(7-3+1))+3  ==>  6
	        0.99999999 (int)(0.99999999*(7-3+1))+3  ==>  7
	           
     */
		
//		1 부터 10까지중 랜덤한 정수를 얻어와 본다.
		int rand1 = (int)(Math.random()*(10-1+1))+1;
		System.out.println("1 부터 10까지중 랜덤한 정수 => "+rand1);
		
//		3 부터 7까지중 랜덤한 정수를 얻어와 본다.
		int rand2 = (int)(Math.random()*(7-3+1))+3;
		System.out.println("3 부터 7까지중 랜덤한 정수 => "+rand2);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		double db_random = Math.random();

//		1 부터 45까지중 랜덤한 정수를 얻어와 본다.
		int rand3 = (int)(db_random*(45-1+1))+1;
		System.out.println("1부터 45 까지의 랜덤한 정수 => "+rand3);
//		'A' 부터 'Z'까지중 랜덤한 알파벳 대문자를 한개 얻어와 본다.
		int upper_int = (int)(db_random*('Z'-'A'+1))+'A';
		System.out.println("A부터 Z 까지의 랜덤한 알파벳 대문자 => "+(char)upper_int);
		
//		'a' 부터 'z'까지중 랜덤한 알파벳 소문자를 한개 얻어와 본다.
		int lower_int = (int)(db_random*('z'-'a'+1))+'a';
		System.out.println("A부터 Z 까지의 랜덤한 알파벳 소문자 => "+(char)lower_int);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		// 인증키는 랜덤한 숫자 3개(0~9)와 랜덤한 소문자 4개로 만들어진다. 
		// 예>103qdtq  
		
		
		String key = "";
		
		for(int i=0; i<3; i++) {
			int num = (int)(Math.random()*(9-0+1))+0;
				key += num;
		}
		
		for(int i=0; i<4; i++) {
			int num = (int)(Math.random()*('z'-'a'+1))+'a';
			key += (char)num;
		}
		
		System.out.println("인증키 => "+ key);

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		Scanner sc = new Scanner(System.in);
		
		outer:
		do {
			try {
			System.out.print("선택 [1.홀수 / 0.짝수] => ");
			String choice = sc.nextLine(); // "안녕하세요" "1.2345"
										   // "9"
			
			int user_choice_no = Integer.parseInt(choice);
			
				if(user_choice_no != 0 && user_choice_no != 1) {
					System.out.println(">>[경고] 0또는 1만 입력하세요.<<\n");
				}
				else {
					//PC에서 랜덤하게 1부터 10까지 중 가지도록 만들자.
					int pc_choice_no = (int)(Math.random()*(10-1+1))+1;
					
					String result = "";
					
					if(pc_choice_no%2 == user_choice_no%2) {
						result = "맞추었습니다.";
					}
					else {
						result = "틀렸습니다.";
					}
					System.out.println("컴퓨터가 낸수 : "+ pc_choice_no + " => "+ result);
						
					do {
						System.out.print(">> 또 할래? [Y/N] <<\n");
						String yn = sc.nextLine();
						
						if("y".equalsIgnoreCase(yn)) {
							break;
						}
						else if("n".equalsIgnoreCase(yn)) {
							break outer;
						}
						else {
							System.out.println(">> [경고] Y 또는 N만 입력하세요 !! <<\n");
						}
						
					
					} while(true);
					// end of do~while
					
					
				}
			
			
			}catch(NumberFormatException e) {
				System.out.println(" >>[경고] 정수만 입력하세요 !! <<\n");
			}
			
			
		} while(true);
		// end of do~while
		
		sc.close();
		System.out.println(" >> === 프로그램 종료 === << ");
		
		
		
	}//end of public static void main(String[] args)

}// public class _1MathRandomMain
