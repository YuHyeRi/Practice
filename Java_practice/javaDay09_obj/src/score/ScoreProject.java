package score;
public class ScoreProject {
	
	public static void main(String[] args) {
		
		// ScoreData s1 = new ScoreData();
		// s1.setName("������");
		
		ScoreManager mgr = new ScoreManager();
		mgr.append();	// �ڿ� �Է°� �޾� �߰��ϴ� �Լ�
		mgr.process();	
		mgr.output();
		
	}
}
