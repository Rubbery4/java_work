package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		// 1. 문자열을 저장할수 있는 방 5개짜리 배열객체를 생성해서 참조값을 msgs 라는 지역변수에 담는다.
		String[] msgs = new String[5];
		// 2. 키보드로 부터 입력 받을 수 있는 Scanner 객체를 생성해서 참조값을 scan 이라는 지역변수에 담는다.
		Scanner scan = new Scanner(System.in);
		// 3. 반복문을 이용해서 생성한 배열의 방의 갯수 만큼 돌면서 키보드로 부터 문자열을 입력받아서
		//    배열에 순서대로 저장한다.
		for (int i = 0; i<msgs.length; i++) {
			System.out.print("입력하세요 :");
			msgs[i] = scan.nextLine();
		}
		// 4. 반복문 돌면서 배열에 저장되었던 모든 문자열을 순서대로 콘솔창에 출력
		for (String tmp:msgs) {
			System.out.println(tmp);
		}
	}
}
