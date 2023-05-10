package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lottonum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		ArrayList<Integer> num = new ArrayList();

		System.out.print("로또를 몇개 구입하시겠어요 : ");
		int num1 = scan.nextInt();
		// 로또를 n회 출력을 하는 반복문
		for (int n=0; n<num1; n++) {
		// 랜덤 번호 6개를 중복없이 출력하는 for문
		for (int i=0; i<6; i++) {
			// 로또번호를 1~45 사이의 값을 받고 lotto 변수에 대입
			int lotto = (int)(Math.random()*45)+1;
			// lotto 변수의 값을 num ArrayList 배열에 대입
			num.add(lotto);
			// 로또번호가 중복인경우 중복값을 제거하기위한 for문
			for (int j=0; j<i; j++) {
				if (num.get(i)==num.get(j)) {
					num.remove(i);
					i--;
				}
			}
		}
		// 받아온 번호를 오름차순으로 정렬
		Collections.sort(num);
		// 로또 번호를 Console에 출력
		System.out.println(num);
		// ArrayList 배열에 있는 값을 초기화 시켜 값을 처음부터 다시 받아올 수 있다.
		num.clear();
		}
	}
}
