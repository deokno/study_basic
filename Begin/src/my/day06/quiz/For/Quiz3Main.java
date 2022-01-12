package my.day06.quiz.For;

import java.util.Scanner;

public class Quiz3Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print( "▷ 휴대폰 번호를 입력하세요(예> 010-2345-6789) : ");
		String num =sc.nextLine();

		
		
				
			String str = "";
			for(int i=0; i<num.length() ; i++) {
				
				char ch = num.charAt(i);
				
				if(ch=='-') { 
					 continue;
				}
				else { 
					str += ch;
					 
				}
				
			}
	
		
		System.out.println(str);
		
		sc.close();
		
		
	}// end of public static void main(String[] args) 

}//public class Quiz3Main
