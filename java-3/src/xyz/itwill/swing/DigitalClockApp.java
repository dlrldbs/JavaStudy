package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//날짜와 시간을 출력하기 위한 컴퍼넌트를 저장하기 위한 필드
	private JLabel clockLabel;
	
	//스레드를 일시 중지하거나 다시 실행하기 위한 컴퍼넌트를 저장하기 위한 필드
	private JButton startBtn, stopBtn;
	
	//날짜와 시간을 변경하는 스레드의 실행상태를 저장하기 위한 필드
	// => false : 스레드 중지 상태, true : 스레드 동작 상태(기본)
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);
		
		isRun=true;
		
		//clockLabel=new JLabel("2022년 10월 12일 17시 27분 40초",JLabel.CENTER);
		clockLabel=new JLabel("",JLabel.CENTER);
		clockLabel.setFont(new Font("굴림체",Font.BOLD,30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		startBtn=new JButton("다시 실행");
		stopBtn=new JButton("일시 중지");
		JPanel jPanel=new JPanel();
		jPanel.add(startBtn);
		jPanel.add(stopBtn);
		startBtn.setFont(new Font("굴림체",Font.BOLD,20));
		stopBtn.setFont(new Font("굴림체",Font.BOLD,20));
		startBtn.setEnabled(false);
		
		getContentPane().add(clockLabel,BorderLayout.CENTER);
		getContentPane().add(jPanel,BorderLayout.SOUTH);
		
		//새로운 스레드가 생성되어 run() 메소드 명령 실행
		// => 1초마다 시스템의 현재 날짜와 시간을 제공받아 컴퍼넌트 변경
		new ClockThread().start();
		
		startBtn.addActionListener(new ClockEventHandle());
		stopBtn.addActionListener(new ClockEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,600,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DigitalClockApp("디지털 시계");
	}
	
	//시스템의 현재 날짜와 시간을 제공받아 컨퍼넌트를 변경하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			
			while(true) {//스레드가 동작상태인 경우
				if(isRun) {
					/*
					Date now=new Date();
					String clock=dateFormat.format(now);
					//JLabel.setText(String text) : JLabel 컴퍼넌트의 문자열을 변경하는 메소드
					clockLabel.setText(clock);
					*/
					
					clockLabel.setText(dateFormat.format(new Date()));
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}						
		}
	}
	//버튼을 누른 경우 실행될 이벤트 처리 클래스
	public class ClockEventHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource==startBtn) {
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
				isRun=true;//스레드를 실행상태로 변경 - 새로운 스레드가 명령 실행
			} else if (eventSource==stopBtn) {
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
				isRun=false;//스레드를 중지상태로 변경 - 새로운 스레드가 명령 미실행
			}
			
		}
		
	}
	
}
