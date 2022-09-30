package nested;

import nested.OuterOne.InnerOne;

public class OuterOneApp {
	public static void main(String[] args) {
		OuterOne outerOne=new OuterOne(100);
		outerOne.displayOuter();
		System.out.println("==============================================================");
		//내부클래스로 직접 객체 생성 불가능
		//InnerOne innerOne=new InnerOne();

		//외부클래스의 객체를 이용하여 내부클래스의 객체 생성 가능
		InnerOne innerOne=outerOne.new InnerOne(300);
		innerOne.displayInner();
		System.out.println("==============================================================");
	}
}