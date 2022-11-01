package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에 저장된 모든 사원정보의 검색하여 사원번호,사원이름,급여를 급여로 내림차순 정렬되도록 
//검색하여 출력하는 JDBC 프로그램 
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url,username,password);
			
			stmt=con.createStatement();
			
			String sql="select * from EMP order by SAL DESC";
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					int EMPNO=rs.getInt("EMPNO");
					String ENAME=rs.getString("ENAME");
					String JOB=rs.getString("JOB");
					int MGR=rs.getInt("MGR");
					Date HIREDATE =rs.getDate("HIREDATE");
					int SAL=rs.getInt("SAL");
					int DEPTNO=rs.getInt("DEPTNO");
											
					System.out.println("사원번호 = "+EMPNO);
					System.out.println("사원이름 = "+ENAME);
					System.out.println("업무 = "+JOB);
					System.out.println("관리자번호 = "+MGR);
					System.out.println("고용일 = "+HIREDATE);
					System.out.println("급여 = "+SAL);
					System.out.println("부서번호 = "+DEPTNO);
					System.out.println("======================================================");	
				} while (rs.next());
				
			} else { 
				System.out.println("[메세지]검색된 사원정보가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("JDBC 관련 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
		
		
	}
}
	
