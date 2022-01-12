package my.day19.e.ENUM;

// >> === enum(열거형)에 멤버(field, method) 추가하기 === <<<
// 모든 enum(열거형)은 추상 클래스 Enum 의 자손이다. 그러므로 field 및 생성자와 method를 만들 수 있다.

public enum EntranceFee_2 {

	// !!! 사실은 열거형 상수 CHILD, TEENAGER, ADULT, OLD 하나 하나가 자기자신인 EntranceFee_2 객체라는 것이다. !!! 
	// 단체관람시 각 연령대별 할인금액(추상메소드로 만들어서 객체 생성시 반드시 재정의 하도록 강제하는 것임)을 달리 적용하여 실제 입장료 금액을 계산하도록 한다.
	
	CHILD(0){

		@Override
		int getRealFee(int inwonsu) {
			return 0;
		}
		
	},
	
	TEENAGER(150) {

		@Override
		int getRealFee(int inwonsu) {
			if(inwonsu >= 20) 
				return (int)(FEE * inwonsu*0.8);
			else
				return FEE * inwonsu;
		}
		
	},
	
	ADULT(300){

		@Override
		int getRealFee(int inwonsu) {
			if(inwonsu >= 20) 
				return (int)(FEE * inwonsu*0.9);
			else
				return FEE * inwonsu;
		}
		
	},
	
	OLD(100){

		@Override
		int getRealFee(int inwonsu) {
			if(inwonsu >= 20) 
				return (int)(FEE * inwonsu*0.7);
			else
				return FEE * inwonsu;
		}
		
	}; // 끝에 ;을 붙여야 한다.
	
	protected final int FEE;
	// !!!! private 으로 하면 위의 열거형 상수에서는 접근이 불가능해진다. !!!!
	// !!!! 접근제한자를 default 로 주든지 아니면 protected로 주어야만 위의 열거형 상수에서 접근이 가능해진다. !!!!
	// enum(열거형)의 인스턴스 변수(FEE)는 반드시 final 이어야 한다는 규칙은 없지만 
	// FEE는 열거형 상수값을 저장하기 위한 용도이므로 final을 붙인 것이다. 
	
	EntranceFee_2(int fee) {
	// enum(열거형)의 생성자는 접근제한자가 private이 생략되어져 있는 것이다. 
		this.FEE = fee;
	}
	
	public int getFee() {
	// 외부에서 FEE 값을 읽을 수 있도록 접근제한자를 public으로 준다.
		return FEE;
	}

	// !!! 입장인원수에 따라 할인이 적용된 실제 입장료 금액을 알려주는 추상(미완성)메소드 !!!
	abstract int getRealFee(int inwonsu);
	
	
}
