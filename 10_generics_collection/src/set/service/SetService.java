package set.service;

import java.util.HashSet;
import java.util.Set;

import set.dto.Person;

public class SetService {

	
	/* Set(집합)
	 * - 기본적으로 순서 유지 X
	 * - 중복 데이터(객체) 저장 X
	 * 	 -> 중복된 객체가 들어오면 덮어쓰기
	 *   -> *중요* equals(), hashCode() 오버라이딩 필수
	 *   		(동등 비교를 하기 위해서)
	 * 
	 * Set 인터페이스를 구현한 구현체
	 * 1. HashSet : 처리 속도가 빠른 Set (제일 많이 사용)
	 * 2. LinkedHashSet : 순서를 유지하는 Set
	 * 3. TreeSet : 자동 정렬을 지원하는 Set
	 */
	
	/**
	 * Set/HashSet 기본 사용법
	 */
	public void test1() {
		
		// HashSet 객체 생성
		//  인터페이스      구현체 (업캐스팅)
		Set<String> set = new HashSet<String>();
		
		// * String은 equals(), hashCode() 오버라이딩 된 상태
		
		/* boolean add(E e) : 요소 추가 */
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("토스");
		set.add("당근마켓");
		set.add("직방");
		set.add("야놀자");
		
		/* String toString() : 저장된 값을 문자열로 출력 */
		// -> 순서 유지 X
		System.out.println(set);
		
		/* 중복 허용 X 확인 */
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		System.out.println(set);
		
		/* null(참조X)도 중복 허용 X */
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println("null 중복 X : " + set);
		
		/* int size() : 저장된 객체의 개수를 반환 */
		System.out.println("set.size() : " + set.size()); // 10개
		
		/* List.remove(int index);
			 List.reomove(E e); */
		
		/* boolean remove(E e) : 동등한 객체를 찾아서 제거 
		 * -> equals(), hashCode() 오버라이딩 필수
		 */
		System.out.println("쿠팡 제거됨? " + set.remove("쿠팡"));
		System.out.println("삼성 제거됨? " + set.remove("삼성"));
		System.out.println(set); // 쿠팡 지워짐 O
		
		/* boolean contains(E e) : 동등 객체 포함 여부 확인 
		 * -> equals(), hashCode() 오버라이딩 필수
		 */
		System.out.println("네이버 있음? " + set.contains("네이버"));
		System.out.println("LG 있음? " + set.contains("LG"));
		
		/* boolean isEmpty() : 비어있으면 true, 아니면 false */
		/* void clear() : 저장된 값 모두 제거 */
		System.out.println("clear() 전 isEmpty() : " + set.isEmpty()); // F
		set.clear();
		System.out.println("clear() 후 isEmpty() : " + set.isEmpty()); // T
		System.out.println("set : " + set); // []
		
	}
	
	
	/**
	 * Hash 단어가 포함된 컬렉션
	 * 무조건 equals(), hashCode()가 오버라이딩 되어있어야 한다!
	 * 
	 * @@@ Object가 제공하는 메서드 오버라이딩 목적 @@@
	 * - equals() : 객체의 필드가 같은지 비교(동등 비교)
	 * - hashCode() : 객체의 식별번호
	 *                equals()가 true이면 hashCode()도 같아야 한다
	 *                -> 빠르게 찾기 위해 활용
	 */
	public void test2() {
		Person p1 = new Person("신해량", 28, '남');
		Person p2 = new Person("백애영", 25, '여');
		Person p3 = new Person("서지혁", 26, '남');
		Person p4 = new Person("서지혁", 26, '남'); // 중복 필드 객체 생성
		
		Set<Person> personSet = new HashSet<Person>();
		
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);

		/* Set의 특징 : 순서 유지 X, 중복 허용 X */
		for(Person p : personSet) {
			System.out.println(p);
		}
		
		// 1. equals() 오버라이딩 X, hashCode() 오버라이딩 X -> 중복 제거 안됨
		// 2. equals() 오버라이딩 O, hashCode() 오버라이딩 X -> 중복 제거 안됨
		// 3. equals() 오버라이딩 X, hashCode() 오버라이딩 O -> 순서 바뀜, 중복 제거 안됨
		// 4. equals() 오버라이딩 O, hashCode() 오버라이딩 O -> 중복 제거됨!!
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
