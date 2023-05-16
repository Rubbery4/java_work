package test.main;

import test.dao.MemberDao;

public class MainClass15 {
	public static void main(String[] args) {
		// 삭제할 회원의 정보
		int num = 4;
		
//		위의 정보를 이용해서 회원정보를 삭제하고 성공이면 "삭제 했습니다" 가 출력 되도록 해 보세요
		MemberDao dao = new MemberDao();
		boolean daoDelete = dao.delete(num);
		if (daoDelete) {
			System.out.println("삭제 했습니다.");
		}

	}
}
