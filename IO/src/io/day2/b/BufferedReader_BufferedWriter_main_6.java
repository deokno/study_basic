package io.day2.b;

import java.io.*;

/*
	소스 -- 파일 "C:/iotestdata/myprofile.txt"
	노드스트림 -- FileReader
	필터스트림(보조스트림, 오리발) BufferedReader
	   
	   
	목적지 -- 파일 "C:/iotestdata/myprofile_복사본.txt" 
	노드스트림 -- FileWriter
	필터스트림(보조스트림, 오리발) BufferedWriter / PrintWriter       
*/

public class BufferedReader_BufferedWriter_main_6 {

	public static void main(String[] args) {

		try {
			// 소스파일이름
			String srcFileName = "C:/iotestdata/myprofile.txt";

			// 2byte 기반의 입력 노드스트림 생성(빨대 꽃기)
			FileReader fr = new FileReader(srcFileName);

			// 입력 필터스트림(보조스트림, 오리발)을 노드스트림에 장착하기
			BufferedReader bufReader = new BufferedReader(fr, 1024);

			// -----------------------------------------------------------------

			// 목적지 파일 이름
			String targetFileName = "C:/iotestdata/myprofile_복사본.txt";

			// 2byte 기반의 출력 노드스트림 생성(빨대 꽃기)
			FileWriter fw = new FileWriter(targetFileName);

			// 출력 필터스트림(보조스트림, 오리발)을 노드스트림에 장착하기
			BufferedWriter bufWriter = new BufferedWriter(fw, 1024);

			String strLine = null;
			while ((strLine = bufReader.readLine()) != null) {
				// bufReader.readLine() 메소드는 한줄 단위로 읽어와서
				// 읽어온 내용은 String 타입이므로 strLine 변수에 넣어준다.
				// 1줄을 읽어오되 엔터전까지 읽어온다.

				
				bufWriter.write(strLine); 
				// 줄바꿈을 해야한다. (strLine은 엔터전까지 읽어오기 때문에)
				bufWriter.newLine();
				// 또는
			//	bufWriter.write("\r\n"); // 엔터
				
				bufWriter.flush();
				
			} // end of while

			System.out.println("\n >>>> 파일 복사 완료 !! <<<<");
			
			// 닫을때는 항상 필터스트림(보조스트림)부터 먼저 닫고, 그 다음에 노드스트림을 닫는다. 
			bufWriter.close(); 	// 필터스트림
			fw.close();			// 노드스트림
			
			bufReader.close();
			fr.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end of main(String[] args)
	
/*
 	실행은 아래와 같이 한다.
 	먼저 탐색기에서 C:/iotestdata/myprofile_복사본.txt 파일을 ANSI 인코딩으로 생성한 후
 	
 	C:\NCS\workspace(java)\IO\bin>java io.day2.b.BufferedReader_BufferedWriteer_main_6

 	>>>> 파일 복사 완료 !! <<<<
 	
 */

}
