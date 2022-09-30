package realization;

public class JdbcMysql implements Jdbc {
	public void insert() {
		System.out.println("[mysql]학생정보를 삽입하는 메소드");
	}
	
	public void update() {
		System.out.println("[mysql]학생정보를 변경하는 메소드");
	}
	
	public void delete() {
		System.out.println("[mysql]학생정보를 삭제하는 메소드");
	}
	
	public void select() {
		System.out.println("[mysql]학생정보를 검색하는 메소드");
	}
	
}
