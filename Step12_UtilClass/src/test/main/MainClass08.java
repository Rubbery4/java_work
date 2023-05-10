package test.main;

import java.util.HashSet;
import java.util.Set;

public class MainClass08 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		
		// 문자열을 저장할수 있는 HashSet 객체
		Set<String> set2 = new HashSet<>();
		set2.add("kim");
		set2.add("lee");
		set2.add("park");
		set2.add("lee");
		set2.add("park");
	}
}
