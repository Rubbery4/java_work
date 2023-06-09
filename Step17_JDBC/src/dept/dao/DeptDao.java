package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dept.dto.DeptDto;
import test.dto.MemberDto;
import test.util.DBConnect;

public class DeptDao {
	
	public boolean insert(DeptDto dto) {
		// 필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "INSERT INTO dept"
	    			  + "(deptno, dname, loc)"
	    			  + " VALUES(dept_seq.nextval, ?, ?)";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// sql 문이 미완성의 ? 가 존재하는 미완성이라면 여기서 완성한다.
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
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
			System.out.println("추가완료");
			return true;
		} else { // 그렇지 않으면 작업 실패
			return false;
		}
	}
	
	public boolean update (DeptDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		
	    PreparedStatement pstmt1 = null;
	    try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
	    	String sql = "Update dept"
	    			+ " set dname=?, loc=?"
	    			+ " where deptno=?";
	    	pstmt1 = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt1.setString(1, dto.getDname());
	    	pstmt1.setString(2, dto.getLoc());
	    	pstmt1.setInt(3, dto.getDeptno());
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
	
	public boolean delete (int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		
	    PreparedStatement pstmt1 = null;
	    try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
	    	String sql = "delete from dept"
	    			+ " where deptno=?";
	    	pstmt = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt.setInt(1, num);
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
	
	public List<DeptDto> getList() {
		//회원 정보를 누적할 객체 생성
	      List<DeptDto> list=new ArrayList<>();
	      
	      //필요한 객체를 담을 지역 변수를 미리 만들기
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      try {
	         //Connection 객체의 참조값 얻어오기
	         conn = new DBConnect().getConn();
	         //실행할 sql 문(select 문)
	         String sql="select deptno, dname, loc"
	        		 + " from dept"
	        		 + " order by deptno desc";
	         pstmt=conn.prepareStatement(sql);
	         //select 문이 미완성이라면 여기서 완성한다.
	         
	         //select 문 수행하고 결과를 ResultSet 으로 리턴받기
	         rs=pstmt.executeQuery();
	         //반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
	         while(rs.next()) {
	            //현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
	            
	        	 // row 에 있는 회원정보를 MemberDto 객체에 담아서
	        	 DeptDto dto = new DeptDto();
	        	 dto.setDeptno(rs.getInt("deptno"));
	        	 dto.setDname(rs.getString("dname"));
	        	 dto.setLoc(rs.getString("loc"));
	        	 // List에 누적시킨다
	        	 list.add(dto);
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs!=null)rs.close();
	            if(pstmt!=null)pstmt.close();
	            if(conn!=null)conn.close();
	         }catch(Exception e) {}
	      }
	      //회원 정보가 누적된 List 객체의 참조값을 리턴한다.
	      return list;
	   }
	public DeptDto getData(int num) {
    	// MemberDto 객체의 참조값을 담을 지역변수 미리 만들기
		DeptDto dto = null;
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문(select 문)
			String sql = "select deptno, dname, loc"
	        		 + " from dept"
	        		 + " where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.
			pstmt.setInt(1, num);
			//select 문 수행하고 결과를 ResultSet 으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
	        	String dname = rs.getString("dname");
	        	String loc = rs.getString("loc");
	        	dto = new DeptDto();
	        	dto.setDeptno(num);
	        	dto.setDname(dname);
	        	dto.setLoc(loc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return dto;
	}
}
