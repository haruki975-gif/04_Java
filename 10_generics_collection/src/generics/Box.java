package generics;

// Box<T> -> <> : 다이아몬드 연산자
public class Box<T> {
	/* 제네릭스(Generics)
	 * - 뜻 : 일반적인, 속(속해있다)
	 * - 자바에서 뜻 : 데이터 타입을 일반화한다
	 *   -> 지정된 타입 하나로 변경(맞춤)
	 * 
	 * - 사용 이유
	 * 1) 타입 안정성 보장(컴파일 단계에서 강력한 타입 검증)
	 * 2) 타입 체크, 형변환 코드 생략 가능(코드 길이 감소)
	 * 3) 코드 재사용성 증가
	 * 
	 * 
	 * - 주요 파라미터(매개 변수) 타입 관례
	 * T : Type (아무 타입이나 작성)
	 * E : Element (아무 객체 == Object)
	 * K : Key
	 * V : Value
	 * N : Number
	 * -> 이거 아니어도 마음대로 써도 됨
	 */
	
	private T value; // 객체 생성 시점에 작성된 자료형으로 지정
	
	// setter
	public void setValue(T value) {
		this.value = value;
	}
	
	// getter
	public T getValue() {
		return value;
	}
}