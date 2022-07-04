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
		
		// 이런식으로 붙일 수 있음
		Lotto l1 = new Lotto();
		GameStart g1 = new GameStart();
		UpdownGame u1 = new UpdownGame();
		
		Scanner sc = new Scanner(System.in);
		int sel;
		
		do {
			System.out.println("1.로또  2.가위바위보  3.updown  0.종료");
			sel = sc.nextInt();
			
			switch(sel) {
			case 0 : 
					System.out.println("종료");
					return;		// 함수종료
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
					System.out.println("다시 입력하세요.");
			}
		} while(true);
		
	}
}
