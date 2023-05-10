package test.main;

import java.util.Random;
import java.util.Scanner;

public class RockPaper {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int ranNum = ran.nextInt(3);
		System.out.println("(가위:0), (바위:1), (보:2)");
		System.out.println("입력하세요:");
		int input1 = scan.nextInt();
		
		if (input1==0) {
			if (ranNum==0) {
				System.out.println("나:가위 Com:가위");
				System.out.println("비겼습니다.");
			} else if (ranNum==1) {
				System.out.println("나:가위 Com:바위");
				System.out.println("졌습니다.");
			} else if (ranNum==2) {
				System.out.println("나:가위 Com:보");
				System.out.println("이겼습니다.");
			}
		}
		if (input1==1) {
			if (ranNum==0) {
				System.out.println("나:바위 Com:가위");
				System.out.println("이겼습니다.");
			} else if (ranNum==1) {
				System.out.println("나:바위 Com:바위");
				System.out.println("비겼습니다.");
			} else if (ranNum==2) {
				System.out.println("나:바위 Com:보");
				System.out.println("졌습니다.");
			}
		}
		if (input1==2) {
			if (ranNum==0) {
				System.out.println("나:보 Com:가위");
				System.out.println("졌습니다.");
			} else if (ranNum==1) {
				System.out.println("나:보 Com:바위");
				System.out.println("이겼습니다.");
			} else if (ranNum==2) {
				System.out.println("나:보 Com:보");
				System.out.println("비겼습니다.");
			}
		}
	}
}
