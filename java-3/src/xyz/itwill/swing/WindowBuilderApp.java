package xyz.itwill.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WindowBuilderApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton red;
	private JButton green;
	private JButton blue;
	private JTextArea textArea;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public WindowBuilderApp() {
		setTitle("WindowBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 200, 400, 500);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		red = new JButton("빨간색");
		red.setForeground(new Color(255, 0, 0));
		red.setFont(new Font("굴림", Font.BOLD, 16));
		panel.add(red);
		
		green = new JButton("초록색");
		green.setForeground(new Color(0, 255, 0));
		green.setFont(new Font("굴림", Font.BOLD, 16));
		panel.add(green);
		
		blue = new JButton("파란색");
		blue.setForeground(new Color(0, 0, 255));
		blue.setFont(new Font("굴림", Font.BOLD, 16));
		panel.add(blue);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setFont(new Font("굴림체", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
	}

}