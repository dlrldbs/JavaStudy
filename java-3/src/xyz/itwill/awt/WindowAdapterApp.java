package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//이벤트 처리를 위해 리스너 인터페이스 대신 어댑터 클래스를 상속받아 사용 가능
// => 리스너 인터페이스에 추상메소드가 2개이상 선언된 경우 리스너 인터페이스 대신 사용할 어댑터 클래스 제공
// => 필요한 이벤트 처리 메소드만 오버라이드 선언 
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowEventHandle());
		
		//내부의 익명 클래스를 사용하여 프레임의 닫기 버튼을 누른 경우 프로그램 종료되도록
		//이벤트 처리 객체 등록
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("WindowAdapter");
	}
	
	/*
	public class WindowEventHandle extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	*/
}