package my.day10.a.array;

import java.util.Random;

public class Lotto_main3 {

	public static void main(String[] args) {

	// 1  부터  45까지의 숫자 중 랜덤하게 6개의 숫자를 추출하도록 한다.
	// 101부터 145까지의 숫자 중 랜덤하게 6개의 숫자를 추출하도록 한다.
	
	/*
	   	int ball ==> 1 2 3 4 .... 45
	   	int ball ==> 101 102 103 .... 145
	   	
	   	int[] ballArr = new int[45];
	   	
	   	데이터값 |1|2|3|.........|45|
	   	index  0 1 2...........44
	   	데이터값 |101|102|103|...|145|
	 	index   0   1   3  ... 44
	 	
	 */
	
		int[] ballArr = new int[45];
		int[] tempArr = new int[5]; //기존에 뽑았던 방 번호를 기억시켜두는 저장소
	/*
	 		tempArr
	 	데이터값 => |0|0|0|0|0|
	 	
	 	
	 	
	 */
		
		for(int i=0; i<ballArr.length; i++) {
			ballArr[i] = i+1; // 배열의 방마다 데이터값 입력하기
							  // 데이터값은 1 ~ 45
		}
		
		for(int i=0;i<tempArr.length; i++) {
			tempArr[i] = -1;
		}
		/* 
		 	공을 꺼내어 오면 공의 방번호(index 번호)를 기억하는 곳으로 사용되는데 
		 	꺼내온 공의 방번호(index 번호)가 0(실제값은 1번공)이 들어올 수 있으므로
		 	데이터값은 방번호(index 번호)로 사용하지 않는 -1로 모두(5개) 초기화 한다.
		 */
		
		
		// 공의 방번호(ballArr 배열의 index)를 꺼내는 작업을 6번 반복
		// 0번 방 부터 44번 방까지 랜덤하게 6번 뽑아야 한다. 
		// 즉, 0부터 44까지 난수를 발생.
		
		Random rnd = new Random();
		
		String result = "";
		outer:
		for(int i=0; i<6; i++) {
			
			int idx = rnd.nextInt(44-0+1)+0;
			 
			for(int j=0; j<tempArr.length; j++) {
				if(idx == tempArr[j]) {
					//새로이 뽑아온 방번호(idx)가 기존에 뽑은 것(tempArr[j])과 같다라면 다시 새로 뽑아야 한다.
					i--;
					continue outer;
				}
			}
			
			if(i<5) {
				tempArr[i] = idx;
				//뽑은 방번호(index 번호)를 저장시켜둔다.
				
			}
				String str_add = (i==5)?"":",";
				result += ballArr[idx]+str_add;
		
		}
		
		System.out.println("\n로또 1등 당첨번호 : "+result);
		
		
		
		
		
	}// end of main(String[] args)

}
