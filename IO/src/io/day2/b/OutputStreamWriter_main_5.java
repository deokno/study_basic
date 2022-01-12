package io.day2.b;

import java.io.*;

public class OutputStreamWriter_main_5 {

	/*
	 * 소스 - C:/iotestdata/오늘의날씨.txt
	 * FileReader ==> 2byte 기반
	 * 
	 * 브릿지 스트림 OutputStreamWriter => 1byte를 2byte로 변경
	 * 목적지 - 출력노드 스트림 System.out => 1byte 기반
	 */

	public static void main(String[] args) {

		try {
			String srcFileName = "C:/iotestdata/오늘의날씨.txt";

			FileReader fr = new FileReader(srcFileName);
			// fr 은 2byte 기반임.
			
			OutputStreamWriter ostWriter = new OutputStreamWriter(System.out);
			
			int input = 0;
			
			while((input = fr.read()) != -1 ) {
				ostWriter.write(input);
				ostWriter.flush();
			}// end of while
			
			ostWriter.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end of main(String[] args)
	
/*
 	실행은 아래와 같이 명령 프롬프트에서 한다.
		C:\NCS\workspace(java)\IO\bin>java io.day2.b.OutputStreamWriter_main_5
		오늘은 아침부터 춥다가 오후에는 조금 풀리겠습니다. 저녁에는 눈이 온대요~~
		
 */
	

}
