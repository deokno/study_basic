package my.day15.a.polymorphism;

public class Cat extends Animal {
	
	// Cat 만 가지는 field 정의 (추상화)
	private String color;

	// Cat만 가지는 method 를 정의 (추상화)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if( color != null && !color.trim().isEmpty()) {
			this.color = color;
		}
	}
	// 메소드 오버라이딩
	@Override
	 public void cry() {
		 System.out.println("고양이 "+getName()+"이(가) '야옹'하며 웁니다.");
	 }

	@Override
	public void showInfo() {
		System.out.println("==== 고양이 정보 ==== \n"
				+"1. 성명 : "+getName()+"\n"
				+"2. 생년 : "+getBirthYear()+"년\n"
				+"3. 털색 : "+color+"\n"
				);
	}

	public void jump() {
		System.out.println("고양이 "+ getName()+"이 점프를 합니다.");
	}

	
	
}
