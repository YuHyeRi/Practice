
import java.util.ArrayList;
import java.util.List;

public class RainDropDao {
	List<RainDropData> list = new ArrayList<RainDropData>();
	
	// 생성자
	public RainDropDao() {
		list.add(new RainDropData("서울", new int[] {10,20,30,40,50,60}));
		list.add(new RainDropData("경기", new int[] {15,15,30,20,50,40}));
		list.add(new RainDropData("부산", new int[] {10,10,30,30,50,30}));
		list.add(new RainDropData("대전", new int[] {18,20,15,40,40,50}));
	}
	
	// 메소드 1
	int getMaxPos() {
		float max = list.get(0).getAvg();
		int pos = 0;
		for(int i=0; i<list.size(); i++) {
			RainDropData data = list.get(i);
			if(max < data.getAvg()) {
				max = data.getAvg();
				pos = i;
			}
		} return pos;
	}
	
	// 메소드 2
	int getMinPos() {
		float min = list.get(0).getAvg();
		int pos = 0;
		for(int i=0; i<list.size(); i++) {
			RainDropData data = list.get(i);
			if(min < data.getAvg()) {
				min = data.getAvg();
				pos = i;
			}
		} return pos;
	}
	
	// 메소드 3
	public void output() {
		for(RainDropData data : list) {
			data.display();
		}
		RainDropData data1 = list.get(getMaxPos());
		data1.display();
		RainDropData data2 = list.get(getMinPos());
		data2.display();
	}
}
