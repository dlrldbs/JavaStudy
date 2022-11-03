package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : Statement 객체를 생성하여 반환하는 메소드
		//Statement 객체 : SQL 명령을 현재 접속중인 DBMS 서버에 전달하여 실행하는 기능을 제공하는 객체
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하고 검색결과를
		//ResultSet 객체로 반환하는 메소드
		// => ResultSet 객체는 내부적으로 커서(Cursor)를 사용하여 행단위로 처리
		// => ResultSet 커서는 다음행으로만 이동 가능하며 커서 위치의 행에 대한 조작 불가능
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드
		// => 이동된 커서 위치에 처리행이 없는 경우 [false]를 반환하고 처리행이 있는 경우 [true]를 반환
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet 커서가 위치한 처리행의 행번호(RowIndex)를 반환하는 메소드
			//ResultSet.getXXX(string columnLabel) : ResultSet 커서가 위치한 처리행의 컬럼값을 반환하는 메소드
			System.out.println(rs.getRow()+"행 : 학번 = "
					+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}

		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
		con=ConnectionFactory.getConnection();
		
		//Connection.createStatement(int resultSetType, int resultSetConcurrency) 
		// => Statement 객체를 생성하여 반환하는 메소드
		// => 매개변수에 전달되는 값에 따라 Statement 객체로 생성되는 ResultSet 객체의 사용방법을 다르게 설정
		// => ResultSet 커서의 이동 또는 ResultSet 커서가 위치한 처리행의 대한 조작 설정 가능
		//resultSetType : ResultSet 커서의 이동 관련 속성값(ResultSet 인터페이스의 상수)을 전달하여 설정
		// => ResultSet.TYPE_FORWARD_ONLY : ResultSet 커서를 다음행으로만 이동 가능 - 기본
		// => ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet 커서를 원하는 행으로 이동 가능 - 조작행 미반영
		// => ResultSet.TYPE_SCROLL_SENSITIVE : ResultSet 커서를 원하는 행으로 이동 가능 - 조작행 반영
		//resultSetConcurrency : ResultSet 커서 위치의 처리행의 조작 관련 속성값(ResultSet 인터페이스의 상수)을 전달하여 설정
		// => ResultSet.CONCUR_READ_ONLY : ResultSet 커서 위치의 처리행에 대한 조작 불가능 - 기본 
		// => ResultSet.CONCUR_UPDATABLE : ResultSet 커서 위치의 처리행에 대한 조작 가능
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		sql="select * from student order by no";
		//ResultSet 커서는 ResultSet 객체의 BOF(Before Of File)영역에 위치
		rs=stmt.executeQuery(sql);
		
		//ResultSet.first() : ResultSet 커서를 첫번째 행으로 이동하는 메소드
		rs.first();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));

		//ResultSet.last() : ResultSet 커서를 마지막 행으로 이동하는 메소드
		rs.last();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		
		//ResultSet.absolute(int rowIndex) : ResultSet 커서를 원하는 위치의 행으로 이동하는 메소드
		rs.absolute(2);
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		System.out.println("==============================================================");
		//ResultSet.beforeFirst() : ResultSet 커서를 BOF(Before Of File) 영역으로 이동하는 메소드
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		//ResultSet.afterLast() : ResultSet 커서를 EOF(End Of File) 영역으로 이동하는 메소드
		rs.afterLast();
		//ResultSet.previous() : ResultSet 커서를 이전행으로 이동하는 메소드
		while(rs.previous()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}

		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
		con=ConnectionFactory.getConnection();
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		//ResultSet 커서가 위치한 처리행에 대한 조작이 가능한 경우 SELECT 명령의 검색대상으로 [*] 사용 불가능 사용 (업데이트가 안됨)
		sql="select no,name,phone,address,birthday from student order by no";
		rs=stmt.executeQuery(sql);

		/*
		rs.absolute(2);
		
		//ResultSet.updateXXX(String columnLabel, XXX columnValue)
		// => ResultSet 커서가 위치한 처리행의 컬럼값을 변경하는 메소드
		// => XXX : Java 자료형
		rs.updateString("name", "임걱정");
		
		//ResultSet.updateRow() : 변경행을 ResultSet 객체에 적용하는 메소드  
		// => 실제 테이블의 행에 대한 컬럼값 변경 처리
		rs.updateRow();
		*/
		
		/*
		rs.absolute(3);
		
		//ResultSet.moveToInsertRow() : ResultSet 커서 위치에 새로운 행을 삽입하는 메소드
		// => 삽입행 다음에 존재하는 기존행은 자동으로 다음행으로 이동
		rs.moveToInsertRow();
		
		//삽입행의 컬럼값 변경
		rs.updateInt("no", 4000);
		rs.updateString("name", "일지매");
		rs.updateString("phone", "010-1321-2411");
		rs.updateString("address", "부산시 사하구");
		rs.updateString("birthday", "2000-12-31");
		
		//ResultSet.insertRow() : 삽입행을 ResultSet 객체에 적용하는 메소드  
		// => 실제 테이블의 행에 대한 삽입 처리
		rs.insertRow();
		*/
		
		rs.absolute(4);
		//ResultSet.insertRow() : ResultSet 커서가 위치한 처리행을 삭제하여 ResultSet 객체에 적용하는 메소드  
		// => 실제 테이블의 행에 대한 삭제 처리
		rs.deleteRow();
		
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
	}
}
