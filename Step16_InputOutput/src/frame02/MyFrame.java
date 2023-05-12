package frame02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame  {
	// 현재 열려있는 File 객체의 참조값을 저장할 필드
	File openedFile;
	JTextArea ta;
	public MyFrame(String title) {
		super(title);
		
	    setBounds(100, 100, 500, 500); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // BorderLayout 으로 설정
	    setLayout(new BorderLayout());
	    
	    // 메뉴바
	    JMenuBar mb = new JMenuBar();
	    // 메뉴
	    JMenu menu = new JMenu("File");
	    
	    // 매뉴 아이템
	    JMenuItem newItem = new JMenuItem("New");
	    JMenuItem openItem = new JMenuItem("Opne");
	    JMenuItem saveItem = new JMenuItem("Save");
	    JMenuItem saveAsItem = new JMenuItem("Save As");
	    ta = new JTextArea();
	    // 메뉴에 메뉴 아이템을 순서대로 추가
	    menu.add(newItem);
	    menu.add(openItem);
	    menu.add(saveItem);
	    menu.add(saveAsItem);
	    add(ta);
	    // 메뉴를 메뉴바에 추가
	    mb.add(menu);
	    // 프레임의 메소드로 이용해서 메뉴바를 추가하기
	    setJMenuBar(mb);
	    
	    // UI 를 감쌀 패널
	    JPanel p1 = new JPanel();
	    
	    JTextField inputText = new JTextField(20);
	    JButton saveBtn = new JButton("저장");
	    
	    // 패널에 UI를 추가
	    p1.add(inputText);
	    p1.add(saveBtn);
	    // Open 을 눌렀을때 실행할 리스너 등록
	    openItem.addActionListener((e2)->{
	    	JFileChooser fc = new JFileChooser("c:\\acorn202304\\myFolder");
	    	int result = fc.showOpenDialog(this);
	    	if (result == JFileChooser.APPROVE_OPTION) {
	    		// 선택한 파일을 제어 할수 있는 File 객체가 리턴된다. (필드에 저장해두기)
	    		openedFile = fc.getSelectedFile();
	    		
	    		//선택한 파일의 경로
	    		String path = openedFile.getAbsolutePath();
	    		// 프레임의 제목에 선택한 파일의 경로를 저장한다.
	    		this.setTitle(path);
	    		
	    		// try 블럭안에서 사용할 변수를 미리 만들어 놓는다.
		    	FileReader fr=null;
		    	BufferedReader br=null;
		    	
			    ta = new JTextArea();
			    add(ta, BorderLayout.CENTER);
		    	try {
		    	// 참조값은 try 블럭 안에서 new 해서 넣어준다.
		    	fr = new FileReader(openedFile);
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
	    		
	    	}
	    });
	    
	    JButton readBtn = new JButton("읽어오기");
	    p1.add(readBtn);
	    


	    // Save를 눌렀을때 실행할 리스너 등록
	    saveItem.addActionListener((e0)->{
	    	// 만일 열려진 파일이 없다면
	    	if(openedFile==null) {
	    		JOptionPane.showMessageDialog(this, "파일을 먼저 열어주세요");
	    		return; // 메소드를 여기서 종료
	    	}
	    	// 입력한 내용을 파일에 저장하기
	    	saveToFile();
	    });
	    
	    saveAsItem.addActionListener((e2)->{
	    	JFileChooser fc = new JFileChooser("C:/acorn202304/myFolder");
	    	int result = fc.showSaveDialog(this);
	    	if(result==JFileChooser.APPROVE_OPTION) {
	    		// 선택한 File 객체의 참조값을 얻어낸다.
	    		openedFile = fc.getSelectedFile();
	    		// title 출력
	    		setTitle(openedFile.getAbsolutePath());
	    		
	    		// 새로운 파일을 실제로 만들기
	    		try {
					openedFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		
	    		// 파일에 문자열 저장하기
	    		saveToFile();
	    	}
	    });
	    
	    
	    
	    setVisible(true);
	    
	}
	
	public void saveToFile() {
		String content = ta.getText();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(openedFile);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.flush();
			JOptionPane.showMessageDialog(this, "저장 했습니다");	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null)bw.close();
				if(fw!=null)fw.close();
			} catch(Exception e) {}
		}
		
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
