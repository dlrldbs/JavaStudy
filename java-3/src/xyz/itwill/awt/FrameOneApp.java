package xyz.itwill.awt;

import java.awt.Frame;

//CUI(Character User Interface) 프로그램 : 문자 중심의 실행 환경을 제공하는 프로그램
//GUI(Graphic User Interface) 프로그램 : 그래픽 중심의 실행 환경을 제공하는 프로그램
// => 컴퍼넌트를 이용하여 작성된 프로그램

//컴퍼넌트(Component) : GUI 프로그램에서 디자인 요소를 구현하기 위한 클래스
// => Button, List, Label, Canvas, Checkbox, Choice, Scrollbar, TextField, TextArea 등
//컨테이너(Container) : 컴퍼넌트를 부착하기 위한 컴퍼넌트
// => 독립적 컨테이너 : Frame, Window, Dialog 등 - 독립적으로 사용 가능
// => 종속적 컨테이너 : Panel, ScrollPane 등 - 다른 컨테이너에 부착하여 사용 가능
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame : 메뉴가 존재하는 컨테이너  
		Frame frame=new Frame();//메모리에 생성되며 Frame 객체가 생성되며 미출력
		
		//Component.setSize(int width, int height) : 컴퍼넌트의 크기(폭과 넓이)를 변경하는 메소드
		// => 크기 또는 위치는 픽셀(Pixel : 색을 표현하는 점)을 기본단위로 사용
		frame.setSize(300,300);
		
		//Component.setLocation(int x, int y) : 컴퍼넌트의 출력위치 (x 좌표와 y 좌표)를 변경하는 메소드
		frame.setLocation(500,100);
		
		//Compoenet.setVisible(boolean b) : 컴퍼넌트의 출력 유무를 설정하는 메소드
		// => false : 미출력, true : 출력
		frame.setVisible(true);
	}
}
