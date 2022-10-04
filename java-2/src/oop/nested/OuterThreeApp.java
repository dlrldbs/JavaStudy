package nested;

public class OuterThreeApp {
	public static void main(String[] args) {
		OuterThree outerThree=new OuterThree(100);
		
		outerThree.displayOuter();
		outerThree.local();
	}
}
