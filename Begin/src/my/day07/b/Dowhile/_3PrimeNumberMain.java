package my.day07.b.Dowhile;

import java.util.*;

public class _3PrimeNumberMain {
	  
	// === 소수란? === 
	   // 소수란? 1과 자기 자신으로밖에 나누어지지 않는 1 이외의 정수 
	   // 예> 1 부터 10까지의 소수를 나타내면 
	   //       2%2 ==> 0   2 는 소수
	   //       3%3 ==> 0   3 는 소수
	   //       4%2 ==> 0   4 는 소수가 아님
	   //       5%5 ==> 0   5 는 소수
	   //       6%2 ==> 0   6 는 소수가 아님
	   //       7%7 ==> 0   7 는 소수
	   //       8%2 ==> 0   8 는 소수가 아님
	   //       9%3 ==> 0   9 는 소수가 아님
	   //      10%2 ==> 0  10 는 소수가 아님  
	
/*
	    ==실행결과==
	     ▷시작 자연수 : 1엔터
	     ▷끝 자연수 : 20엔터 
	  1 부터 20 까지의 소수는?
	  2,3,5,7,11,13,17,19
	  
	  1부터 20 까지의 소수의 개수? 8개  
	  
	  1부터 20 까지의 소수들의 합? 77 
	  
	  === 프로그램 종료 ===      
*/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int startNo = 0;
		int endNo = 0;
		do {
			try {
				System.out.print("▷시작 자연수 : ");
				startNo = sc.nextInt(); // 1엔터 or 1.345엔터 or 한글 
				sc.nextLine();
				
				System.out.print("▷끝 자연수 : ");
				endNo = sc.nextInt(); // 20엔터 or 2.345엔터 or 한글 
				sc.nextLine();
				
				if(startNo < 1 || endNo < 1) {
					System.out.println(">>[경고] 입력하시는 값은 모두 자연수이어야 합니다!! <<\n");
				}
				else if(startNo >= endNo) {
					System.out.println(">>[경고] 두번째 입력한 숫자가 첫번째 입력한 숫자보다 커야합니다!!<<\n");
				}
				else {
					break;
				}
					
			} catch (InputMismatchException e) {
					System.out.println(">>[경고] 자연수만 입력하세요!! <<\n");
				}	
		}while(true);
		//end of do~while

/*
	    ==실행결과==
	     ▷시작 자연수 : 1엔터
	     ▷끝 자연수 : 20엔터 
 	  	1 부터 20 까지의 소수는?
	  	2,3,5,7,11,13,17,19
	  
	  	1부터 20 까지의 소수의 개수? 8개  
	  // 소수란? 1과 자기 자신의 수로만 나누었을 때 나머지가 0인 1이외의 정수를 말한다.
	  	1부터 20 까지의 소수들의 합? 77 
	  
	  	=== 프로그램 종료 ===      
*/
		String str_result = "";
		int cnt = 0; // 소수의 누적 개수
		int sum = 0; // 소수들의 누적 합계
		
		for(int i=startNo; i<= endNo; i++ ) {
			// i 가 소수인지 아닌지를 검사할 대상이다.
			if(i==1) {
				continue; // 1은 소수가 아니므로 검사할 필요가 없기에 continue;를 해야한다.
			}
			/*
			   나누기를 했을 때 나머지가 얼마가 되는지 일일이 검사를 한다.
			   만약에 i가 2이라면 ==> 2%2==0          2는 소수이다.
			   만약에 i가 3이라면 ==> 3%2!=0  3%3==0  3은 소수이다.
			   만약에 i가 4이라면 ==> 4%2==0(검사할 필요가 없다.) 4는 소수가 아니다.
			   만약에 i가 5이라면 ==> 5%2!=0  5%3!=0  5%4!=0  5%5==0 5는 소수이다.
			   .................
			   만약에 i가 9이라면 ==> 9%2!=0  9%3==0(검사할 필요가 없다.) 9는 소수가 아니다.
			 
			 */
			boolean isSosu = true;
			
			for(int j=2;j<i-1;j++) {   //j가 분모에 들어갈 값이다.
				
				if(i%j == 0) {// 검사대상인 i는 소수가 아닌 경우 
					isSosu = false;// 소수가 아님을 표시한다.
					break;
				}
			
			}//end of for
			
			if(isSosu) { // 검사대상인 i가 소수이라면 
				String str_add = (!"".equals(str_result) )?",":"";
				str_result += str_add + i;
					cnt++;// 소수의 개수를 누적 
					sum += i; // 소수들의 누적의 합계
			}
			
		}//end of for
		
		System.out.println(startNo+"부터"+endNo+"까지의 소수는?\n"+str_result);
		// 2,3,5,7,11,13,17,19

		System.out.println("\n"+startNo+"부터"+endNo+"까지의 소수의 개수?  "+cnt +"개");
		
		System.out.println("\n"+startNo+"부터"+endNo+"까지 소수들의 합?  "+ sum );
		
		sc.close();
		
		System.out.println("=== 프로그램 종료 ====");
		
	}//end of public static void main(String[] args)

}//end of public class _3PrimeNumberMain
