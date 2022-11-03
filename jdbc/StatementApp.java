package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//Statement 객체 : 현재 접속중인 MDMBS 서버에 SQL 명령을 전달하여 실행하기 위한 기느을 제공하는 객체 
//장점 : 하나의 Statement 객체를 이용하여 다수의 SQL 명령을 전달하여 실행 가능
//단점 : SQL 명령의 Java 변수값을 포함할 경우 문자열 결합 기능 사용
// => 문자열 결합을 이용할 경우 가독성 및 유지보수의 효율성 감소
// => InSQL 해킹 기술(값 대신 부분적인 SQL 명령을 포함시키는 해킹 기술)에 취약
public class StatementApp {
	public static void main(String[] args) throws Exception {
		/*
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 STUDENT 테이블에 저장된 모든
		//학생정보를 검색하여 출력하는 JDBC 프로그램 작성
			
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
		
		Statement stmt=con.createStatement();
		
		String sql1="insert into student values("+no+",'"+name+"','"+phone+"','"+address+"','"+birthday+"')";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[결과]"+rows+"명의 학셍정보를 삽입하였습니다.");
		System.out.println("=============================================================");
		String sql2="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		ConnectionFactory.close(con,stmt,rs);
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
		
		Statement stmt=con.createStatement();
		
		String sql="select * from student where name='"+name+"' order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		System.out.println("<<검색결과>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
			} while (rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		
		ConnectionFactory.close(con,stmt,rs);
		System.out.println("=============================================================");
	}
}
