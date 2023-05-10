package test.mypac;

public class MyRemocon2 implements Remocon {

	@Override
	public void up() {
		System.out.println("업");
	}

	@Override
	public void down() {
		System.out.println("다운");
	}

	// 내가 사용할 편리한 메소드 하나더 생성
	
	public void reserve() {
		System.out.println("전원 off를 예약 합니다.");
	}
	
}
