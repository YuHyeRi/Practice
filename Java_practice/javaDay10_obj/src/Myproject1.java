import java.util.Scanner;
import com.game.GameStart;
import com.lotto.Lotto;
import com.updown.UpdownGame;

public class Myproject1 {
	
	public static void main(String[] args) {
		/*
		Lotto l1 = new Lotto();
		l1.start();
		
		GameStart g1 = new GameStart();
		g1.start();
		
		UpdownGame u1 = new UpdownGame();
		u1.start();
		*/
		
		// �̷������� ���� �� ����
		Lotto l1 = new Lotto();
		GameStart g1 = new GameStart();
		UpdownGame u1 = new UpdownGame();
		
		Scanner sc = new Scanner(System.in);
		int sel;
		
		do {
			System.out.println("1.�ζ�  2.����������  3.updown  0.����");
			sel = sc.nextInt();
			
			switch(sel) {
			case 0 : 
					System.out.println("����");
					return;		// �Լ�����
			case 1 : 
					l1.start();
					break;
			case 2 : 
					g1.start();
					break;
			case 3 : 
					u1.start();
					break;
			default : 
					System.out.println("�ٽ� �Է��ϼ���.");
			}
		} while(true);
		
	}
}
