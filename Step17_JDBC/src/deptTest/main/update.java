package deptTest.main;

import dept.dao.DeptDao;
import dept.dto.DeptDto;

public class update {
	public static void main(String[] args) {
		int deptno = 1;
		String dname = "김김김";
		String loc = "부산";
		
		DeptDto dto = new DeptDto();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		new DeptDao().update(dto);
		
	}
}
