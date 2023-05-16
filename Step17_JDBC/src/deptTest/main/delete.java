package deptTest.main;

import dept.dao.DeptDao;

public class delete {
	public static void main(String[] args) {
		int num = 2;
		
		boolean Deptdelete = new DeptDao().delete(num);
		
		if (Deptdelete) {
			System.out.println(num+"번째 행을 삭제 완료했습니다");
		} else {
			System.out.println(num+"번째 행을 찾지 못하였습니다.");
		}
		
	}
}
