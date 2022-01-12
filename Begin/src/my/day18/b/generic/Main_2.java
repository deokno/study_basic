package my.day18.b.generic;

import java.util.List;

public class Main_2 {

	public static void main(String[] ags) {

		Box_Employee<Employee_Child_Executive> box_Executive = new Box_Employee<>();
		box_Executive.register(new Employee_Child_Executive("hansk","1234","한석규","사장","1-01"));
		box_Executive.register(new Employee_Child_Executive("dusk","1234","두석규","전무","2-01"));
		box_Executive.register(new Employee_Child_Executive("sesk","1234","세석규","상무","3-01"));
		
		List<Employee_Child_Executive> executive_list = box_Executive.getList();
		for(Employee_Child_Executive executive : executive_list) {
			System.out.println(executive);
		}
			/*
			== 임직원 ==
				1.아이디: hansk
				2.비밀번호: 1234
				3.성명: 한석규
				4.직급: 사장
				5.법인카드번호 : 1-01

				== 임직원 ==
				1.아이디: dusk
				2.비밀번호: 1234
				3.성명: 두석규
				4.직급: 전무
				5.법인카드번호 : 2-01

				== 임직원 ==
				1.아이디: sesk
				2.비밀번호: 1234
				3.성명: 세석규
				4.직급: 상무
				5.법인카드번호 : 3-01
			*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		Box_Employee<Employee_Child_Plain> box_plain = new Box_Employee<>();
		
		box_plain.register(new Employee_Child_Plain("leess","qwer","이순신","부장",8000));
		box_plain.register(new Employee_Child_Plain("eomjh","qwer","엄정화","과장",6000));
		box_plain.register(new Employee_Child_Plain("hongkd","qwer","홍길동","대리",4000));

		List<Employee_Child_Plain> plain_list = box_plain.getList();
		
		for(Employee_Child_Plain plain : plain_list) {
		 System.out.println(plain);	
		}
		/*
		 	== 일반직원 ==
			1.아이디: eomjh
			2.비밀번호: qwer
			3.성명: 엄정화
			4.직급: 과장
			5.연봉 : 6000만원
			
			== 일반직원 ==
			1.아이디: hongkd
			2.비밀번호: qwer
			3.성명: 홍길동
			4.직급: 대리
			5.연봉 : 4000만원
		 */
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Box_Employee<Employee> box_all = new Box_Employee<>();
		
		box_all.register(new Employee("superman","1234","슈퍼맨","부장"));
		box_all.register(new Employee_Child_Executive("batman","6789","배트맨","이사","4-01"));
		box_all.register(new Employee_Child_Plain("wonderwoman","0070","원더우먼","과장",9000));
		
		List<Employee> emp_list = box_all.getList();
		
		for(Employee emp:emp_list) {
			System.out.println(emp);
		}
		
		/*
		 	1.아이디: superman
			2.비밀번호: 1234
			3.성명: 슈퍼맨
			4.직급: 부장
			
			== 임직원 ==
			1.아이디: batman
			2.비밀번호: 6789
			3.성명: 배트맨
			4.직급: 이사
			5.법인카드번호 : 4-01
			
			== 일반직원 ==
			1.아이디: wonderwoman
			2.비밀번호: 0070
			3.성명: 원더우먼
			4.직급: 과장
			5.연봉 : 9000만원

		 */
		
		
		
	}//end of main(String[] ags) 

}
