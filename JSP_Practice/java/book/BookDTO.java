package book;

public class BookDTO {
	// 1. 변수설정
	private int id;
	private String title;
	private String author;
	private int price;
	private int qty;
	
	// 2. getter, setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	// 3. 디폴트 생성자
	public BookDTO() {
		super();
	}
	
	// 4. 매개변수가 있는 생성자 (id는 저절로 입력되니 추가하지 않음)
	public BookDTO(String title, String author, int price, int qty) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	
	// 5. toString 오버라이드
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", author="
				+ author + ", price=" + price + ", qty=" + qty + "]";
	}
}
