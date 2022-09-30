package realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
		//BoatCarReal carReal=new BoatCarReal();
		//클래스가 상속받은 모든 인터페이스로 참조변수를 생성하여 자식클래스의 객체 저장 가능
		// => 묵지적 객체 형변환에 의해 오버라이드 선언된 자식클래스의 메소드 호출
		// => 인터페이스에 따라 호출 가능한 메소드가 다름
		BoatCar boatCar=new BoatCarReal();
		//Boat boat=new BoatCarReal();
		//Car car=new BoatCarReal();
		
		boatCar.floating();
		boatCar.navigate();
		boatCar.run();
		
	}
}
