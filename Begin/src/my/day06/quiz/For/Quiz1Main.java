package my.day06.quiz.For;

import java.util.*;

public class Quiz1Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("▷ 문자열을 입력하세요 : ");
	
		
		String inputStr = sc.nextLine();
		
		sc.close();	

//		Integer length = inputStr.length();
		int i=0, cntUpper=0;
		int cntLower = 0;
		int cntDg = 0;
		int cntSc = 0;
		
//		try {
		
		for(;i<inputStr.length(); i++) { 
			
			char str = inputStr.charAt(i);
				if(str >='A' && str <= 'Z') {
					cntUpper++;
				}
				else if(str >='a' && str <= 'z') {
					cntLower++;
				}

				else if(str >='0'&& str <= '9') {
					cntDg++;
				}
				else{ 
					cntSc++;
				}
				
		}// end of for
	
//			}catch (InputMismatchException e) {
//			System.out.println(">>대문자, 소문자, 숫자, 특수문자가 아닌 문자가 있습니다. <<\n");
//		}
 
		/*
		int cntLower = 0;
		for(i=0;i<length;i++) {
			char ch = inputStr.charAt(i);
				if(ch >='a' && ch <= 'z') {
				cntLower++;
				}
		}// end of for
		
		int cntDg = 0;
		for(i=0;i<length; i++) {
			char ch = inputStr.charAt(i);
				if(ch >='0'&& ch <= '9') {
					cntDg++;
				}
		}// end of for
		
		int cntSc = 0;
		for(i=0;i<length; i++) {
			char ch = inputStr.charAt(i);
				if(32 <= ch && ch <= 47) {
					cntSc++;
				}
		}// end of for
		*/
		System.out.println("입력한 문자열 : "+ inputStr+"\n"
						  +"입력한 문자열의 길이 : " + inputStr.length()+"\n"
						  +"대문자 개수 : " + cntUpper +"개\n"
						  +"소문자 개수 : " + cntLower +"개\n"
						  +"숫자 개수 : " + cntDg+"개\n"
						  +"특수문자 개수 : " + cntSc +"개\n"
						  );
		
		
	// 한글 입력했을 시 경고문 나오게 하는 방법 모르겠습니다... 	
		
		
		
		
	
	
	
	} //end public static void main(String[] args) 

} //end of public class Quiz1Main
