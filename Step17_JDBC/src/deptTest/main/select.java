package deptTest.main;

import java.util.Scanner;

import dept.dao.DeptDao;
import dept.dto.DeptDto;

public class select {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 번호를 입력하세요 : ");
		int deptno = scan.nextInt();
		
		DeptDto dto = new DeptDao().getData(deptno);
		
		if(dto!=null) {
			System.out.println(deptno+"번호의 이름: "+dto.getDname()+" Loc: "+dto.getLoc());
		} else {
			System.out.println(deptno+"번호의 없습니다.");
		}
	}
}
