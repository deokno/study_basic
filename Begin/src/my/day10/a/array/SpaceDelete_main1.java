package my.day10.a.array;

public class SpaceDelete_main1 {

	public static void main(String[] args) {
		// === 입사문제 : 문자열 중 공백 제거하기 === //
	
		String str = "  korea   seou l 쌍용 강북 교육센터  ";
		System.out.println(str);
		
		// 기댓값 "koreaseoul쌍용강북교육센터" ;   
		
		char[] chArr = str.toCharArray();
		/*
	       --------------------------------------------------------------------------------------------------------------------------
	       |' '|' '|'k'|'o'|'r'|'e'|'a'|' '|' '|' '|'s'|'e'|'o'|'u'|' '|'l'|' '|'쌍'|'용'|' '|'강'|'북'|' '|'교'|'육'|'센'|'터'|' '|' '|         
	       --------------------------------------------------------------------------------------------------------------------------    
	    */
		str = ""; 
		for(int i=0; i<chArr.length; i++) {
			if(chArr[i] != ' ') {
				str += chArr[i];
			}
		}
		
		System.out.println(str);
		System.out.println("글자길이 :"+str.length());
		
		
		
	}

}
