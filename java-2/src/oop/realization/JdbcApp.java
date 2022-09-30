package realization;

public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mysql=new JdbcMysql();
		
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
		
		/*
		//시스템 변경에 의해 클래스 교체에 대한 메소드 호출 명령 변경
		// => 클래스간의 결합도가 높기 때문에 유지보수의 효율성 감소
		JdbcOracle oracle=new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.get();
		*/
		
		//클래스간의 결합도를 낮추기 위해 참조변수는 인터페이스를 이용하여 선언
		//Jdbc jdbc=new JdbcMysql();
		//시스템 변경에 의해 클래스 교체시 메소드 호출 명령 미변경
		// => 객체간의 결합도를 낮춰 유지보수의 효율성 증가
		Jdbc jdbc=new JdbcOracle();
		
		//참조변수로 인터페이스의 추상메소드를 호출하면 묵시적 객체 형변환으로 의해 참조변수에
		//저장된 자식클래스의 객체의 메소드를 참조하여 호출
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}
