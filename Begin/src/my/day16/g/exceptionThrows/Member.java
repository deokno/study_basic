package my.day16.g.exceptionThrows;

public class Member {

	// field
	String name;
	String kor;
	String eng;
	String math;
	
	
	
	// method
	void info() throws Exception {
		// 원래는 info() 메소드내에서 익셉션 처리를 해야 하지만
		// 여기서는 info() 메소드 다음에 throws Exception 을 썼으므로
		// info() 메소드내에서 익셉션 처리를 하지 않고 
		// info() 메소드를 호출하는 쪽에서  Exception 을 처리해라는 뜻이다. 
		
		
		int n_kor = Integer.parseInt(kor);
		int n_eng = Integer.parseInt(eng);
		int n_math = Integer.parseInt(math);
		
		int total = n_kor+n_eng+n_math;
		
		String info = "1. 학생명 : "+name+"\n"
					+ "2. 국어 : " + kor + "\n"
					+ "3. 영어 : " + eng + "\n"
					+ "4. 수학 : " + math + "\n"
					+ "5. 총점 : " + total + "\n";
		
		System.out.println(info);
					
					
		
		
	}//end of info() 
	
	
	
	
}
