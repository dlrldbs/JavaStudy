package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int Cho = 245678;
		int Day = Cho / (60 * 60 *24); //24*60*60 = 86400
		Cho %= 86400; //Cho=Cho%86400
		int Hour = Cho/(60*60); //60*60=3600
		Cho %= 3600;
		int Min = Cho/60;
		int Sec = Cho % 60;
		
		System.out.println("245678초는 "+Day+"일"+Hour+"시"+Min+"분"+Sec+"초 입니다.");

		System.out.println("===============================================");
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		
		int AirplanePrice=150_000_000,AirplaneS=20;
		long Price = (long)(AirplaneS>15?AirplanePrice*0.75:AirplanePrice)*AirplaneS;
		System.out.println("비행기의 가격은 = "+ Price +"만원 입니다.");

		System.out.println("===============================================");
	}
}