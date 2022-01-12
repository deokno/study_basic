package my.day06.a.multiFor;

public class MultiForMain {

	public static void main(String[] args) {
		// 다중 for문에 대해서 알아봅니다.
		// 다중 for문이라 함은 for문 속에 또 다른 for문이 있는 것을 말한다.
		
		/*
		   === 출력결과 ===
		 	abcdefg		3행(가로) 7열(세로)
		 	hijklmn
		 	opqrstu
		 */
		char ch = 'a';
		for ( int i=0 ; i<3; i++) { // 바깥 for문 ==> 핼
		
			for(int j=0; j<7; j++) { // 내부 for문 ==> 열 
				System.out.print(ch++);
			}

			System.out.println();
			
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		/*
		 	= 단일 for문을 사용하여 아래처럼 나오도록 하세요 =
		 	abcdefg
		 	hijklmn
		 	opqrstu
		 */
		
		ch = 'a';
		
		for(int i=0; i<'u'-'a'+1; i++) {
			System.out.print(ch++);
			if( (i+1)%7 == 0 ) {
				System.out.println();
			}
		}// end of for ------------------------------------------------------
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	/*
       이중 for문을 사용하여 아래처럼 나오도록 하세요.
       == 출력결과 == 
        [0,0][0,1][0,2]   4행3열
        [1,0][1,1][1,2]
        [2,0][2,1][2,2]
        [3,0][3,1][3,2]
     */
		
		for(int i=0; i<4; i++) { //4행
			for(int j=0 ; j<3; j++) { //3열
				System.out.print("["+i+","+j+"]");
			}//end of for
			System.out.println();
		} // end of for
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
	       이중 for문을 사용하여 아래처럼 나오도록 하세요.
	       == 출력결과 == 
	        [0,0][0,1][0,2]   
	        [1,0][1,1][1,2]
	        [3,0][3,1][3,2]
	     */
		// ※ continue; ==> continue; 를 만나면 가장 가까운 반복문의 증감식으로 이동한다.
		
		for(int i=0; i<4; i++) { 
			if(i==2) continue; // continue;가 되어지면 밑으로 내려가지 않고 가장 가까운 반복문의 증감식으로 이동한다.
			
			for(int j=0 ; j<3; j++) {
				System.out.print("["+i+","+j+"]");
			}//end of for
			System.out.println();
		} // end of for
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		/*
	       이중 for문을 사용하여 아래처럼 나오도록 하세요.
	       == 출력결과 == 
	        [0,0][0,2]   
	        [1,0][1,2]
	        [3,0][3,2]
	     */
		// ※ continue; ==> continue; 를 만나면 가장 가까운 반복문의 증감식으로 이동한다.
		
		for(int i=0; i<4; i++) { 
			if(i==2) continue; // continue;가 되어지면 밑으로 내려가지 않고 가장 가까운 반복문의 증감식으로 이동한다.
			
			for(int j=0 ; j<3; j++) {
				if(j==1) continue;
				System.out.print("["+i+","+j+"]");
			}//end of for
			System.out.println();
		} // end of for
		
		System.out.println("\n안녕하세요 \t \"좋은아침\"\t 입니다.");
		// \n 줄바꿈 \" 쌍따옴표 \t 탭
		
		
		System.out.println(">> [퀴즈] 아래처럼 나오도록 하세요<<\n");
		/*
		  501호 502호 503호 505호
		  301호 302호 303호 305호
		  201호 202호 203호 205호
		  101호 102호 103호 105호
		 */
		
		for(int i=5 ; 0<i ; i--) {
			if(i == 4) continue;
			for(int j=1; j<=5; j++ ) {
				if(j==4) continue;
			System.out.print(i + "0" + j +"호\t");
		}
		System.out.println();
	}
		
	} // end of public static void main(String[] args)

} // end of  public class MultiForMain
