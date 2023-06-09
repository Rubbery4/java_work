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
import test.dto.MemberDto;

public class TestFrame extends JFrame implements ActionListener {
	
	JTextField inputAddr, inputName, inputNum;
	DefaultTableModel model;
	JTable table;
	
	// 생성자
	public TestFrame(String title) {
		super(title);
		
		// 레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(10);
		
		JLabel label2 = new JLabel("주소");
		inputAddr = new JTextField(10);
		
		JButton addBtn = new JButton("추가");
		addBtn.setActionCommand("add");
		addBtn.addActionListener(this);
		
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		// 패널에 UI  를 배치하고
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);   
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		
		
		//패널쨰로 프레임의 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.yellow);
		
		table = new JTable();
		
		
		String[] colNames = {"번호", "이름", "주소"};
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
		
//		List<MemberDto> list = new MemberDao().getList();
		
		// 일반 for문 사용
//		for (int i=0; i<list.size(); i++) {
//			MemberDto tmp1 = list.get(i);
//			Object[] row5 = {tmp1.getNum(), tmp1.getName(), tmp1.getAddr()};
//			model.addRow(row5);
//		}
		
		// 확장 for문 사용
//		for(MemberDto tmp:list) {
//			Object[] row4 = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
//			model.addRow(row4);
//		}
		
		
		// 부모 객체의 메소드를 마음대로 호출할수 있다. this. 생략 가능
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setBounds(100, 100, 800, 500);
//		this.setVisible(true);
	}
	
	// run 했을때 실행의 흐름이 시작되는 main 메소드
	public static void main(String[] args) {
		TestFrame f = new TestFrame("테스트 프레임");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 읽어오기
		String cmd=e.getActionCommand();
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		if (cmd.equals("add")) {

		//DB 연결객체를 담을 지역 변수 만들기
		String name = inputName.getText();
		String addr = inputAddr.getText();

		dto.setName(name);
		dto.setAddr(addr);
		// MemberDao 객체의 insert() 메소드를 이용해서 DB에 저장하고
		boolean isSuccess = dao.insert(dto);
		// MemberDao 객체를 이용해서 회원 정보를 저장하고 성공 여부를 리턴받는다.
		if (isSuccess) {
			JOptionPane.showMessageDialog(this, "저장했습니다.");
			// 기존에 출력된 내용을 모두 삭제후 다시출력
			displayMember();
		}
		} else if(cmd.equals("delete")) {
			//JTable 로 부터 선택된 row 의 인덱스를 얻어낸다
			int selectedRow = table.getSelectedRow();
			if (selectedRow==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요.");
				return; // 메소드를 여기서 끝냄(리턴)
			}
			
				int result = JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까?");
				// "예" 버튼을 눌렀을때만 실제 삭제하기
				if (result==JOptionPane.OK_OPTION) {
					// 선택된 row 에 해당하는 회원번호 (PK) 를 얻어낸다
					int num= (int) model.getValueAt(selectedRow, 0);
					dao.delete(num);
					JOptionPane.showMessageDialog(this, num+"행 삭제 했습니다.");
					// 기존에 출력된 내용을 모두 삭제후 다시출력
					displayMember();
				} else if (result==JOptionPane.NO_OPTION) {
					return;
				} else if (result==JOptionPane.CANCEL_OPTION) {
					return;
				}
		}
	      
	}
	//TestFrame 에 메소드 추가
	public void displayMember() {
		// 기존에 출력된 내용을 모두 삭제후 다시출력
		model.setRowCount(0);
		// 회원목록 얻어오기
		List<MemberDto> list = new MemberDao().getList();
		for(MemberDto tmp:list) {
			Object[] row4 = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row4);
		}
	}
	
}
