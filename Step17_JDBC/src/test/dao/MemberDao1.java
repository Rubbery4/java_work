package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto1;
import test.util.DBConnect;

public class MemberDao1 {
	
	// 회원 한명의 정보를 저장하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean insert(MemberDto1 dto) {
		// 필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 sql 문
			String sql = "INSERT INTO member1"
	    			  + "(num, userid, passwd, name, phone)"
	    			  + " VALUES(member1_seq.nextval, ?, ?, ?, ?)";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// sql 문이 미완성의 ? 가 존재하는 미완성이라면 여기서 완성한다.
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
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
	public boolean update (MemberDto1 dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		
	    PreparedStatement pstmt1 = null;
	    try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
	    	String sql = "Update member1"
	    			+ " set passwd=?, phone=?"
	    			+ " where num=?";
	    	pstmt1 = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt1.setString(1, dto.getPasswd());
	    	pstmt1.setString(2, dto.getPhone());
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
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete 작업을 통해 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; // 초기값 0으로 부여
		
	    PreparedStatement pstmt1 = null;
	    try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
	    	String sql = "delete from member1"
	    			+ " where num=?";
	    	pstmt = conn.prepareStatement(sql);
	    	// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기
	    	pstmt.setInt(1, num);
	    	// sql 문 실행하기
	    	rowCount = pstmt.executeUpdate();
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
	// 인자로 전달되는 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public MemberDto1 getData(int num) {
    	// MemberDto 객체의 참조값을 담을 지역변수 미리 만들기
		MemberDto1 dto = null;
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문(select 문)
			String sql = "select num, userid, passwd, name, phone"
	        		 + " from member1"
	        		 + " where num = ?";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.
			pstmt.setInt(1, num);
			//select 문 수행하고 결과를 ResultSet 으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
	        	String userid = rs.getString("userId");
	        	String passwd = rs.getString("passwd");
	        	String name = rs.getString("name");
	        	String phone = rs.getString("phone");
	        	
	        	dto = new MemberDto1();
	        	dto.setUserId(userid);
	        	dto.setPasswd(passwd);
	        	dto.setName(name);
	        	dto.setPhone(phone);
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
			} catch (Exception e) {
			}
		}
		return dto;
	}
	
	   //전체 회원의 정보를 리턴하는 메소드
	   public List<MemberDto1> getList(){
	      //회원 정보를 누적할 객체 생성
	      List<MemberDto1> list=new ArrayList<>();
	      
	      //필요한 객체를 담을 지역 변수를 미리 만들기
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      try {
	         //Connection 객체의 참조값 얻어오기
	         conn = new DBConnect().getConn();
	         //실행할 sql 문(select 문)
	         String sql="select num, userid, passwd, name, phone"
	        		 + " from member1"
	        		 + " order by num asc";
	         pstmt=conn.prepareStatement(sql);
	         //select 문이 미완성이라면 여기서 완성한다.
	         
	         //select 문 수행하고 결과를 ResultSet 으로 리턴받기
	         rs=pstmt.executeQuery();
	         //반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
	         while(rs.next()) {
	            //현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
	            
	        	 // row 에 있는 회원정보를 MemberDto 객체에 담아서
	        	 MemberDto1 dto = new MemberDto1();
	        	 dto.setNum(rs.getInt("num"));
	        	 dto.setUserId(rs.getString("userId"));
	        	 dto.setPasswd(rs.getString("passwd"));
	        	 dto.setName(rs.getString("name"));
	        	 dto.setPhone(rs.getString("phone"));

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
}
