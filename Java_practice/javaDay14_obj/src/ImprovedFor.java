
class Book {
	String title = "";
	String author = "";
	String publish = "";
	
	//override : 컨트롤 + 스페이스
	@Override
	public String toString() {
		return title + "" + author + publish;
	}

	public Book(String title, String author, String publish) {
		super();
		this.title = title;
		this.author = author;
		this.publish = publish;
	}
}

public class ImprovedFor {
	// 향상된 for문, 개선된 for문
	// But, 단점
	// 1. 인덱스 사용 불가
	// 2. 배열이나 ArrayList값을 사용할 수는 있지만 수정은 불가
	public static void main(String[] args) {

		String[] words = new String[] {"java", "C++", "파이썬", "pl/1", "ALGOL"};
		// 배열로부터 데이터를 하나씩 자동으로 읽어와서 앞 변수에 넣어준다
		for(String w : words) {
			System.out.println(w);}
		
		System.out.println("********************************");
		
		Book[] books = new Book[] {
				new Book("A", " A", " A"),
				new Book("B", " B", " B"),
				new Book("C", " C", " C")
		};
		
		for(Book b : books) {
			System.out.println(b);		// toString override
		}
		
		System.out.println("*********얕은 복사***********");
		Book[] books2 = books;
		books[0] = new Book("change"," change"," change");
		
		// 얕은복사는 메모리를 공유하기 때문에 같이 바뀜
		for(Book b1 : books) {
			System.out.println(b1);
		}
		for(Book b1 : books2)
			System.out.println(b1);
		
		System.out.println("*********깊은 복사***********");
		Book[] books3 = books.clone();	// 깊은복사 : clone(); (간혹 안될때도 있다)
		books[0] = new Book("깊은복사", " 깊은복사", " 깊은복사");
		
		// 깊은 복사는 메모리를 각 메모리를 갖음
		for(Book b2 : books) {
			System.out.println(b2);
		}
		for(Book b2 : books3) {
			System.out.println(b2);
		}
	}
}
		
