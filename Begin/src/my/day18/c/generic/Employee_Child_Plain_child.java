package my.day18.c.generic;

public class Employee_Child_Plain_child extends Employee_Child_Plain {

	 int month;  // 계약기간개월수

	 public Employee_Child_Plain_child() {} 
	 
	 public Employee_Child_Plain_child(String userid, String passwd, String name, String jik,int salary, int month) {
		super(userid, passwd, name, jik, salary);
		this.month = month;
	}
	
	@Override
	public String toString() {
		
		return 
				super.toString()+
				"6.계약기간개월수 : "+ month+"개월\n";
	}
	
}
