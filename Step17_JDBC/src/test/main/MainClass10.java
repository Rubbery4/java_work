package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	public static void main(String[] args) {
		// 수정할 회원의 정보
		int num = 1;
		String name = "호빵";
		String addr = "독산동";
		
		MemberDto dto = new MemberDto();
		
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		MainClass10.update(dto);
		
	}
	
	public static void update(MemberDto m) {
		Connection conn = null;
	    //sql 문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
	    PreparedStatement pstmt = null;
	    try {
	    	// Connection 객체의 참조값 얻어오기
	    	conn = new DBConnect().getConn();
	    	String sql = "Update member"
	    			+ " set name=?, addr=?"
	    			+ " where num=?";
	    	pstmt = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt.setString(1, m.getName());
	    	pstmt.setString(2, m.getAddr());
	    	pstmt.setInt(3, m.getNum());
	    	// sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("수정 작업을 완료 했습니다.");
	    } catch(Exception e) {
	    	  e.printStackTrace();
	    	  
	      }
	}
}
