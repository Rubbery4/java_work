package deptTest.main;

import java.util.List;

import dept.dao.DeptDao;
import dept.dto.DeptDto;

public class selectList {
	public static void main(String[] args) {
		List<DeptDto> list = new DeptDao().getList();
		
		for (DeptDto tmp:list) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
	}
}
