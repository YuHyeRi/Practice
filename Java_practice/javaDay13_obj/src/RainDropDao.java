
import java.util.ArrayList;
import java.util.List;

public class RainDropDao {
	List<RainDropData> list = new ArrayList<RainDropData>();
	
	// ������
	public RainDropDao() {
		list.add(new RainDropData("����", new int[] {10,20,30,40,50,60}));
		list.add(new RainDropData("���", new int[] {15,15,30,20,50,40}));
		list.add(new RainDropData("�λ�", new int[] {10,10,30,30,50,30}));
		list.add(new RainDropData("����", new int[] {18,20,15,40,40,50}));
	}
	
	// �޼ҵ� 1
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
	
	// �޼ҵ� 2
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
	
	// �޼ҵ� 3
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
