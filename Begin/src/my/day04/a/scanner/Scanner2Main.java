package my.day04.a.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scanner2Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		
		System.out.print("정수를 입력하세요 => ");
		
		try { 
			int inputNum = sc.nextInt();  // 정수 엔터
											// 글자 엔터 

			sc.nextLine();
			System.out.println("입력한 정수 : " + inputNum);
		} catch(InputMismatchException e ) {
			System.out.println(">>>정수만 입력하세요!<<<  \n");
			e.printStackTrace();
			
		}
		
		
		
		
		sc.close();
		
	}

}
