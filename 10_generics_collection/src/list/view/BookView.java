package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**
 *  도서 관리 프로그램 입/출력 담당 클래스(UI: 사용자와 프로그램의 접점)
 */
public class BookView {
	
	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();
	
	
	/**
	 * 프로그램 메인 메뉴
	 */
	public void displayMenu() {
		int input = 0; // 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기(index)");
			
			// 추가 메뉴
			System.out.println("6. 제목이 일치하는 책 1권 조회");
			System.out.println("7. 제목이 일치하는 책 제거하기");
			
			System.out.println("8. 출판사가 일치하는 책 모두 조회하기");
			System.out.println("9. 저자가 일치하는 책 모두 조회하기");
			System.out.println("10. 검색어가 제목,저자에 포함된 모든 책 조회하기");
			
			System.out.println("0. 종료");
			System.out.println(); // 줄바꿈
			
			System.out.print("메뉴 번호 입력 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거(오류 방지)
			System.out.println("------------------------------");
			
			switch(input) {
			case 1: selectAll(); break;
			case 2: selectIndex(); break;
			case 3: addBook(); break;
			case 4: modifyBookPrice2(); break;
			case 5: removeBook(); break;
			
			case 6: selectTitle(); break;
			case 7: removeBookTitle(); break;
			
			// 서비스 호출 시 반환된 결과가 List<BookDTO>
			case 8: selectPublisherAll(); break;
			case 9: selectAuthorAll(); break;
			case 10: searchBook(); break;
			
			case 0: System.out.println("*** 프로그램이 종료됩니다. ***"); break;
			default : System.out.println("@@@ 메뉴 번호 잘못 입력 @@@");
			}
			
		} while(input != 0);
	}


