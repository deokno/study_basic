package my.day15.b.abstractClass;

public class Dog extends Animal {

	// Dog만 가지는 field 를 정의 (추상화)
	private int weight;
	
	
	// Dog만 가지는 method 를 정의 (추상화)
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight > 0) {
			this.weight = weight;
		}
	}

	
	// === 메소드 오버라이딩(override)(메소드 재정의) ===
	// 메소드 오버라이딩( 메소드 재정의)란?
	// ==> 부모클래스로 부터 상속받은 메소드를 내용물만 새롭게 바꾸어서 정의하는 것을 말한다.
	// 메소드 오버라이딩 시 접근제한자는 부모클래스에서 주었던 접근제한자와 같거나 또는 더 크게 허용하는 접근제한자를 사용해야 한다.
	@Override  // @ 로 되어진 것을 "어노테이션" 이라고 부른다.
	public void cry() {
		System.out.println("강아지 "+getName()+"이(가) '멍멍'하며 짖습니다.");
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("3. 체중 : "+ weight + "Kg\n");
	}
	

	@Override
	public void move() {
		System.out.println("강아지 "+ getName()+"가 빠르게 달립니다.");
		
	}
	
}
