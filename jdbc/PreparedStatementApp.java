package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PreparedStatement 객체 : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하여 실행하기 위한 기능을
//장점 : InParameter를 사용하여 값을 전달받아 SQL 명령 작성
// => InParameter를 사용하므로 가독성 및 유지보수의 효율성 증가
// => InSQL 해킹 기술 무효화 - 사용자 입력값은 SQL 명령에서 무조건 문자값으로  처리
//단점 : 하나의 PreparedStatement 객체는 저장된 하나의 SQL 명령만 전달하여 실행 가능
public class PreparedStatementApp {
	public static void main(String[] args) throws Exception {
		/*
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 입력>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.print("전화번호 입력 >> ");
		String phone=in.readLine();
		System.out.print("주소 입력 >> ");
		String address=in.readLine();
		System.out.print("생년월일 입력 >> ");
		String birthday=in.readLine();
		System.out.println("=============================================================");
		
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : Connection 객체로부터 SQL 명령이 저장된
		//PreparedStatement 객체를 반환하는 메소드
		// => PreparedStatement 객체에 저장된 SQL 명령에서는 ?(InParameter) 기호 사용
		//InParameter : Java 변수값을 제공받아 SQL 명령의 문자값으로 표현하기 위한 기능
		// => 반드시 모든 InParameter에 Java 변수값을 전달받아야 완전한 SQL 명령 완성
		//PreparedStatement.setXXX(int parameterIndex, XXX value)
		// => PreparedStatement 객체에 저장된 SQL 명령의 InParameter에 Java 변수값을 전달하는 
		// => XXX는 Java 자료형, parameterIndex : InParameter의 위치값(첨자) - 1부터 1씩 증가되는
		// => 반드시 setXXX() 메소드를 호출하여 모든 InParameter에 Java 변수값을 전달
		String sql1="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : DML 명령 또는 DDL 명령을 전달하여 실행하는 메소드
		// => 조작행의 갯수를 정수값으로 반환
		int rows=pstmt.executeUpdate();
		
		System.out.println("[결과]"+rows+"명의 학셍정보를 삽입하였습니다.");
		System.out.println("=============================================================");
		
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		//PreparedStatement.executeQuery() : SELECT 명령을 전달하여 실행하는 메소드
		// => 모든 검색행이 저장된 ResultSet 객체 반환
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<학생정보 출력>>");
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		ConnectionFactory.close(con,pstmt,rs);
		System.out.println("=============================================================");
		*/

		//키보드로 이름을 입력받아 STUDENT 테이블 저장된 학생정보 중 해당 이름의 학생정보를 
		//검색하여 출력하는 JDBC 프로그램 작성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 검색>>");
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.println("=============================================================");
		//STUDENT 테이블에 저장된 학생정보 중 해당 이름의 학생정보를 검색하여 출력	
		Connection con=ConnectionFactory.getConnection();
		
		
		String sql="select * from student where name=? order by no";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<검색결과>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
			} while (rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		
		ConnectionFactory.close(con,pstmt,rs);
		System.out.println("=============================================================");
		
	}
}
