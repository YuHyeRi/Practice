package score;
public class ScoreProject {
	
	public static void main(String[] args) {
		
		// ScoreData s1 = new ScoreData();
		// s1.setName("유혜리");
		
		ScoreManager mgr = new ScoreManager();
		mgr.append();	// 뒤에 입력값 받아 추가하는 함수
		mgr.process();	
		mgr.output();
		
	}
}
