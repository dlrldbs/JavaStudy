package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase Connection Pool) : 다수의 Connection 객체를 미리 생성하여 저장하고 
//Connection 객체를 반환하는 기능을 제공하는 클래스
// => Connection 객체를 미리 생성하여 사용하므로 JDBC 프로그램의 실행 속도 증가
// => Connection 객체를 생성하기 위한 정보의 변경 용이 - 유지보수의 효율성 증가
// => Connection 객체의 갯수 제한 가능
public class ConnectionPoolApp {
	public static void main(String[] args) throws SQLException {
		//ConnectionPool 클래스의 생성자가 은닉화 선언되어 new 연산자로 생성자를 호출하여 객체 생성 불가능
		//ConnectionPool cp=new ConnectionPool();
		
		//ConnectionPool.getInstance() 메소드를 호출하여 ConnectionPool 객체를 반환받아 저장
		// => ConnectionPool 객체에는 다수의 Connection 객체가 미리 생성되어 저장
		// => 프로그램에서 ConnectionPool 객체가 하나만 제공되도록 싱글톤(Singleton) 클래스 작성
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//ConnectionPool 객체에 저장된 Connection 객체 중 하나를 반환받아 저장
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		//사용한 Connection 객체를 ConnectionPool 객체에게 다시 반납 처리
		//cp.freeConnection(con1);

		Connection con2=cp.getConnection();
		System.out.println("con2 = "+con2);
		//cp.freeConnection(con2);

		Connection con3=cp.getConnection();
		System.out.println("con3 = "+con3);
		//cp.freeConnection(con3);
		
		Connection con4=cp.getConnection();
		System.out.println("con4 = "+con4);
		cp.freeConnection(con4);
	}
}
