package test.main;

import test.mypac.Airplane;
import test.mypac.Test;
// 오버로딩
public class MainClass02 {
	public static void main(String[] args) {
		Test t = new Test();
		
		t.send();
		// 값을 즉석에서 만들어서 전달
		t.send(1);
		t.send("안녕");
		t.send(new Airplane());
		
		// 참조되는 값을 전달 할수도 있다.
		int a = 999;
		t.send(a);
		
		String b = "테스트";
		t.send(b);
		
		Airplane c = new Airplane();
		t.send(c);
		
		
	}
}
