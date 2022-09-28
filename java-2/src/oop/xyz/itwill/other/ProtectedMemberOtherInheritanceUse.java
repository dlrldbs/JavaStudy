package xyz.itwill.other;

import xyz.itwill.access.ProtectedMember;

public class ProtectedMemberOtherInheritanceUse extends ProtectedMember {
	public void run() {
		//protected 접근제한자로 설정된 부모클래스의 필드 또는 메소드에 접근 가능
		num=100;
		display();
	}
}