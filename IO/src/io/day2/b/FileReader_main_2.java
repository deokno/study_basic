package io.day2.b;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.util.FileManager;

public class FileReader_main_2 {

	public static void main(String[] args) {
	
		String str = null;
		
		try {
			str = FileManager.reading_2(args[0]);
			// args[0] 에 C:/iotestdata/애국가2.txt 로 할 것이다. 

			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 "+ args[0] + "이 존재하지 않습니다. ");
		//	e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 "+ args[0] + "이 손상되었습니다. ");
		//	e.printStackTrace();
		}
		
		
		
	}// end of main(String[] args)
/*
 	실행은 명렴프롬프트에서 아래와 같이 한다. 
  	C:\NCS\workspace(java)\IO\bin>java io.day2.b.FileReader_main_2 C:/iotestdata/애국가2.txt
	
 	C:/iotestdata/애국가2.txt 파일은 인코딩을 ANSI로 저장한다.

*/

}