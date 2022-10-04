package nested;

public class OuterThree {
	private int outerNum;
	
	public OuterThree() {
		// TODO Auto-generated constructor stub
	}
	
	public OuterThree(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}

	public void displayOuter() {
		System.out.println("outerNum = "+outerNum);
		
		//외부클래스에서 로컬클래스를 사용하여 객체 생성 불가능
		//InnerThree innerThree=new InnerThree();
	}
	
	public void local() {
		//로컬클래스(Local Class) : 메소드 내부에 선언된 클래스 - 메소드가 종료되면 자동 소멸
		// => final 또는 abstract 제한자만 사용하여 클래스 선언 가능
		// => static 제한자를 사용하여 필드 또는 메소드 선언 불가능
		// => 선언된 메소드에서만 객체를 생성하여 사용하므로 접근제한자 선언 생략 가능
		// => 비동기식 처리를 위한 스레드 객체를 생성하기 위해 사용
		class InnerThree {
			int innerNum;
			
			void displayInner() {
				System.out.println("innerNum = "+innerNum);
			}
		}
		
		InnerThree innerThree=new InnerThree();
		innerThree.innerNum=200;
		//System.out.println("innerThree.innerNum = "+innerThree.innerNum);
		innerThree.displayInner();
	}
}


