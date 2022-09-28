
package xyz.itwill.other;

import xyz.itwill.access.PublicMember;

public class PublicMemberOtherUse {
	public void run() {
		//다른 패키지의 클래스를 사용하기 위한 import 처리
		PublicMember member=new PublicMember();
		
		member.num=100;
		member.display();
	}
}