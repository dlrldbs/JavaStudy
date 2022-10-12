package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventAnnonymousHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventAnnonymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT");
		add(exit);
		
		//리스너 인터페이스를 상속받은 익명의 클래스를 이용하여 이벤트 처리 객체 등록
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new EventAnnonymousHandleApp("EventAnnonymousHandle");
	}
	
}
