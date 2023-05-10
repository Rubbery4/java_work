package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;

public class MainClass06 {
	public static void main(String[] args) {
		// 자식에게 사준 일반 핸드폰(인터넷이 안됨)
		HandPhone p1 = new HandPhone();
		
		// 엄마 나도 AndroidPhone 갖고싶어 
		
		// 폰의 새로운 설명서를 갖고옴 > AndroidPhone 이다?
		AndroidPhone p2 = (AndroidPhone) p1; // ClassCastException 발생
		
		// 인터넷 가능
		p2.DoInternet();
	}
}
