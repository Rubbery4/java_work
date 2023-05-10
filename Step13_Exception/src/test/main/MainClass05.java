package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 현재 존재하거나 혹은 존재하지 않는 파일이나 폴더를 제어 할수 있는 File 객체를 생성해서
		 * 참조값을 f 라는 지역변수에 담기
		 */
		try {
		File f = new File("c:/acorn202304/myFolder/memo.txt");
		// 실제 memo.txt 파일이 존재하지 않으면 파일을 만들고
		// 존재하면 memo.txt 파일을 삭제하도록 프로그래밍 해 보세요.
		if (!f.exists()) {
			f.createNewFile();
			System.out.println("파일생성완료");
		} else {
			f.delete();
			System.out.println("파일삭제완료");
		}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("에러발생");
		}
	}
}
