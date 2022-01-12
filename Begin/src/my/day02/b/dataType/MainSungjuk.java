package my.day02.b.dataType;

public class MainSungjuk {

	public static void main(String[] args) {
		
		Sungjuk lssSj = new Sungjuk();   // lssSj
		// lssSj참조형 타입(Reference Type) 이다.
		
		lssSj.hakbun = "091234";		 // "091234"
		lssSj.name = "이순신"	;			 // "이순신"
		lssSj.korPoint = 68;			 // 68
		lssSj.eng_point = 95;			 // 95
		lssSj.mathpoint = 100;			 // 100
		
		Sungjuk eomSj = new Sungjuk();
		// eomSj참조형 타입(Reference Type)이다.
		
		eomSj.hakbun = "109876";
		eomSj.name = "엄정화";
		eomSj.korPoint = 100;
		eomSj.eng_point = 100;
		eomSj.mathpoint = 100;
		
		
		lssSj.showSungjuk();
				
		/*
		   === 이순신 성적결과 ===
		   1. 학번 : 091234
		   2. 성멸 : 이순신
		   3. 국어 : 68
		   4. 영어 : 95
		   5. 수학 : 100
		   6. 총점 : 263
		   7. 평균 : 87.66666666666667
		   
		 */
		
		eomSj.showSungjuk();

		/*
		   === 엄정화 성적결과 ===
		   1. 학번 : 109876
		   2. 성멸 : 엄정화
		   3. 국어 : 78
		   4. 영어 : 88
		   5. 수학 : 95
		   6. 총점 : 261
		   7. 평균 : 87
		   
		 */
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		
		
		System.out.println("lssSj =>" + lssSj);
		//lssSj =>my.day02.dataType.Sungjuk@2401f4c3
		
		System.out.println("eomSj =>" + eomSj);
		//eomSj =>my.day02.dataType.Sungjuk@7637f22
		
		Sungjuk kangSj = new Sungjuk();
			
		System.out.println("kangSj =>" + kangSj);
		//kangSj =>my.day02.dataType.Sungjuk@4926097b
		
		kangSj = lssSj;
		
		System.out.println("kangSj =>" + kangSj);
		//kangSj =>my.day02.dataType.Sungjuk@2401f4c3
		
		System.out.println("lssSj =>" + lssSj);
		//lssSj =>my.day02.dataType.Sungjuk@2401f4c3
		
		
		System.out.println("\n##########################\n");

		kangSj.name = "강감찬" ;
		kangSj.korPoint = 5;
		
		lssSj.showSungjuk();
		
	}

}
