package section01;

import section01.OuterClass1.instanceInnerClass;

public class Main1 {
	public static void main(String[] args) {
		// 외부 클래스의 인스턴스(객체) 생성
		OuterClass1 outer = new OuterClass1();
		
		// 외부 클래스내에 존재하는 내부 클래스 인서턴스 생성
		OuterClass1.instanceInnerClass inner = outer.new instanceInnerClass();
		inner.display();
		
		System.out.println("------------------------------------------");
		// 외부 클래스의 메서드 호출
		// -> 메서드가 내부 클래스 객체 생성
		outer.displayMessage();
	}
}
