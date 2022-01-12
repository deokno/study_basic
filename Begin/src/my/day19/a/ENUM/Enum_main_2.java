package my.day19.a.ENUM;

import java.util.Calendar;

public class Enum_main_2 {

	public static void main(String[] args) {

		Calendar currentDate = Calendar.getInstance();  // 현재 날짜와 시간을 얻어온다. 
		int currentmonth = currentDate.get(Calendar.MONTH)+1; // 현재 월
		
		System.out.println(currentmonth);
		// 12
		
		String season = null;
		
		if( 1<= currentmonth && currentmonth <=2 || currentmonth == 12) {
			season = Season_1.WINTER;
		}
		else if( 3<= currentmonth && currentmonth <=5 ) {
			season = Season_1.SPRING;
		}
		else if( 6<= currentmonth && currentmonth <=8 ) {
			season = Season_1.SUMMER;
		}
		else if( 9<= currentmonth && currentmonth <=11 ) {
			season = Season_1.AUTUMN;
		}
		System.out.println(season);
		// 겨울
		
		System.out.println("\n==================================================\n");
		
		if( 1<= currentmonth && currentmonth <=2 || currentmonth == 12) {
			season = "하하하";
		}
		else if( 3<= currentmonth && currentmonth <=5 ) {
			season = "호호호";
		}
		else if( 6<= currentmonth && currentmonth <=8 ) {
			season = "헤헤헤";
		}
		else if( 9<= currentmonth && currentmonth <=11 ) {
			season = "히히히";
		}
		System.out.println(season);
		// 하하하
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
		 	위와 같이 우리가 기대하는 값인 사계절명(봄, 여름, 가을, 겨울)이 아닌 String 타입만 되면 
		 	어떤 것이든지 들어올 수 있기 때문에 자바는 오류가 아니지만 사용자 측면에서는 오류가 발생될 수 있다.
		 	이러한 경우 "서로 연관된 상수들의 집합" 을 의미하는 enum(열거형)이라는 타입을 사용하여 해결할 수 있다.
		 */
		
		SeasonType_3 stype = null;

		if( 1<= currentmonth && currentmonth <=2 || currentmonth == 12) {
			stype = SeasonType_3.겨울;
		}
		else if( 3<= currentmonth && currentmonth <=5 ) {
			stype = SeasonType_3.봄;
		}
		else if( 6<= currentmonth && currentmonth <=8 ) {
			stype = SeasonType_3.여름;
		}
		else if( 9<= currentmonth && currentmonth <=11 ) {
			stype = SeasonType_3.가을;
		}
		
		System.out.println(stype);
		// 겨울 
		
		
		System.out.println("\n==============================================================\n");
		// stype 변수에는 enum으로 열거된 SeasonType_3.봄, SeasonType_3.여름, SeasonType_3.가을, SeasonType_3.겨울 이외의 값은 들어올 수 없게 된다.
		// 그러므로 아래와 같이 할 수 없다. 
	/*	
		if( 1<= currentmonth && currentmonth <=2 || currentmonth == 12) {
			stype = "하하하"; // 오류발생함.
			stype = "겨울";  // 오류발생.
	*/		
		
		switch (stype) {
//		case "하하하": // 오류발생함
//		case SeasonType_3.봄: // SeasonType_3.봄 이라고 하면 오류임.
//		case "봄" // "봄" 이라고 하면 오류임.
		case 봄 : 
			System.out.println("따스한 봄 입니다.");
			break;

		case 여름 : 
			System.out.println("무더운 여름 입니다.");
			break;
			
		case 가을 : 
			System.out.println("시원한 가을 입니다.");
			break;
			
		case 겨울 : 
			System.out.println("추운 겨울 입니다.");
			break;
			
		}
		// 추운 겨울 입니다.
		
		
		
		}//end of main(String[] args)

		
}




