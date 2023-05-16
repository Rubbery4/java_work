package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		// 수정할 회원의 정보
		int num = 1;
		String name = "김구라";
		String addr = "독산동";
		MemberDao dao = new MemberDao();
		
		// 위의 정보를 이용해서 1 번 회원의 정보를 수정하고 성공이면 "수정했습니다" 가 출력되도록 해 보세요.
		
//		MemberDto dto = new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr);
//		dto.setNum(num);
		// 생성자의 인자로 회원 정보를 전달해서 객체를 생성 할수도 있다.
		MemberDto dto = new MemberDto(num, name, addr);
		
		boolean daoResult = dao.update(dto);
		if (daoResult) {
			System.out.println("수정했습니다.");
		}
	}
}
