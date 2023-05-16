package deptTest.main;

import dept.dao.DeptDao;
import dept.dto.DeptDto;

public class insert {
	public static void main(String[] args) {
		String dname = "홍길동";
		String loc = "서울";
		
		DeptDto dto = new DeptDto();
		dto.setDname(dname);
		dto.setLoc(loc);
		
		new DeptDao().insert(dto); 
	}
}
