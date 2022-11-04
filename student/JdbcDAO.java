package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//모든 DAO 클래스에서 공통적으로 사용하는 기능을 메소드로 제공하는 클래스
// => 모든 DAO 클래스가 상속받아 사용하는 부모클래스
// => DBCP 관련 객체를 생성하여 Connection 객체를 반환하거나 JDBC 관련 객체를 전달받아 제거하는 메소드
// => 객체 생성이 목적이 아닌 상속만을 목적으로 작성된 클래스이므로 추상클래스로 선언하는 것을 권장
public abstract class JdbcDAO {
	private static PoolDataSource pds;
	
	//PoolDataSource 객체를 생성하여 필드에 저장 - 프로그램에서 한번만 실행
	// => PoolDataSource 객체에 Connection 
	static {
		pds=PoolDataSourceFactory.getPoolDataSource();
		try {
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			pds.setUser("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(10);
			pds.setMaxPoolSize(15);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PoolDataSource 객체(DBCP)에 저장된 Connection 객체 중 하나를 얻어와 반환하는 메소드
	public Connection getConnection() {
		Connection con=null;
		try {
			con=pds.getConnection();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return con;		
	}
	
	//JDBC 관련 객체를 매개변수로 전달받아 제거하는 메소드
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	
	
}