package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Data Access Object 만들어 보기
 *  - DB에 insert, update, delete, select 작업을 대신해 주는 객체를 생성할 클래스 설계하기
 */
public class MemberDao {
	
	// 회원 한명의 정보를 저장하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean insert(MemberDto dto) {
		// 필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "INSERT INTO member"
	    			  + "(num, name, addr)"
	    			  + " VALUES(member_seq.nextval, ?, ?)";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// sql 문이 미완성의 ? 가 존재하는 미완성이라면 여기서 완성한다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			// insert or update or delete 문을 실제 수행한다. 변화된 row 의 갯수가 리턴된다
			rowCount = pstmt.executeUpdate(); // 수행하고 리턴된값을 변수에 담는다.
		} catch(Exception e) {
			e.printStackTrace();
		} finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {}
		}
		// 변화된 row 의 갯수가 0보다 크면 작업 성공
		if (rowCount>0) {
			return true;
		} else { // 그렇지 않으면 작업 실패
			return false;
		}
		
	}
	// 회원 정보를 변경하는 메소드
	public boolean update (MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		
	    PreparedStatement pstmt1 = null;
	    try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
	    	String sql = "Update member"
	    			+ " set name=?, addr=?"
	    			+ " where num=?";
	    	pstmt1 = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt1.setString(1, dto.getName());
	    	pstmt1.setString(2, dto.getAddr());
	    	pstmt1.setInt(3, dto.getNum());
	    	// sql 문 실행하기
	    	rowCount = pstmt1.executeUpdate();
	    	System.out.println("수정 작업을 완료 했습니다.");
	    } catch(Exception e) {
	    	  e.printStackTrace();
	      } finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch(Exception e) {}
			}
		// 변화된 row 의 갯수가 0보다 크면 작업 성공
		if (rowCount>0) {
			return true;
		} else { // 그렇지 않으면 작업 실패
			return false;
		}
	}
	
	public boolean delete(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		
	    PreparedStatement pstmt1 = null;
	    try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
	    	String sql = "delete from member"
	    			+ " where num=?";
	    	pstmt = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt.setInt(1, dto.getNum());
	    	// sql 문 실행하기
	    	rowCount = pstmt.executeUpdate();
	    	System.out.println("삭제 작업을 완료 했습니다.");
	    } catch(Exception e) {
	    	  e.printStackTrace();
	      } finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch(Exception e) {}
			}
		// 변화된 row 의 갯수가 0보다 크면 작업 성공
		if (rowCount>0) {
			return true;
		} else { // 그렇지 않으면 작업 실패
			return false;
		}
	}
}
