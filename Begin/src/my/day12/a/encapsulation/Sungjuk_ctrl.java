package my.day12.a.encapsulation;

public class Sungjuk_ctrl {

	public void saveSungjuk(Sungjuk_capsule[] sungjukArr, Sungjuk_capsule sj) {
		
		if( sj.isPass() ) {
			sungjukArr[Sungjuk_capsule.count++] = sj;
			System.out.println(">> 저장 성공!! << \n");
		}
		
		else {
			System.out.println(">> 저장 실패!! << \n");
		}
		
	}
	
}
