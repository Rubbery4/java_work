package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dao.MemberDao1;
import test.dto.MemberDto;
import test.dto.MemberDto1;

public class TestFrame0 extends JFrame implements ActionListener {
	
	JTextField inputName, inputNum, inputuserId, inputpasswd, inputphone;
	DefaultTableModel model;
	JTable table;
	
	// 생성자
	public TestFrame0(String title) {
		super(title);
		
		// 레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		
		JLabel label1 = new JLabel("아이디");
		inputuserId = new JTextField(10);
		
		JLabel label2 = new JLabel("비밀번호");
		inputpasswd = new JTextField(10);
		
		JLabel label3 = new JLabel("이름");
		inputName = new JTextField(10);
		
		JLabel label4 = new JLabel("핸드폰");
		inputphone = new JTextField(10);
		
		JButton addBtn = new JButton("추가");
		addBtn.setActionCommand("add");
		addBtn.addActionListener(this);
		
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		JButton selectBtn = new JButton("찾기");
		deleteBtn.setActionCommand("select");
		deleteBtn.addActionListener(this);
		
		// 패널에 UI  를 배치하고
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputuserId);   
		panel.add(label2);
		panel.add(inputpasswd);
		panel.add(label3);
		panel.add(inputName);
		panel.add(label4);
		panel.add(inputphone);
		panel.add(addBtn);
		panel.add(deleteBtn);
		panel.add(selectBtn);
		
		//패널쨰로 프레임의 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.green);
		
		table = new JTable();
		

		
		String[] colNames = {"번호", "아이디", "비밀번호", "이름", "휴대전화"};
		// 테이블에 연결할 모델 객체 생성 (테이블에 출력할 데이터를 여기서 추가하면 테이블에 출력된다.)
		model = new DefaultTableModel(colNames, 0);
		// 모델을 테이블에 연결한다.
		table.setModel(model);
		// 스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		// 스크롤을 프레임의 중앙에 배치한다.
		add(scroll, BorderLayout.CENTER);

		// 회원정보 출력하기
		displayMember();
		

	}
	
	// run 했을때 실행의 흐름이 시작되는 main 메소드
	public static void main(String[] args) {
		TestFrame0 f = new TestFrame0("회원 정보 추가");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1000, 800);
		f.setVisible(true);
		f.table.getColumn("번호").setPreferredWidth(10);
	}
	
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 읽어오기
		String cmd=e.getActionCommand();
		MemberDao1 dao = new MemberDao1();
		MemberDto1 dto = new MemberDto1();
		if (cmd.equals("add")) {

		//DB 연결객체를 담을 지역 변수 만들기
		String userid = inputuserId.getText();
		String passwd = inputpasswd.getText();
		String name = inputName.getText();
		String phone = inputphone.getText();

		dto.setUserId(userid);
		dto.setPasswd(passwd);
		dto.setName(name);
		dto.setPhone(phone);
		// MemberDao 객체의 insert() 메소드를 이용해서 DB에 저장하고
		boolean isSuccess = dao.insert(dto);
		// MemberDao 객체를 이용해서 회원 정보를 저장하고 성공 여부를 리턴받는다.
		if (isSuccess) {
			JOptionPane.showMessageDialog(this, "저장했습니다.");
			// 기존에 출력된 내용을 모두 삭제후 다시출력
			displayMember();
			clear();
		}
		
		} else if(cmd.equals("delete")) {
			//JTable 로 부터 선택된 row 의 인덱스를 얻어낸다
			int selectedRow = table.getSelectedRow();
			if (selectedRow==-1) {
				JOptionPane.showMessageDialog(this, "삭제 할 회원을 선택하세요.");
				return; // 메소드를 여기서 끝냄(리턴)
			}
				int result = JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까?");
				
				// "예" 버튼을 눌렀을때만 실제 삭제하기
				if (result==JOptionPane.OK_OPTION) {
					// 선택된 row 에 해당하는 회원번호 (PK) 를 얻어낸다
					int num= (int) model.getValueAt(selectedRow, 0);
					String name = (String) model.getValueAt(selectedRow, 1);
					dao.delete(num);
					JOptionPane.showMessageDialog(this, name+"님을 삭제 했습니다.");
					// 기존에 출력된 내용을 모두 삭제후 다시출력
					displayMember();
					clear();
				} else if (result==JOptionPane.NO_OPTION) {
					return;
				} else if (result==JOptionPane.CANCEL_OPTION) {
					return;
				}
		} else if (cmd.equals("select")) {
			 JOptionPane.showInputDialog(this, "테스트용");
			
			
		}
}
	//TestFrame 에 메소드 추가
	public void displayMember() {
		// 기존에 출력된 내용을 모두 삭제후 다시출력
		model.setRowCount(0);
		// 회원목록 얻어오기
		List<MemberDto1> list = new MemberDao1().getList();
		for(MemberDto1 tmp:list) {
			Object[] row4 = {tmp.getNum(), tmp.getUserId(), tmp.getPasswd(), tmp.getName(), tmp.getPhone()};
			model.addRow(row4);
		}
	}
	
	public void clear() {
		inputName.setText(null);
		inputuserId.setText(null);
		inputpasswd.setText(null);
		inputphone.setText(null);
	}
}
