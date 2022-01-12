package my.day06.b.multiFor.gugudan;

public class Gugudan_main3 {

	
	
/*   
	   ~~~~~ 구구단 4단씩 끊기(!!입사문제!!) ~~~~~

	   2*1=2    3*1=3    4*1=4    5*1=5   
	   2*2=4    3*2=6    4*2=8    5*2=10   
	   2*3=6    3*3=9    4*3=12   5*3=15   
	   2*4=8    3*4=12   4*4=16   5*4=20   
	   2*5=10   3*5=15   4*5=20   5*5=25   
	   2*6=12   3*6=18   4*6=24   5*6=30   
	   2*7=14   3*7=21   4*7=28   5*7=35   
	   2*8=16   3*8=24   4*8=32   5*8=40   
	   2*9=18   3*9=27   4*9=36   5*9=45   

	   6*1=6    7*1=7    8*1=8    9*1=9   
	   6*2=12   7*2=14   8*2=16   9*2=18   
	   6*3=18   7*3=21   8*3=24   9*3=27   
	   6*4=24   7*4=28   8*4=32   9*4=36   
	   6*5=30   7*5=35   8*5=40   9*5=45   
	   6*6=36   7*6=42   8*6=48   9*6=54   
	   6*7=42   7*7=49   8*7=56   9*7=63   
	   6*8=48   7*8=56   8*8=64   9*8=72   
	   6*9=54   7*9=63   8*9=72   9*9=81   
*/
	
	public static void main(String[] args) {

		System.out.println("==== 구구단 4단씩 끊기 ====");
	
		for(int dan=2; dan<10; dan+=4) { // 4개 dan씩 끊음
										 // 2단 부터 시작해서 5단까지 하는 것,
										 // 6단 부터 시작해서 9단까지 하는 것.
			
			for(int jul=1 ; jul<=9; jul++) { // jul은 각 단마다 곱해지는 수이다. (9행)
				
				for(int i=0+dan; i<4+dan; i++) {
					System.out.print(i+"*"+jul+"="+(i*jul)+"\t"); 
					
				} // end of for
				
				System.out.println();
				
			} // end of for
			
			System.out.println();
			
		}// end of for ----------------------------------------------
		
	
	
	
/*
	    == 구구단 3단씩 끊기 ==

	   1*1=1    2*1=2    3*1=3   
	   1*2=2    2*2=4    3*2=6   
	   1*3=3    2*3=6    3*3=9   
	   1*4=4    2*4=8    3*4=12   
	   1*5=5    2*5=10   3*5=15   
	   1*6=6    2*6=12   3*6=18   
	   1*7=7    2*7=14   3*7=21   
	   1*8=8    2*8=16   3*8=24   
	   1*9=9    2*9=18   3*9=27   
	   
	   4*1=4    5*1=5    6*1=6   
	   4*2=8    5*2=10   6*2=12   
	   4*3=12   5*3=15   6*3=18   
	   4*4=16   5*4=20   6*4=24   
	   4*5=20   5*5=25   6*5=30   
	   4*6=24   5*6=30   6*6=36   
	   4*7=28   5*7=35   6*7=42   
	   4*8=32   5*8=40   6*8=48   
	   4*9=36   5*9=45   6*9=54   
	   
	   7*1=7    8*1=8     9*1=9   
	   7*2=14   8*2=16   9*2=18   
	   7*3=21   8*3=24   9*3=27   
	   7*4=28   8*4=32   9*4=36   
	   7*5=35   8*5=40   9*5=45   
	   7*6=42   8*6=48   9*6=54   
	   7*7=49   8*7=56   9*7=63   
	   7*8=56   8*8=64   9*8=72   
	   7*9=63   8*9=72   9*9=81     
*/
	
	System.out.println("==== 구구단 3단씩 끊기  ====");
	
	for(int dan=1;dan<=9;dan+=3) {
		
		for(int jul=1; jul<=9; jul++) {
			for(int i=0+dan; i<3+dan; i++) {
				System.out.print(i+"*"+jul+"="+(i*dan)+"\t");
			}// end of for3
			System.out.println();
		}//end of for2
		System.out.println();
	}//end of for1
	
	
	
	}

}
