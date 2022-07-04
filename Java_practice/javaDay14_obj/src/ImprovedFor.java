
class Book {
	String title = "";
	String author = "";
	String publish = "";
	
	//override : ��Ʈ�� + �����̽�
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
	// ���� for��, ������ for��
	// But, ����
	// 1. �ε��� ��� �Ұ�
	// 2. �迭�̳� ArrayList���� ����� ���� ������ ������ �Ұ�
	public static void main(String[] args) {

		String[] words = new String[] {"java", "C++", "���̽�", "pl/1", "ALGOL"};
		// �迭�κ��� �����͸� �ϳ��� �ڵ����� �о�ͼ� �� ������ �־��ش�
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
		
		System.out.println("*********���� ����***********");
		Book[] books2 = books;
		books[0] = new Book("change"," change"," change");
		
		// ��������� �޸𸮸� �����ϱ� ������ ���� �ٲ�
		for(Book b1 : books) {
			System.out.println(b1);
		}
		for(Book b1 : books2)
			System.out.println(b1);
		
		System.out.println("*********���� ����***********");
		Book[] books3 = books.clone();	// �������� : clone(); (��Ȥ �ȵɶ��� �ִ�)
		books[0] = new Book("��������", " ��������", " ��������");
		
		// ���� ����� �޸𸮸� �� �޸𸮸� ����
		for(Book b2 : books) {
			System.out.println(b2);
		}
		for(Book b2 : books3) {
			System.out.println(b2);
		}
	}
}
		
