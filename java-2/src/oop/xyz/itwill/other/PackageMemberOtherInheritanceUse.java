package xyz.itwill.other;

import xyz.itwill.access.PackageMember;

public class PackageMemberOtherInheritanceUse extends PackageMember {
	public void run() {
		//package 접근제한자로 설정된 부모클래스의 필드 또는 메소드에 접근할 경우 에러 발생
		//num=100;
		//display();
	}
}