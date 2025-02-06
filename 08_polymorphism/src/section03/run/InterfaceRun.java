package section03.run;

import section03.dto.Calculator;
import section03.dto.LEBCalculator;
import section03.dto.LEBCalculator2;

public class InterfaceRun {

	public static void main(String[] args) {
		
		// 인터페이스를 부모 타입 참조 변수로 하여
		// Calculator 구현체 생성하기
		// (업캐스팅 + 동적 바인딩)
		
//		Calculator calc = new LEBCalculator();
		
		/* 같은 Calculator 인터페이스를 상속 받은 다른 객체 생성
		 * -> Calculator가 제공하는 같은 이름의 메서드가 존재
		 * -> 다른 코드 수정 없이 객체 생성 부분만 수정해도
		 *    새 객체의 기능을 모두 호출 가능
		 *    -> 유지 보수성 향상!
		 */
		Calculator calc = new LEBCalculator2();
		
		System.out.println( calc.plus(1000000000, 1234));
		System.out.println( calc.minus(1000000, 555222));
		System.out.println( calc.multi(-1255534, 555999222));
		System.out.println( calc.div(100, 55));
		System.out.println( calc.mod(4554, 1225));
		System.out.println( calc.pow(2, 61));
		System.out.println( calc.areaOfCircle(15.3));
	}
}
