package my.day07.c.quiz;

public class QuizMain2 {

	public static void main(String[] args) {

		/*
		 * == 입사문제 == 1 2 3 4 5 6 7 8 9
		 * 
		 * 위와 같이 나오도록 하세요.
		 * 
		 * 1. for문을 사용해서 출력 2. while 문을 사용해서 출력 3. do~while문을 사용해서 출력
		 * 
		 * 1. 메일제목 : 과제2_입사문제_이름 2. 첨부파일 : 과제2_입사문제_이름.zip 파일로 제출 3. 제출기한 : 2021. 12.
		 * 16. 18:00 까지 제출 4. 보내는 메일주소 : tjdudgkr0959@naver.com
		 * 
		 */

		System.out.println("1. for문을 사용해서 출력\n");

		String fm = "";

		int sum = 0;
		int num = 0;
		for (int i = 9; i > 0; i--) {

			for (int y = 0; y < i; y++) {

				System.out.print("*");

			}
			System.out.println(10 - i);
		}

		System.out.println("\n================================\n");
		System.out.println("2. while문을 사용해서 출력\n");
		int j = 9;
		int z = 0;
		while (j > 0) {
			z = 0;

			while (z < j) {
				System.out.print("*");
				z++;
			}
			System.out.println(-1 * (j - 10));
			j--;
		}

		System.out.println("\n================================\n");

		System.out.println("3. do~while문을 사용해서 출력\n");

		int q = 1;

		do {
			String star = "";
			int s = 10 - q;

			do {
				star += "*";

			} while (!(--s == 0));
			System.out.println(star+q);
		} while (!(++q > 10));

	} // main(String[] args)

}// public class QuizMain2
