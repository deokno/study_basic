package my.day0809.c.array;

public class Member {

	// field
	String id;
	String passwd;
	String name;
	int point;
	static int count = 2;

	// method
	// 특정 사용자의 개인정보를 보여주도록 하는 메소드
	public String showMyInfo() {
		return "1.아이디 : "+id+"\n"
				+"2.비밀번호 : "+passwd+"\n"
				+"3.성명 : "+name+"\n"
				+"4.포인트 : "+point+"\n";
				
	}
	
	
/*	
	public String ShowInfo(String id) {
		return "1.아이디 : " + id + "\n" + "2.비밀번호 : " + passwd + "\n" + "3.성명 : " + name + "\n" + "4.포인트 : " + point;
	}
*/
	// 특정 사용자의 비밀번호를 제외한 개인정보를 보여주도록 하는 메소드
	public String ShowInfo() {
		return id + "\t" + name + "\t" + point;
	}
	
	
}