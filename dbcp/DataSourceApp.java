package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//javax.sql.DataSource : DBCP 클래스를 상속받기 위한 인터페이스
// => DBCP 클래스의 메소드가 동일한 형식으로 작성되도록 규칙 제공

//UCP(Universal Connection Pool) 라이브러리에서 제공하는 DBCP 기능의 클래스를 이용한 JDBC 프로그램 작성
// => www.oracle.com 오라클 사이트에서 UCP 라이브러리 파일을 다운로드 받아 프로젝트에 빌드 처리
public class DataSourceApp {
	public static void main(String[] args) throws SQLException  {
		//PoolDataSource 객체 : DBCP 기능을 제공하는 객체
		//PoolDataSourceFactory.getPoolDataSource() : PoolDataSource 객체를 반환하는 메소드
		// => Factory 클래스 : 객체를 안정적으로 생성한여 반환하는 기능을 제공하는 클래스
		PoolDataSource pds=PoolDataSourceFactory.getPoolDataSource();
		
		//PoolDataSource.setConnectionFactoryClassName(String driver)
		// => JDBC Driver 클래스를 변경하는 메소드
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		
		//PoolDataSource.setURL(String url) : 접속 DBMS 서버의 URL 주소를 변경하는 메소드
		pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		
		//PoolDataSource.setUser(String user) : DBMS 사용자명을 변경하는 메소드
		pds.setUser("scott");
		
		//PoolDataSource.setPassword(String password) : DBMS 사용자명의 비밀번호를 변경하는 메소드
		pds.setPassword("tiger");
		
		//PoolDataSource 객체에 저장된 Connection 객체의 갯수를 제한하기 위한 메소드 호출
		// => 메소드를 호출하지 않을 경우 PoolDataSource 객체에 저장된 기본값을 사용하여 Connection 갯수 제한
		//PoolDataSource.setInitialPoolSize(int size) : 최초 생성되는 Connection 갯수 변경하는 메소드
		pds.setInitialPoolSize(2);
		//PoolDataSource.setMaxPoolSize(int size) : 최대로 생성되는 Connection 갯수 변경하는 메소드
		pds.setMaxPoolSize(3);
		
		//PoolDataSource.getConnection : PoolDataSource 객체에 저장된 Connection 객체 중 하나를 반환하는 메소드
		Connection con1=pds.getConnection();
		System.out.println("con1 = "+con1);
		System.out.println("사용 가능한 Connection 객체의 갯수 = "+pds.getAvailableConnectionsCount());
		//Connection.close() : 사용한 Connection 객체를 제거하여 PoolDataSource 객체로 반환하는 메소드
		con1.close();
		
		Connection con2=pds.getConnection();
		System.out.println("con2 = "+con2);
		System.out.println("사용 가능한 Connection 객체의 갯수 = "+pds.getAvailableConnectionsCount());
		con2.close();
	}
}
