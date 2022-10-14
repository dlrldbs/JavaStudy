package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//회원정보(Member 객체)를 파일에 전달하여 저장하는 프로그램
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/member.txt"));
		
		//ObjectOutputStream.writeObject(Object o) 메소드 호출시 NotSerializableException 발생
		//NotSerializableException : 객체 직렬화 처리하지 않은 클래스의 객체를 출력스트림으로 전달할 경우 발생되는 예외
		//전달할 경우 발생되는 예외
		// => 출력스트림으로 전달할 객체의 클래스를 객체 직렬화 처리하면 예외 미발생
		out.writeObject(new Member("abc123","사울","010-1324-4321"));
		out.writeObject(new Member("xyz789","굿맨","010-4231-5521"));
		out.writeObject(new Member("lkj456","맥길","010-1789-3571"));
		
		out.close();
		
		System.out.println("c:/data/object.txt 파일에 회원정보를 저장하였습니다.");
	}
}
