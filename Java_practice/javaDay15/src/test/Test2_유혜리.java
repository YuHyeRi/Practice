package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class BookData
{
	private String title="";
	private String author="";
	private int price=10000;
	private int count=0;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//생성자
	 public BookData(String title, String author, int price, int count) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.count = count;
		}
	
	//toString overriding 
	@Override
	public String toString() {
		String s = String.format("%s %s %d %d", title, author, price, count);
		return super.toString();
	}
	
	//equals 오버라이딩 
	@Override
	public boolean equals(Object obj) {
		BookData s = (BookData)obj;	
		return title.equals(s.title);	
	}
	
	@Override
	public int hashCode() {
		return title.hashCode();
	}
}

class BookManager
{
	List<BookData> list = new ArrayList<BookData>();
	
	public BookManager()
	{
		list.add(new BookData("고수", "문정후", 10000, 20));
		list.add(new BookData("쌍갑포차", "배해수", 12000, 30));
		list.add(new BookData("아지갑놓고나왔다", "미역", 8000, 40));
		list.add(new BookData("경이로운소문", "장이", 12000, 200));
		list.add(new BookData("나빌레라", "지민", 20000, 20));
		list.add(new BookData("퀴퀴한일기", "이비", 30000, 20));
	}
	
	public List<BookData> getList() {
		return list;
	}
	
	public void output() {
		for(int i=0; i<list.size(); i++) {
			BookData data = list.get(i);
			System.out.printf("%s %s %d %d\n", 
					data.getTitle(), data.getAuthor(), data.getPrice(), data.getCount());
		}
	}
	
	int find(String key) {
		List<BookData> list = getList();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(key)) {
				return i;
			}
		} return -1;
	}
	
	public void search()
	{
//		BookData data = new BookData("쌍갑포차", "", 0,0);
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을 title : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("해당 title을 찾을 수 없습니다.");
			return;
		} System.out.println("찾았습니다!");
		BookData data = getList().get(pos);
		System.out.printf("%s %s %d %d\n",
				data.getTitle(), data.getAuthor(), data.getPrice(), data.getCount());
	} 
}


public class Test2_유혜리 {
	public static void main(String[] args) {
		BookManager mgr = new BookManager();
		mgr.output();
		mgr.search();
	}
}
