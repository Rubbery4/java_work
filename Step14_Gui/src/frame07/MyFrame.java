package frame07;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{

	
	//생성자
	public MyFrame(String title) {
		super(title);
		
		// setBounds(x, y, width, height) 창의 위치와 크기 설정
		this.setBounds(100, 100, 500, 500);
		// 이프레임(MyFrame)의 x 버튼 (close 버튼) 을 눌렀을때 프로세스도 같이 종료 되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//BorderLayout 매니저 사용해보기.
		setLayout(new FlowLayout());
		// 전송 버튼의 참조값을 필드에 저장(this. 은 생략 가능)
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		JButton updateBtn = new JButton("수정");
		add(updateBtn);
		
		// 전송, 삭제, 수정 버튼 모두다 하나의 리스너 등록하기
		sendBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		
		// 각각의 버튼에 action 명령을 설정할수 있다.
		sendBtn.setActionCommand("send");
		deleteBtn.setActionCommand("delete");
		updateBtn.setActionCommand("update");
		

		// 프레임을 화면상에 실제 보이게 하기(false 하면 화면에 보이지 않는다)
		this.setVisible(true);
	}
		
	public static void main(String[] args) {
		// MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료 됩니다.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
