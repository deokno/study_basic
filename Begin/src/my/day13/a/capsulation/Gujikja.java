package my.day13.a.capsulation;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Gujikja {

	// filed 생성
	private String userid; // 아이디
	private String passwd; // 비밀번호
	private String name; // 성명
	private String jubun; // 주민번호 앞의 7자리 까지만
	// 예 : "9512201" 남자 "0112203" 남자
	// 예 : "9512202" 여자 "0112204" 여자

	static int count; // Gujikja 객체(인스턴스)의 개수를 알아오려는 용도

	// method 생성(==> field(속성)를 어떤 방식으로 처리하고자 할때 메소드를 통해서 처리한다.)

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		// 아이디(글자수가 5글자 이상 10글자 이하)
		
		if (!(userid == null || userid.trim().isEmpty())) {

			int len = userid.length();
			if (5 <= len && len <= 10) {
				this.userid = userid;
			} else {
				System.out.println(">>[경고]아이디는 5글자 이상 10글자 이하이어야 합니다. <<\n");
			}

		} else {
			System.out.println(">>[경고]아이디는 null 또는 공백만으로 될 수는 없습니다.  <<\n");
		}

	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		
		if(MyUtil.isCheckPasswd(passwd)) {
			this.passwd = passwd;
		}else {
			System.out.println(">>[경고] 비밀번호는 8글자 이상 15글자 이하의 대,소문자 및 숫자, 특수문자가 혼합되어야만 합니다. <<\n");
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		// name에는 한글만 허용하겠다. 글자수는 2글자 이상 5글자 이하까지만 허용
		
		// 정규표현식(Regular Expression)이란?
	    // ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어
		
		// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		Pattern p = Pattern.compile("^[가-힣]{2,5}$");
		
		// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
		Matcher m = p.matcher(name); 
		
		// == 3. 판별하도록 한다. == //
	    // 주어진 정규식 패턴과 일치하면  true, 일치하지 않으면 false 를 리턴시켜준다.
		
		if(m.matches()) {
			this.name = name;
		}else {
			System.out.println(">>[경고] 성명은 공백없이 한글로만 2글자 부터 5글자까지만 가능합니다. <<\n");
		}
		
	}

	public String getJubun() {
		return jubun;
	}

	public void setJubun(String jubun) {
		
		if(MyUtil.isCheckJubun(jubun)) {
			this.jubun = jubun;
		}else {
			System.out.println(">> [경고] 주민번호 앞의 7자리가 올바르지 않습니다. <<\n");
		}
		
	}
	
	// userid, passwd, name, jubun 필드의 값이 모두 null이 아니라면 올바르게 데이터를 입력한 경우이므로
	// true를 리턴해주고, 적어도 1개 이상이 null이라면 잘못 입력된 데이터 이므로 false를 리턴해주는 메소드를 생성한다.
	public boolean isUseGujikja() {
		
		if( userid != null &&
			passwd != null &&
			name != null &&
			jubun != null)
			return true;
		else 
			return false;
		
	}
	
	// == 구직자의 현재나이를 일려주는 메소드 생성하기 == //
	public int getAge() {

		// "9512201" "9512202" "0112203" "0112204"
		// 현재나이 = 현재년도 - 태어난년도 + 1

		Calendar currentDate = Calendar.getInstance();
		// 현재날짜와 시간을 얻어온다.

		int currenYear = currentDate.get(Calendar.YEAR);

		String sGender = jubun.substring(jubun.length() - 1); // "1" 또는 "2", "3", "4"

		int birthYear = 0;
		if ("1".equals(sGender) || "2".equals(sGender)) {
			birthYear = Integer.parseInt(jubun.substring(0, 2)) + 1900;
			// 95+1900
		} else {

			birthYear = Integer.parseInt(jubun.substring(3, 4)) + 2000;
		}
		// 95 1 + 1900 또는 2000
		// 1995 2001
		return currenYear - birthYear + 1;

	}// end of getAge()

	// == 구직자의 성별을 일려주는 메소드 생성하기 == //
	public String getGender() {
		String sGender = jubun.substring(jubun.length() - 1);

		if ("2".equals(sGender) || "4".equals(sGender)) {
			return "여";
		} else {
			return "남";
		}
	}

	// == 구직자 1명의 정보를 보여주는 메소드 생성하기 == //
	public void showInfo() {
		System.out.println("1.아이디 : " + userid + "\n" + "2.비밀번호 : " + passwd + "\n" + "3.성명: " + name + "\n"
				+ "4.현재나이 : " + getAge() + "\n" + "5.성별 : " + getGender() + "\n");
	}// end of showInfo()

	public void viewInfo() {
		System.out.printf("%-10s\t%-15s\t%-8s\t%3d\t%-2s\n", userid, passwd, name, getAge(), getGender());
	}
	
	public String getInfo() {
		return userid+"   "+passwd+"   "+name+"   "+getAge()+"   "+getGender();
	}

}
