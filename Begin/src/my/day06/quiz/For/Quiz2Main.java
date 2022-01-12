package my.day06.quiz.For;

public class Quiz2Main {

	public static void main(String[] args) {

		
		int alph = 'Z'-'A';
		
		for(int i=0; i<=alph; i++) {
			char ch = (char)('A'+i);
					
			if( i%2==1 ) {
				ch+=32;
			}
			
			String add = (i>alph-1)?"":",";
			System.out.print(ch+add);
			
	
			
			
		} // end of for

	}
}



	


