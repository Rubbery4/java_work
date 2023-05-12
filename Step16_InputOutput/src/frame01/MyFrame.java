package frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame  {
	public MyFrame(String title) {
		super(title);
		
	    setBounds(100, 100, 500, 500); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
	    
	    // UI 를 감쌀 패널
	    JPanel p1 = new JPanel();
	    
	    JTextField inputText = new JTextField(20);
	    JButton saveBtn = new JButton("저장");
	    
	    // 패널에 UI를 추가
	    p1.add(inputText);
	    p1.add(saveBtn);
	    // 패널을 프레임의 북쪽에 배치
	    add(p1, BorderLayout.NORTH);
	    // 패널의 배경색
	    p1.setBackground(Color.yellow);
	    /*
	     *  읽어오기 버튼을 누르면 diary.txt 에 있는 모든 문자열을 읽어와서 
	     *  JTextArea 에 출력해 보세요.
	     *  
	     *  hint
	     *  FileReader 객체를 활용하면 파일에서 문자열을 읽어 낼수 있습니다.
	     */
	    
	    JTextArea ta = new JTextArea();
	    add(ta, BorderLayout.CENTER);
	    
	    JButton readBtn = new JButton("읽어오기");
	    p1.add(readBtn);
	    
	    setVisible(true);
	    //File 객체
    	File f = new File("c:\\acorn202304\\myFolder\\diary.txt");
	    
	    // 읽어오기 버튼에 리스너 등록
	    readBtn.addActionListener((e2)->{
	    	// try 블럭안에서 사용할 변수를 미리 만들어 놓는다.
	    	FileReader fr=null;
	    	BufferedReader br=null;
	  
	    	try {
	    	// 참조값은 try 블럭 안에서 new 해서 넣어준다.
	    	fr = new FileReader(f);
	    	br = new BufferedReader(fr);
	    	while (true) {
	    		// 문자열을 한줄씩 읽어낸다.
	    		String line = br.readLine();
	    		// 만일 더이상 읽을 문자열이 없다면 
	    		if(line==null)break; // 반복문 탈출
	    		// 읽어낸 문자열을 JTextArea 에 출력하기
	    		ta.append(line); // 개행기호는 제외된 상태로 읽어내기 떄문에 
	    		ta.append("\r\n"); // 개행기호를 따로 추가해준다
	    	}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
		    	// 사용했던 스트림은 닫아주는것이 좋다 (열렸던 순서의 역순으로)
				try {// 여기서 NullPointerException 이 발생하면 fr.close()가 호출안될 가능성이 있다.
					//close() 를 호출할때도 null 에 주의해서 호출해야 한다.
					if(br!=null)br.close();
					if(fr!=null)fr.close();
				} catch(Exception e) {}
			}
	    });
	    
	    // 세이브 버튼에 리스너 등록
	    saveBtn.addActionListener((e)->{
	    	// 입력한 문자열 읽어오기
	    	String msg = inputText.getText();
	    	try { 
	    	if(!f.exists()) {
	    		f.createNewFile();
	    		}
	    	//파일에 문자열을 출력할 객체
	    	FileWriter fw = new FileWriter(f, true);
	    	fw.write(msg);
	    	fw.write("\r\n");
	    	fw.flush();
	    	fw.close();
	    	JOptionPane.showMessageDialog(this, "저장완료");
	    	} catch (Exception e1) {
	    		e1.printStackTrace();
	    	}
	    	
	    });
	    
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
