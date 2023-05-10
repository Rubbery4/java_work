package test.main;

import java.util.Random;

public class QuizMain3 {
	public static void main(String[] args) {
		/*
		 * 3. 우연히 3개가 모두 같게 나왔을때는 "당첨됬습니다!" 를 출력하고
		 * 	  하나라도 다르면 "꽝" 을 출력하도록 프로그래밍 해 보세요.  
		 */
		String[] items = {"cherry", "apple", "banana", "melon", "7"};
		Random ran = new Random();
		int[] num = new int[3];
		for (int i = 0; i<3; i++) {
			int ranNum = ran.nextInt(5);
			num[i] = ranNum;
			System.out.print(items[ranNum]);
			if (i<2) {
				System.out.print(" | ");
			}
		} 
			System.out.println();
		if (num[0]==num[1] && num[1]==num[2]) {
			System.out.println("당첨됬습니다.!");
		} else {
			System.out.println("꽝");
		}
	}
}

