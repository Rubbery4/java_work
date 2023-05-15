package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		int num = 3; // 삭제할 회원의 번호라고 가정
		
		// 아래의 delete() 메소드를 이용해서 회원 정보를 삭제해 보세요.
		delete(num);
		
	}
	
	public static void delete(int num) {
		// 인자로 전달된 num 에 해당하는 회원정보를 삭제하는 기능을 완성해 보세요.
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = new DBConnect().getConn();
	    try {
	    	String sql = "delete from member"
	    			+ " where num=?";
	    	pstmt = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt.setInt(1, num);
	    	// sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("삭제 작업을 완료 했습니다.");
	    } catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}
}