	/**
	 * 전체 조회
	 * - BookService의 필드 bookList를 얻어와 일반 for문을 이용하여 모든 요소 정보 출력
	 * - 단, bookList에 저장된 정보가 없으면 "저장된 책이 존재하지 않습니다." 출력
	 */
	private void selectAll() {
		System.out.println("\n ### 전체 조회 ### \n");
		
		List<BookDTO> list = service.getBookList();
		
		// 전달 받은 list에 데이터 여부 확인
		// int size() : 저장된 객체의 개수 반환
		// boolean isEmpty() : 저장된 객체가 없으면 true 반환
		// if(list.size() == 0) {
		if(list.isEmpty()) {
			System.out.println("저장된 책이 존재하지 않습니다.");
			return;
		}
		
		// 모든 요소 정보 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + ") " + list.get(i));
		}
	}

	
	/**
	 * 조회하려는 책의 index 번호를 입력 받아 책 정보 출력
	 * - BookService로부터 index번째 BookDTO 반환 받기
	 * - 단, index 번호가 bookList의 범위를 초과하면 "해당 인덱스에 책이 존재하지 않습니다." 출력
	 */
	private void selectIndex() {
		System.out.println("\n ### index 번호로 조회 ### \n");
		System.out.print("조회할 책 index 번호 입력 : ");
		int index = sc.nextInt();
		
		BookDTO book = service.selectIndex(index);
		System.out.println("------------------------------------");
		
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("가격 : " + book.getPrice());
		System.out.println("출판사 : " + book.getPublisher());
	}
	
	
	/** 책 정보(제목, 저자, 가격, 출판사)를 입력 받아
	 * 	- BookService의 bookList에 마지막 요소로 추가
	 * 	- 단, 모든 정보가 일치하는 책은 추가 x (중복 저장 X)
	 */
	public void addBook() {
		System.out.println("\n ### 책 추가하기 ### \n");
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		// 엔터가 입력되기 전까지의 문자열 얻어오기 (띄어쓰기 포함)
		
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 남은 문자열 제거
		// -> sc.next(); / sc.nextInt() 등을 수행 후 무조건 작성
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		
		// 서비스 호출
		boolean result = service.addBook(new BookDTO(title, author, price, publisher));
		
		if(result) { // 추가 성공
			System.out.println(title + " 책이 추가되었습니다.");
		} else { // 추가 실패
			System.out.println(title + " 책이 이미 존재합니다.");
		}
	}
	
	
	/** 인덱스 번호를 입력 받아
	 *  - 해당 인덱스에 책이 없다면 "해당 인덱스에 책이 존재하지 않습니다."
	 *  
	 *  - 해당 인덱스에 책이 있다면
	 *  1) "수정할 가격 입력 : "
	 *  2) 스캐너로 가격 입력 받기
	 *  3) 입력 받은 index 번째 요소의 가격 수정
	 *  4) "[책 제목] 가격이 [이전 가격] -> [수정된 가격]으로 수정되었습니다." 출력
	 * 
	 */
	public void modifyBookPrice() {
		System.out.println("\n ### 책 가격 수정하기 ### \n");
		
		// 인덱스 번호 입력 받기
		System.out.print("수정할 인덱스 번호 : ");
		int index = sc.nextInt();
		
		// 인덱스 번호 조회(없으면 null)
		BookDTO target = service.selectIndex(index);
		
		// 입력한 인덱스에 책이 없다면
		if(target == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
		}
		
		// 책이 있다면 수정할 가격 입력 받기
		System.out.print("수정할 가격 입력 : ");
		int newPrice = sc.nextInt(); // 새로운 가격
		int oldPrice = target.getPrice(); // 이전 가격 얻어와서 oldPrice에 저장
		target.setPrice(newPrice); // 새 가격으로 변경
		
		System.out.printf("[%s] 가격이 [%d] -> [%d]으로 수정되었습니다.", target.getTitle(), oldPrice, newPrice);
	}
	
	/* 다른 풀이 방법 */
	public void modifyBookPrice2() {
		System.out.println("\n ### 책 가격 수정하기 ### \n");
		
		// 인덱스 번호 입력 받기
		System.out.print("수정할 인덱스 번호 : ");
		int index = sc.nextInt();
		
		// index 범위 초과 시
		if(service.checkIndex(index) == false) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
		}
		
		// 책이 있다면 수정할 가격 입력 받기
		System.out.print("수정할 가격 입력 : ");
		int newPrice = sc.nextInt(); // 새로운 가격
		
		// 서비스 호출
		System.out.println(service.modifyBookPrice2(index, newPrice));
	}
	
	
	/** index 번호를 입력 받아 책 제거
	 *  단, 해당 index에 책이 없으면 "해당 인덱스에 책이 존재하지 않습니다." 출력
	 *  있으면 "[책 제목] 책이 제거되었습니다." 출력
	 */
	public void removeBook() {
		System.out.println("\n ### 책 제거하기(index) ### \n");
		
		// 제거할 인덱스 번호 입력
		System.out.print("제거할 책 인덱스 번호 : ");
		int index = sc.nextInt();
		
		
		// 서비스 호출
		BookDTO target = service.removeBook(index);
		if(target == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		} else {
			System.out.printf("[%s] 책이 제거되었습니다.", target.getTitle());
		}
	}
	
	
	/** 제목이 일치하는 책 정보 출력
	 * 	단, 제목이 일치하는 책이 없다면 "검색 결과 없음" 출력
	 * 
	 */
	private void selectTitle() {
		System.out.println("\n ### 제목이 일치하는 책 조회하기 ### \n");
		
		// 조회할 책제목 입력
		System.out.print("조회할 책 제목 입력 : ");
		String title = sc.nextLine();
		
		// 서비스 호출
		BookDTO target = service.selectTitle(title);
		
		if(target == null) {
			System.out.println("검색 결과 없음.");
		} else {
			System.out.println("---------------------------------");
			System.out.println("제목 : " + target.getTitle());
			System.out.println("저자 : " + target.getAuthor());
			System.out.println("가격 : " + target.getPrice());
			System.out.println("출판사 : " + target.getPublisher());
		}
	}
	
	
	/** 제목이 일치하는 책 제거하기
	 *  단, 제목이 일치하는 책이 없다면 "검색 결과 없음" 출력
	 */
	private void removeBookTitle() {
		System.out.println("\n ### 제목이 일치하는 책 조회하기 ### \n");
		
		// 조회할 책제목 입력
		System.out.print("제거할 책 제목 입력 : ");
		String title = sc.nextLine();
		
		// 서비스 호출
		boolean result = service.removeBookTitle(title);
		
		if(result) { // true인 경우 삭제
			System.out.printf("[%s]책이 제거되었습니다.", title);
		} else {
			System.out.println("검색 결과 없음.");
			return;
		}
	}
	
	
	/** 출판사가 일치하는 책 모두 조회하기
	 *  단, 출판사가 일치하는 책이 없다면 "검색 결과 없음" 출력
	 */
	private void selectPublisherAll() {
		System.out.println("\n ### 출판사가 일치하는 책 조회하기 ### \n");

		// 조회할 출판사 입력
		System.out.print("출판사 입력 : ");
		String publisher = sc.nextLine();
		
		// 서비스 호출 (결과 개수 : 0 ~ n)
		List<BookDTO> list = service.selectPublisherAll(publisher);
		
		// 조회 결과가 없을 경우
		//if(list.size()==0) {
		if(list.isEmpty()) { // list에 저장된 객체가 없을 경우
			System.out.println("검색 결과 없음.");
			return;
		}
		
		for(BookDTO book : list) { // 있으면 다 출력
			System.out.println(book);
		}
	}
	
	
	/** 저자가 일치하는 책 모두 조회하기
	 *  단, 저자가 일치하는 책이 없다면 "검색 결과 없음" 출력
	 */
	private void selectAuthorAll() {
		System.out.println("\n ### 저자가 일치하는 책 조회하기 ### \n");
		
		// 저자 입력
		System.out.print("저자 입력 : ");
		String author = sc.nextLine();
		
		// 서비스 호출
		List<BookDTO> list = service.selectAuthorAll(author);
		
		if(list.size()==0) {
			System.out.println("검색 결과 없음.");
			return;
		}
		
		for(BookDTO book : list) { // 있으면 다 출력
			System.out.println(book);
		}
	}
	
	
	/** 검색어가 제목,저자에 포함된 모든 책 조회하기
	 *  단, 일치하는 책이 없다면 "검색 결과 없음" 출력
	 */
	private void searchBook() {
		System.out.println("\n ### 제목,저자가 일치하는 책 조회하기 ### \n");
		
		// 검색어 입력
		System.out.print("검색어 입력 : ");
		String search = sc.nextLine();
		
		// 서비스 호출
		List<BookDTO> searchList = service.searchBook(search);
		
		if(searchList.size()==0) {
			System.out.println("검색 결과 없음.");
			return;
		}
		
		for(BookDTO book : searchList) { // 있으면 다 출력
			System.out.println(book);
		}
	}
}
