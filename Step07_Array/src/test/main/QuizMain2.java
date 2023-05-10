package test.main;

import java.util.Random;

public class QuizMain2 {
	public static void main(String[] args) {
		/*
		 * 2. run 했을때
		 * 		5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
		 * 		예) cherry | apple | cherry
		 * 			7 | apple | melon
		 * 			7 | 7 | 7
		 */
		String[] items = {"cherry", "apple", "banana", "melon", "7"};
		Random ran = new Random();
		int ranNum = ran.nextInt(5);
		int ranNum2 = ran.nextInt(5);
		int ranNum3 = ran.nextInt(5);
		// 1 번째 방법
		System.out.println(items[ranNum]+" | "+items[ranNum2]+" | "+items[ranNum3]);
		// 2 번째 방법
		for (int i = 0; i<3; i++) {
			int ranNum4 = ran.nextInt(5);
			System.out.print(items[ranNum4]);
			if (i<2) {
				System.out.print(" | ");	
			}
		}
	}
}
