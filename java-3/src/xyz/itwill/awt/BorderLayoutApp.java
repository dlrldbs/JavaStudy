package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//BorderLaydout : 컴퍼넌트를 컨테이너의 중앙,동,서,남,북으로 구분하여 부착하는 배치관리자
// => 컴퍼넌트를 컨테이너에 부착할 때 부착 위치를 반드시 설정
public class BorderLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public BorderLayoutApp(String title) {
		super(title);
		
		//프레임의 배치관리자를 BorderLayout 객체로 변경
		setLayout(new BorderLayout());//생략 가능 - 프레임은 BorderLayout 객체가 기본 배치관리자로 설정
		
		Button button1=new Button("Center");
		Button button2=new Button("East");
		Button button3=new Button("West");
		Button button4=new Button("South");
		Button button5=new Button("North");
		
		//Container.add(Component c, Object constraints) : 컴퍼넌트를 컨테이너의 원하는 위치에 부착하는 메소드
		// => 컴퍼넌트의 부착위치는 BorderLayout 클래스의 상수필드 이용
		// => 컴퍼넌트의 부착위치가 생략된 경우 컴퍼넌트를 무조건 중앙에 부착
		// => 컨테이너 중앙에는 반드시 컴퍼넌트를 배치해야 되지만 동서남북은 생략 가능
		add(button1, BorderLayout.CENTER);
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.WEST);
		add(button4, BorderLayout.SOUTH);
		add(button5, BorderLayout.NORTH);
		
		setBounds(600, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayoutApp");
	}
	
}
