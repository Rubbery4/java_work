package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
		// 필드
		JButton addBtn, minusBtn, multiplyBtn, divideBtn;
		JTextField inputMsg, outputMsg;
		JLabel label, label2;
		
	public MyFrame(String title) {
		super(title);
		
		setBounds(100, 100, 900, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		inputMsg = new JTextField(10);
		addBtn = new JButton("+");
		minusBtn = new JButton("-");
		multiplyBtn = new JButton("*");
		divideBtn = new JButton("/");
		outputMsg = new JTextField(10);
		label2 = new JLabel("=");
		label = new JLabel("0");
		
		// 리스너 등록
		addBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiplyBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		
		// 프레임에 추가
		add(inputMsg);
		add(addBtn);
		add(minusBtn);
		add(multiplyBtn);
		add(divideBtn);
		add(outputMsg);
		add(label2);
		add(label);
		
		// 호출
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new MyFrame("테스트");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object which = e.getSource();
		String input = inputMsg.getText();
		String output = outputMsg.getText();
		try {
		double num = Double.parseDouble(input);
		double num2 = Double.parseDouble(output);
		// 연산의 결과값을 담을 변수를 미리 선언하고 초기값 대입하기 (왜 미리 선언 해야하나? 를 알아야함)
		double result=0;
		if (which == addBtn ) {
			// add
			result = num+num2;
		} else if (which == minusBtn) {
			// 마이너스
			result = num-num2;
		} else if (which == multiplyBtn) {
			// 곱하기
			result = num*num2;
		} else if (which == divideBtn) {
			if(num2==0) {
				JOptionPane.showMessageDialog(this, "어떤 수를 0으로 나눌수는 없어요");
				// 여기서 메소드를 종료(리턴) 시키기
				return;
			}
			// 나누기
			result = num/num2;
		}
		// Double 을 String로 바꾸기
		String result2 = Double.toString(result);
		// 결과값을 출력
		label.setText(result2);
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "숫자형식으로 입력해주세요.");
		} 
	}

}
