package test.main;

public class MainClass04 {
	// static 메소드 안에서 사용하려면 static 예약어가 필요하다.
	public static class Rubber {
		public void say() {
			System.out.println("안녕 나는 Rubber야");
		}
	}
	
	public static void main(String[] args) {
		Rubber r= new Rubber();
		r.say();

		// 메소드 안에도 클래스를 정의할수 있다.
		// 메소드 안에 정의한 클래스를 지역 내부 클래스 라고 한다. (Local Inner Class)
		// 메소드 내부에서만 사용할수 있다.
		class Cat {
			public void say() {
				System.out.println("야옹");
			}
		}
		Cat c = new Cat();
		c.say();
	}
}
