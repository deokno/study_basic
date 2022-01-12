package my.day04.a.scanner;

import java.util.Scanner;

public class Scanner5Main {

	public static void main(String[] args) {

		System.out.println("== 키보드로 부터 2개의 숫자를 입력받아서 사칙연산(+ - * /)한 결과 알아보기 == \n");

		Scanner sc = new Scanner(System.in);
	
		String inputStr = "";
		
		try {
			System.out.print(">>첫번째 정수 입력 :");
			inputStr = sc.nextLine();  // "25"
	      							   // "똘똘이"
		
		// 	"문자열"을 int타입으로 형변환 시켜주는 방법
			int num1 = Integer.parseInt(inputStr); 
			
			System.out.print(">>두번째 정수 입력 :");
			inputStr = sc.nextLine();  // "2"
									   // "안녕"
		
			int num2 = Integer.parseInt(inputStr);
		// 	[참고]int타입을 "문자열"로 형변환 시켜주는 방법
			String str_num1 = Integer.toString(num1);
			String str_num2 = String.valueOf(num2);
			
			
			System.out.print(">>사칙연산(+ - * /) 선택 :");   // "+"
															// "-"
															// "*"
															// "/"
			String operator = sc.nextLine(); 
			
			
			double result = 0;
			boolean b_flag = false;
			
			
			switch (operator) {
			case "+": 
				result = num1 + num2 ;
				
				break; // switch 문에서 break;를 만나면 switch문을 빠져나간다는 말이다.

			case "-": 
				result = num1 - num2 ;
				
				break;

			case "*": 
				result = num1 * num2 ;
				
				break;

				
			case "/": 
				result = (double)num1 / num2 ;
				
				break;
		
			
			default: 
				b_flag = true;
					 
				
				break;
			} //end of switch (operator)
		
			if( b_flag == false) { // operator가 "+" 또는 "-" 또는 "*" 또는 "/" 인 경우
				
				if("/".equals(operator)) { // "문자열1"과 "문자열2"의 값이 같은지 다른지를 비교할때는 == 또는 != 를 쓰면 안된다.
						// "문자열1".equals("문자열2")을 사용한다.
						// 만약에 "문자열1" 와 "문자열2" 의 값이 같다라면 "문자열1".equals("문자열2")은 true가 되고,
						// 만약에 "문자열1" 와 "문자열2" 의 값이 다르다면 "문자열1".equals("문자열2")은 false가 된다.
					
					System.out.println(">>결과1 : "+ num1 + operator + num2 +"=" + result);
				}
				else {
					System.out.println(">>결과2 : "+ num1 + operator + num2 +"=" + (int)result);
				}
			}
			else {
				System.out.println(">>"+ operator+"사칙연산(+ - * /)이 아니므로 계산이 불가합니다.!! <<");
			}
			
		} catch(NumberFormatException e) {
			System.out.println(">> "+inputStr+" 은(는) 정수가 아닙니다. 정수만 입력하세요!! <<");
		}
		
		
		
		
		sc.close();
		
	}// end of ain(String[] args)

}
