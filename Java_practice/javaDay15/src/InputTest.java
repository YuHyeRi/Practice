import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputTest {
	// 1. throws IOException => ȣ���ϴ� �Լ��ʿ����� ó���� ���־����
	static void inputTest1() throws IOException {
		int a;
		a = System.in.read();// Ű����κ��� ���ڸ� �ϳ��� ����, ��ȯ�� char�� �ƴ϶�, int�� ��ȯ
		while(a!=-1) {		 // ���̻� ���� ���ڰ� ������ -1�� ��ȯ
			System.out.println((char)a);
			a = System.in.read();
		}
	}
	
	static void binaryFileRead() throws IOException {
		FileInputStream in = new FileInputStream("test.txt");
		byte[] buffer = new byte[100];
		in.read(buffer);
		System.out.println(new String(buffer));	// byte�迭�� String���� 
		in.close();
	}
	
	static void binaryFileWrite() throws IOException {
		FileOutputStream out = new FileOutputStream("test.txt");
		byte[] buffer = "hello".getBytes();	// String -> byte�迭��
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
			fileWrite();			// test.txt ���� �������
			fileRead();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
}
