package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 프로그램은 기본적으로 AutoCommit 기능이 활성 처리되어 있어 SQL 명령(DML)을 전달되어 
//실행되면 자동으로 커밋 처리
// => 프로그램 실행시 예외가 발생한 경우 예외 발생전에 전달되어 실행된 SQL 명령에 대한 롤백 처리 불가
//JDBC 프로그램에서 AutoCommit 기능을 비활설화 처리하여 예외 발생없이 프로그램이 정상적으로 
//실행된 경우 커밋하고 예외가 발생된 경우 롤백 처리하는 것을 권장 

//STUDENT 테이블에 저장된 학생 정보 중 학번이 [2000]인 학생의 이름을 [임꺽정]으로 변경하는 JDBC 프로그램 작성
public class TransactionControlApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url,username,password);
			
			//Connection.setAutoCommit(boolean autoCommit) : AutoCommit 기능의 사용여부를 변경
			// => false : AutoCommit 기능 비활성화, true : AutoCommit 기능 비활성화(기본)
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			String sql="update student set name='임꺽정' where no=2000";
			int rows=stmt.executeUpdate(sql);
			
			//if(con!=null) throw new Exception();
			
			if(rows>0) {
				System.out.println("[메세지]"+rows+"명의 학생정보를 변경하였습니다.");
			} else {
				System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
			}
			
			//Connection.commit() : Connection 객체에 의해 전달된 모든 SQL 명령에 대한 커밋 
			con.commit();
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDirver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} catch (Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생하였습니다.");
			try {
				//Connectio.rollback() : Connection 객체에 의해 전달된 모든 SQL 명령에 대한 롤백
				con.rollback();
			} catch (SQLException e1) {
				
			}
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
