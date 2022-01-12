package my.day18.c.generic;

import java.util.*;


// === 필드 생성시 타입에 제한이 있거나 또는 필드 생성시 제한이 없는 클래스 생성하기 ===


public class Box_wildcard_Employee { 
	
	private List<Box_Anything<?>> anything_list = new ArrayList<>();
	//						<?> 은 아무거나
	
	public void register_anything(Box_Anything<?> item) {
		anything_list.add(item);
	}
	
	public List<Box_Anything<?>> get_anything() {
		return anything_list;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	private List<Box_Anything<? super Employee_Child_Executive>> executive_list = new ArrayList<>();
	// 		하한제한 
	// 		? super Employee_Child_Executive 은 
	//		Employee_Child_Executive 부터 Employee_Child_Executive의 조상(부모의 부모의 부모의 .......) 클래스 까지만 타입으로 들어올 수 있다. 
	
	public void register_executive(Box_Anything<? super Employee_Child_Executive> item ) {
		executive_list.add(item); 
	}
	
	public  List<Box_Anything<? super Employee_Child_Executive>> get_executive() {
		return executive_list;
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	
	private List<Box_Anything<? extends Employee_Child_Plain>> plain_list = new ArrayList<>();
	// 		상한제한
	// 		? super Employee_Child_plain 은 
	//		Employee_Child_plain을 포함한 Employee_Child_plain의 자식클래스 까지만 타입으로 들어올 수 있다. 
	
	public void register_plain( Box_Anything<? extends Employee_Child_Plain> item ) {
		plain_list.add(item); 
	}
	
	public List<Box_Anything<? extends Employee_Child_Plain>> get_plain() {
		return plain_list;
	}
	
}
