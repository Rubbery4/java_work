package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass18 {
	public static void main(String[] args) {

	      Connection conn=null;
	      
	      try {

	         Class.forName("oracle.jdbc.driver.OracleDriver");

	         String url="jdbc:oracle:thin:@localhost:1521:xe";

	         conn=DriverManager.getConnection(url, "scott", "tiger");

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {

	    	  String sql = "SELECT empno, ename, job, deptno"
	    			  + " FROM emp"
	    			  + " ORDER BY empno asc";

	    	  pstmt = conn.prepareStatement(sql);

	    	  rs=pstmt.executeQuery();
	    	  while(rs.next()) {
	    		  int empno = rs.getInt("empno");
	    		  String ename = rs.getString("ename");
	    		  String deptno = rs.getString("deptno");
	    		  String job = rs.getString("job");
	
	    		  System.out.println(empno+" | "+ename+" | "+deptno+" | "+job);
	    	  }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}
}
