package frame08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	
	JTextField inputMsg;
	JLabel label;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		// 초기 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// 문자열을 한줄 입력 할수 있는 JTextField 객체 생성
		this.inputMsg = new JTextField(10);
		JButton sendBtn = new JButton("전송");
		JButton sendBtn2 = new JButton("전송2");
		// 문자열을 단순히 출력할수 있는 JLable 객체
		label = new JLabel("...");
		
		// 리스너 등록
		sendBtn.addActionListener(this);
		// 함수 형태로 액션 리스너를 등록 할수도 있다.
		sendBtn2.addActionListener((e)->{
			String value2 = inputMsg.getText();
			JOptionPane.showMessageDialog(this, value2);
			label.setText(value2);
		});
		
		
		// 프레임에 UI 를 추가한다.
		add(inputMsg);
		add(sendBtn);
		add(sendBtn2);
		add(label);
		
		// UI를 모두 배치하고 나중에 호출하는것이 원칙이다
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
	public void actionPerformed(ActionEvent e) {
		// 1. JTextField 에 입력한 문자열을 읽어온다.
		String value = inputMsg.getText();
		// 2. 읽어온 문자열을 알림창에 띄운다.
		JOptionPane.showMessageDialog(this, value);
		// 3. 읽어온 문자열을 JLabel 에 출력하기
		label.setText(value);
	}
}
