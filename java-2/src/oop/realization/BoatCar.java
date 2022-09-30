package realization;

//인터페이스는 다른 인터페이스를 상속받아 작성 가능
// => extends 키워드로 상속받으며 다중 상속 가능
public interface BoatCar extends Boat,Car {
	void floating();
}
