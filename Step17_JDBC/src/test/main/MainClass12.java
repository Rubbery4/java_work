package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		// 추가할 회원의 정보
		String name = "덩어리";
		String addr = "목동";
		int num = 6;
		// 추가할 회원의 정보를 MemberDto 객체에 담는다.
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setNum(num);
		
		// DB에 저장하기, 삭제, 수정
//		new MemberDao().insert(dto);
//		new MemberDao().delete(dto);
//		new MemberDao().update(dto);
		
	}
}
