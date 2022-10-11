package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//모든 컨테이너에는 전달받은 컴퍼넌트를 자동으로 부탁하기 위한 배치관리자 존재
// => Frame, Window, Dialog 등의 기본 배치관리자 : BorderLayout 
// => Panel, Applet 등의 기본 배치관리자 : FlowLayout
//배치관리자(LayoutManager) : 컴퍼넌트의 크기와 출력위치를 자동 변경하여 컨테이너에 부착하기 위한 객체
// - BorderLayout,FlowLayout, GridLayout 등

//배치관리자를 사용하지 않고 프레임에 컴퍼넌트를 부착하여 사용하는 프로그램
public class NonLayoutManagerApp extends Frame {
	private static final long serialVersionUID = 1L; 
	
	public NonLayoutManagerApp(String title) {
		super(title);
		
		//Container.setLayout(LayOutManager mgr) : 컨테이너의 배치관리자를 변경하는 메소드
		setLayout(null);//배치관리자를 사용하지 않도록 설정
		
		Button button1=new Button("Button-1");
		Button button2=new Button("Button-2");
		
		//배치관리자를 사용하지 않을 경우 반드시 컴퍼넌트의 크기와 출력위치를 변경하고 컨테이너
		button1.setBounds(80, 100, 50, 80);
		button2.setBounds(190, 130, 100, 120);
		
		add(button1);
		add(button2);
		
		
		setBounds(600, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("NonLayoutManager");
	}
	
}
