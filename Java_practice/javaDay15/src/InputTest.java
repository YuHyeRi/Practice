import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputTest {
	// 1. throws IOException => 호출하는 함수쪽에서도 처리를 해주어야함
	static void inputTest1() throws IOException {
		int a;
		a = System.in.read();// 키보드로부터 글자를 하나씩 읽음, 반환을 char가 아니라, int로 반환
		while(a!=-1) {		 // 더이상 읽을 글자가 없으면 -1을 반환
			System.out.println((char)a);
			a = System.in.read();
		}
	}
	
	static void binaryFileRead() throws IOException {
		FileInputStream in = new FileInputStream("test.txt");
		byte[] buffer = new byte[100];
		in.read(buffer);
		System.out.println(new String(buffer));	// byte배열을 String으로 
		in.close();
	}
	
	static void binaryFileWrite() throws IOException {
		FileOutputStream out = new FileOutputStream("test.txt");
		byte[] buffer = "hello".getBytes();	// String -> byte배열로
		out.write(buffer);
		out.close();
	}
	
	static void fileWrite() throws IOException {
		File fout = new File("test2.text");
		BufferedWriter bout = new BufferedWriter(new FileWriter(fout));
		bout.write("hello\n");
		bout.write("world\n");
		bout.write("nice to meet you ;\n");
		bout.close();
	}
	
	static void fileRead() throws IOException {
		File file = new File("test2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
			line = br.readLine();
		} br.close();
	}
	
	public static void main(String[] args) throws IOException {
		try {
			// inputTest1();
			// binaryFileRead();
			// binaryFileWrite();
			fileWrite();			// test.txt 파일 만들어짐
			fileRead();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
}
