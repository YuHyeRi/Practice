import com.multiplechoice.MultipleChoiceDao;

public class MutipleChoiceMain {
	
	public static void main(String[] args) {
		
		MultipleChoiceDao d1 = new MultipleChoiceDao();
		d1.append();
		d1.process();
		d1.output();
		
	}
}
