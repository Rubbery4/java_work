package test.main;

import test.mypac.Car;

public class MainClass01 {
	// run 했을때 실행의 흐름이 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		
		/*
		 * 만일 달리고 싶다면 어떻게 해야할까?
		 * 
		 */
		// Car 클래스로 객체를 생성하고 생성된 객체의 참조값을 car1 이라는 지역변수에 담기
		Car car1 = new Car();
		// Car 객체의 참조값 안에 있는 drive 메소드를 호출
		car1.drive();
		// Car 객체의 참조값에 .찍어서 필드 참조하기 (참조해서 값 대입하기)
		car1.name = "소나타";
		car1.price = 1000;
		
		Car car2 = new Car();
		car2.drive();
		car2.name = "그랜저";
		car2.price = 2000;
		
		boolean result = car1 == car2; // false
		boolean result2 = car1.name == car2.name; // false
	}
}
