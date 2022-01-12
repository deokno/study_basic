package my.day06.quiz.For;

public class Quiz2 {
	
	

	
	public static void main(String[] args) {

	
		char big = 'A';
		char small = 'b';
		
		for(int i=1; i<=26; i++) {
			if(i%2==1) {
				System.out.print(big+",");
				big+=2;
			}
			
			else if(i==26) {
					System.out.println(small);
			}
			
			else {
				System.out.print(small+",");
				small+=2;
				}
			 } //end of for
			
			
			    
		}
			
   
  }