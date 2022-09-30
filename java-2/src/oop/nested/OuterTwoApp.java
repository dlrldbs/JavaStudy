package nested;

import nested.OuterTwo.InnerTwo;

public class OuterTwoApp {
	public static void main(String[] args) {
		OuterTwo outerTwo=new OuterTwo(100);
		outerTwo.displayOuter();
		System.out.println("==============================================================");
		//정적 중첩 클래스는 직접 객체 생성 가능
		InnerTwo innerTwo=new InnerTwo(300);
		innerTwo.displayInner();
		System.out.println("==============================================================");
		
	}
}
