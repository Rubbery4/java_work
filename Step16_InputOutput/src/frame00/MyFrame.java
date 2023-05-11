package frame00;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import frame00.MyFrame;

public class MyFrame extends JFrame implements ActionListener {
		JTextField inputMsg;
		
	   //생성자
	   public MyFrame(String title) {
	      super(title);
	      setBounds(100, 100, 500, 500); 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLayout(new FlowLayout());
	      
	      inputMsg = new JTextField(10);
	      //프레임에 JTextField 추가
	      add(inputMsg);
	      
	      JButton addBtn=new JButton("저장");
	      addBtn.addActionListener(this);
	      //프레임에 버튼 추가
	      add(addBtn);
	      
	      // 프레임을 화면상에 실제 보이게 하기( false 하면 화면에 보이지 않는다 )
	      setVisible(true);
	   }
		public static void main(String[] args) {
			new MyFrame("테스트");
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {	

		String input = inputMsg.getText();
		
		File f = new File("c:/acorn202304/myFolder/diary.txt");
		try {
			// 파일이 존재하지 않는다면 
			if(!f.exists()) {
				// 파일을 만든다.
				f.createNewFile();
				System.out.println("diary.txt 파일 생성완료");
			} 
			// 파일에 문자열을 출력할수 있는 객체의 참조값 얻어내기
			// new FileWriter( File 객체, append 모드 여부)
			FileWriter fw = new FileWriter(f, true);
			fw.write(input); // 출력할 준비
			fw.flush(); // 출력
			fw.close(); // 마무리
			System.out.println("diary.txt 파일에 문자열을 기록 했습니다.");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
	}
}
