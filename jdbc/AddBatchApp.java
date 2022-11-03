package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

//JDBC 프로그램에서 하나의 PreparedStatement 객체를 사용하여 다수의 행을 삽입,변경,삭제 
//처리를 하기 위해 일괄처리(Batch)영역에 SQL 명령을 저장하여 한번에 전달하여 실행 기능 제공
public class AddBatchApp {
	public static void main(String[] args) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		
		String sql="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, 4000);
		pstmt.setString(2, "일지매");
		pstmt.setString(3, "010-2317-9741");
		pstmt.setString(4, "서울시 종로구");
		pstmt.setString(5, "1999-08-15");
		//PreparedStatement.addBatch() : PreparedStatement 객체에 이용하여 SQL 명령을 이용하여
		//Batch 영역에 추가하는 메소드
		pstmt.addBatch();
		
		pstmt.setInt(1, 5000);
		pstmt.setString(2, "장길산");
		pstmt.setString(3, "010-4879-6765");
		pstmt.setString(4, "서울시 도봉구");
		pstmt.setString(5, "1997-05-05");
		pstmt.addBatch();
		
		//PreparedStatement.executeBatch() : Batch 영역에 저장된 SQL 명령을 전달하여 실행하는
		// => 조작행의 갯수를 int 배열로 반환
		int[] result=pstmt.executeBatch();
		
		System.out.println("[메세지]"+result.length+"SQL 명령에 대한 일괄처리를 실행하였습니다.");
		
		ConnectionFactory.close(con,pstmt);
	}
}
