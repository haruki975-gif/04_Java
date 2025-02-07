package list.service;

import java.util.ArrayList;
import java.util.List;

import list.dto.BookDTO;

/**
 *  도서 관리 프로그램 기능 제공 클래스 
 */
public class BookService {

	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	// 기본 생성자
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다", "한강", 15000, "창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800, "포레스트북스"));
		bookList.add(new BookDTO("채식주의자", "한강", 15000, "창비"));
		bookList.add(new BookDTO("작별하지 않는다", "한강", 16800, "문학동네"));
		bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
	}

	// getter : 외부에서 현재 객체의 필드를 얻어갈 수 있게 반환시켜줌
	public List<BookDTO> getBookList() {
		return bookList;
	}
	
	
	/** 전달 받은 index 번째 bookList 요소 반환
	 *  단, 범위 초과 시 null 반환
	 * @param index
	 * @return BookDTO 참조 주소 또는 null(=참조하는게 없다)
	 */
	public BookDTO selectIndex(int index) {
		// 범위 초과 검사 -> 초과 시
		if(checkIndex(index) == false) return null;
		
		return bookList.get(index);
	}
	
	
	/**
	 * 전달 받은 index가 정상 범위인지 확인
	 * @param index
	 * @return 정상이면 true, 아니면 false 반환
	 */
	public boolean checkIndex(int index) {
		// 범위 초과 시 false
		if(index < 0 || index >= bookList.size()) {
			return false;
		}
		return true; // 정상 범위 true
	}
	
	
	/** 전달 받은 book을 bookList에 추가
	 *  단, 책 정보가 모두 일치하는 책이 있다면 추가 X 
	 * @param book
	 * @return 추가O : true, 추가X : false
	 */
	public boolean addBook(BookDTO book) {
		
		// 책 정보 비교 방법 1) 필드 값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용
//		for(BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		// BookDTO의 equals()를 오버라이딩 했기 때문에
		// List가 제공하는 contains() (포함하는지 확인) 사용 가능
		if(bookList.contains(book)) return false;
		
		return bookList.add(book); // 컬렉션은 크기 제한이 없어서 무조건 추가 성공(true 반환)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
