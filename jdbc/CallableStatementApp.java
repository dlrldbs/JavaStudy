package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 학생정보 중 해당 학번의 학생정보를 삭제하는
//JDBC 프로그램 작성 - 저장 프로시저를 호출하여 학생정보 삭제 처리
public class CallableStatementApp {
	public static void main(String[] args) throws Exception {
		//키보드로 학번을 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("==============================================================");
		Connection con=ConnectionFactory.getConnection();
		
		/*
		CREATE OR REPLACE PROCEDURE DELETE_STUDENT
			(VNO IN STUDENT.NO%TYPE, VNAME OUT STUDENT.NAME%TYPE) IS
		BEGIN 
		    SELECT NAME INTO VNAME FROM STUDENT WHERE NO=VNO;
		    IF SQL%FOUND THEN
		    	DELETE FROM STUDENT WHERE NO=VNO;
		        COMMIT;
		    END IF;    
		EXCEPTION
		    WHEN OTHERS THEN
		        VNAME := NULL;
		END;
		/ 
		*/
		
		//Connection.prepareCall(String sql) : 저장 프로시저를 호출하는 명령을 전달하여 실행
		//하기 위한 CallableStatement 객체를 반환하는 메소드
		// => 저장 프로시저를 호출하는 명령 : {call 저장프로시저명(?,?,...)}
		// => 저장 프로시저에서 사용한 InParameter에는 반드시 setXXX() 메소드로 값을 전달
		//하거나 registerOutParameter() 메소드를 이용하여 값을 제공받아 사용 
		String sql="{call delete_student(?,?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		//CallableStatement.setXXX(int parameterIndex, XXX value)
		// => 저장 프로시저의 IN 모드의 매개변수에 Java 변수값을 전달하기 위한 메소드
		cstmt.setInt(1, no);
		//CallableStatement.registerOutParameter(int parameterIndex, int sqlType)
		// => 저장 프로시저의 OUT 모드의 매개변수에 저장된 값을 제공받기 위한 메소드
		// => sqlType : SQL 자료형 - Types 클래스의 상수(Constant) 사용 
		cstmt.registerOutParameter(2, Types.NVARCHAR);
		
		//CallableStatement.execute() : 저장 프로시저 호출 명령을 전달하여 실행하는 메소드
		cstmt.execute();
		
		//CallableStatement.getXXX(int parameterIndex) 
		// => 저장 프로시저의 OUT 모드의 매개변수로 제공받은 값을 반환하는 메소드
		String name=cstmt.getString(2);
		if(name==null) {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		} else {
			System.out.println("[메세지]"+name+"님을 삭제 하였습니다.");
		}
		
		ConnectionFactory.close(con, cstmt);
	}
}