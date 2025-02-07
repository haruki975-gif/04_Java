package section01;

import java.util.Objects;

public class Book {
	private long bookNumber; // 책 번호
	private String title; 	 // 제목
	private String author; 	 // 저자
	private int price; 			 // 가격
	
	// 기본 생성자
	public Book() {
		super();
	}

	// 매개 변수 있는 생성자
	public Book(long bookNumber, String title, String author, int price) {
		super();
		this.bookNumber = bookNumber;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	// toString()
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	// getter/setter
	public long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
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
	
	
	/* equals() 오버라이딩 
	 * -> 비교하려는 두 객체의 필드 값이 비교(동등 비교)*/
	@Override
	public boolean equals(Object obj) {
		
		// 같은 객체를 참조하고 있는 경우(주소가 같은 경우)
		// -> 같은 객체 비교하는데 시간 낭비하지 말자
		if(this == obj) return true; // 무조건 같음 -> true
		
		// 비교 대상이 없는 경우 -> 무조건 false
		if(obj == null) return false;
		
		// 비교 대상이 같은 타입의 객체인지 확인
		// -> 다른 타입이면 비교조차 안 하겠다 -> false
		// if(!(obj instanceof Book)) return false;
		if(this.getClass() != obj.getClass()) return false;
		
		
		// 전달받은 매개 견수를 Book으로 다운캐스팅
		Book other = (Book)obj;
		
		// 현재 객체와 전달 받은 객체의 bookNumber가 다르면
		if(this.bookNumber != other.bookNumber) return false;

		// 현재 객체와 전달 받은 객체의 title이 다를 경우
		if(!this.title.equals(other.title)) return false;
		
		if(!this.author.equals(other.author)) return false;
		
		if(this.price != other.price) return false;
		
		// 위 if문이 하나도 실행되지 않을 경우
		return true;
	}
	
	
	
	// -----------------------------------------------
	
	/* hashCode() 오버라이딩
	 * - 동등한 객체는 같은 식별 번호를 가져야 한다!
	 * 
	 * - A.equals(B) -> true 이면
	 *   A.hashCode() == B.hashCode() -> true 이다
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(bookNumber, title, author, price); // 2049242871
		
//		int result = 1;
//		final int PRIME = 31;
//		result *= (int)bookNumber * PRIME;
//		result *= title.hashCode() * PRIME;
//		result *= author.hashCode() * PRIME;
//		result *= price * PRIME;
//		
//		return result;
	}	
}
