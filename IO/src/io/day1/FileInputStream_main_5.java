package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileInputStream_main_5 {

/*
    ※ Data Source (File, 키보드, 원격 컴퓨터)
   : 데이터의 근원
    
    ※ Data Destination (파일, 모니터, 프린터, 메모리)
   : 데이터가 최종적으로 도착하는 곳

  Data Sourceㅇ======>ㅇ 프로그램 ㅇ======>ㅇ Data Destination
              입력스트림           출력스트림
              InputStream       OutputStream          
   
      
      === c:\iotestdata\korea.txt 파일을 읽어서 그 내용을 모니터(콘솔화면)에 출력하는 예제 ===
                  
      1. 데이터소스 : 파일로 부터 읽어들임     (노드스트림: FileInputStream) 
      2. 데이터목적지 : 결과물을 모니터에 출력  (노드스트림: System.out)
      
      >>>> FileInputStream
         - Node 스트림(접속점이 파일인 입력스트림)
         - 1byte 기반 스트림.
        
      >>>>> System.out :
                    부모클래스가 추상클래스 OutputStream(기본 출력 스트림) 타입인 것으로서
                    접속점(빨대)이 콘솔화면(모니터)인 출력 스트림(PrintStream)이다.
                    
       -- Node(접속점)가 콘솔화면(모니터)인 출력스트림이다.
       -- 1byte 기반 스트림이다.
       -- 주요 메소드 : println(String str),
                     print(String str),
                     write(int b)      
               
*/   	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print(" >> 읽을 파일 이름(절대경로)을 입력하세요 => ");
		
		String fileName = sc.nextLine();
		// C:\iotestdata\korea.txt
		// 입력해준 파일명이 데이터소스가 된다. 
		
		FileInputStream fist = null;
		
		try {
			fist = new FileInputStream(fileName);
			
			int input = 0;
			int totalByte = 0; // byte수 누적 용도
			int cnt = 0;	// while 문의 반복횟수
			
			
			while((input = fist.read()) != -1 ) {
			/*
              	fist.read() 메소드는 해당 파일에서 
                데이터를 1byte 씩 읽어서 int 타입으로 리턴해준다.
                만약에 파일의 내용물에서 읽어들일 데이터가 없다라면  -1 을 리턴시켜준다.
                즉, 파일속의 내용물이 끝이 아니라면 계속해서 while{} 부분을 실행해라는 말이다.
             */
				System.out.write(input); // 모니터(콘솔화면)에 출력 	
				System.out.flush();
				
				totalByte++;
				cnt ++;
			}//end of while

			System.out.println("\n===========================");	
			System.out.println("총 "+totalByte+" byte");
			System.out.println("반복횟수 "+cnt+"번 반복");
			System.out.println("===========================");
	
			/*
			  	===========================
				총 57 byte
				반복횟수 57번 반복
				===========================
			 */
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "파일은 없습니다.");
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fist != null)
					fist.close();
			} catch (IOException e) {}
		}
		
		
		sc.close();
		
	}// end of main(String[] args)

}
