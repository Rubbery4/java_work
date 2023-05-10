package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class QuizMain3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("로또를 몇개 구입할까요 : ");
		// 숫자를 입력 받고
		int num1 = scan.nextInt();
		// 입력 받은 숫자만큼 로또 번호를 출력한다.
		for (int i = 0; i<num1; i++) {
			printLotto();
			System.out.println(); // 개행
		}
	}
	// 로또 번호 한 셋트를 출력하는 메소드
	public static void printLotto() {
		// 로또번호 6개를 출력하는 프로그래밍
		Random ran = new Random();
		// 로또번호를 저장할 HashSet 객체 생성해서 참조값을 Set 인터페이스에 type 변수에 담기
		Set<Integer> lottoSet = new HashSet<>();
		// 반복문 돌면서 로또번호 담다가
		while(true) {
			int ranNum = ran.nextInt(45)+1;
			// Set 에 담기
			lottoSet.add(ranNum);
			// 만일 6개의 숫자를 모두 얻어 냈다면
			if (lottoSet.size()==6) {
				break; // 반복문 탈출
			}
		}
		List<Integer> lotto = new ArrayList(lottoSet);
		// Collections 클래스의 static 메소드를 이용해서 숫자를 오름 차순으로 정렬하기
		Collections.sort(lotto);
		// Collections.sort(lotto, Collections.reverseOrder()); 내림차순 정렬
			for (int i=0; i<lotto.size(); i++) {
				int num=lotto.get(i);
				System.out.print(num);
				if(i!=lotto.size()-1) {
					System.out.print(", ");	
				} 
			}
	}
}
