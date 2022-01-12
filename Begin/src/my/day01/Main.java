package my.day01;



public class Main {
	
	// 콘솔프로그램의 실행은 main(String[] args) 메소드에서 실행한다.
	public static void main(String[] args)
	{
		
		//1명의 새로운 회원이 필요하다.
		Member lssmbr = new Member(); // 이순신
		// lssmbr 을 Member 클래스의 객체(==인스턴스)라고 부른다. 
		
		lssmbr.id = "leess" ;       // = 은 어떤값을 어떤 변수에 대입한다(넣어준다.)라는 뜻이다. 
		lssmbr.pwd = "abcd" ; 
		lssmbr.name = "이순신";
		lssmbr.email = "leess@naver.com";
		
		
		System.out.println("lssmbr :" + lssmbr);
		// lssmbr : my.day01.Member@379619aa
		// @다음에 나오는 16진수의 값은 메모리(RAM)상의 위치를 가리키는 것이다.
		
		
		// 또 1명의 새로운 회원이 필요하다. 
		Member emojhmbr = new Member();  //엄정화
		
		emojhmbr.id = "eomjh";  // = 은 어떤값을 어떤 변수에 대입한다(넣어준다.)라는 뜻이다.
		emojhmbr.pwd = "qwer1234"; 
		emojhmbr.name = "엄정화";
		emojhmbr.email = "emojhmbr@naver.com";
		
		
		System.out.println("eomjhmbr :" + emojhmbr);
		// emojhmbr : my.day01.Member@7de26db8
		
		/*
		 == RAM(메모리) ==
		@379619aa --> lssmbr
		 			  id ==> "leess"
		 			  pwd ==> "abcd"
		 			  name ==> "이순신"
		 			  email ==> leess@naver.com"
		 			  showInfo() 메소드
		 			  System.out.println("=== 회원정보 ===\n"   
						  + "1. 아이디 "	+ id	"\n"
						  + "2. 비밀번호 : " + pwd + "\n"
						  + "3. 성명 : " + name + "\n"
						  + "4. 이메일 : " + email + "\n"// + 는 결합을 뜻하는 것이다.
						  ); // \n 은 줄바꿈을 해주는 것이다.
		 			  
		 @7de26db8 --> emojhmbr
		 			   id ==> "eomjh"
		 			   pwd ==> "qwer1234"
		 			   name ==> "엄정화"
		 			   email ==> "emojhmbr@naver.com"
		 			   showInfo() 메소드
		 			   System.out.println("=== 회원정보 ===\n"   
						  + "1. 아이디 "	+ id	"\n"
						  + "2. 비밀번호 : " + pwd + "\n"
						  + "3. 성명 : " + name + "\n"
						  + "4. 이메일 : " + email + "\n"// + 는 결합을 뜻하는 것이다.
						  ); // \n 은 줄바꿈을 해주는 것이다.
		 */

		lssmbr.showInfo();  // lssmbr 인스턴스(객체)에 대한 회원정보 출력하기		
		emojhmbr.showInfo(); // emojhmbr 인스턴스(객체)에 대한 회원정보 출력하기
	
		
		//////////////////////////////////////////////////////////
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");
	
		lssmbr.address = "인천광역시 송도구";
		
		lssmbr.showInfo();  // lssmbr 인스턴스(객체)에 대한 회원정보 출력하기	
		emojhmbr.showInfo();  // emojhmbr 인스턴스(객체)에 대한 회원정보 출력하기
		
		
		System.out.println("\n#################\n");
		
		emojhmbr.address = "서울특별시 마포구";
		
		lssmbr.showInfo();  // lssmbr 인스턴스(객체)에 대한 회원정보 출력하기	
		emojhmbr.showInfo();  // emojhmbr 인스턴스(객체)에 대한 회원정보 출력하기
		
		System.out.println("\n@@@@@@@@@@@@@@@@@@@@\n");
		
		Member.address = "경기도 군포시";
		// static 변수는 클래스명.static변수명 으로 사용한다.
		
		lssmbr.showInfo();  // lssmbr 인스턴스(객체)에 대한 회원정보 출력하기	
		emojhmbr.showInfo();  // emojhmbr 인스턴스(객체)에 대한 회원정보 출력하기
		
		
	
	}

}
