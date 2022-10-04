package nested;

//중첩클래스(Nested Class) : 클래스(OuterClass) 내부에 다른 클래스(InnerClass)를 선언
// => 두개의 클래스가 밀접한 관계에 있을 때 선언하며 캡슐화를 강화하는데 사용

public class OuterOne {
	private int outerNum;
	
	public OuterOne() {
		// TODO Auto-generated constructor stub
	}
	
	public OuterOne(int outerNum) {
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
		//외부클래스에서 내부클래스의 필드 또는 메소드에 대한 직접적인 참조 불가능
		//System.out.println("innerNum = "+innerNum);
		
		//외부클래스에서는 내부클래스로 객체를 생성하여 접근제한자에 상관없이 내부클래스의  
		//필드 또는 메소드 참조 가능
		//InnerOne innerOne=new InnerOne(200);
		//System.out.println("innerNum = "+innerOne.innerNum);
	}
	
	//일반 중첩 클래스 >> 컴파일 결과를 [외부클래스$내부클래스.class] 파일로 제공
	// => 일반 중첩 클래스에서는 static 제한자를 사용하여 필드 또는 메소드 선언 불가능
	public class InnerOne {
		private int innerNum;
		
		public InnerOne() {
			// TODO Auto-generated constructor stub
		}

		public InnerOne(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}
		
		public void displayInner() {
			System.out.println("innerNum = "+innerNum);

			//내부클래스에서는 외부클래스의 필드 또는 메소드를 접근제한자에 상관없이 참조 가능 
			//System.out.println("outerNum = "+outerNum);
			//displayOuter();
		}
	}
}
