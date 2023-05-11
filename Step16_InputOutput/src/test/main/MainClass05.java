package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		// 학습을 위해서 PrintStream 객체를 부모 type OutputStreame 으로 받아보기
		PrintStream ps = System.out;
		// OutputStream도 1byte 처리 스트림이다.
		OutputStream os = ps;
		// 2byte 처리 스트릠
		OutputStreamWriter osw = new OutputStreamWriter(os);
		try {
			osw.write(48148);
			osw.write(48372);
			osw.write(44032);
			osw.write("아니야");
			// 출력을위해 flush() 메소드 호출
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
