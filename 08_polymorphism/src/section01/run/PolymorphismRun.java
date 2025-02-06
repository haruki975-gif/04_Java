package section01.run;

import section01.service.PolymorphismService;

public class PolymorphismRun {
	public static void main(String[] args) {
		
		PolymorphismService service = new PolymorphismService();
		// service.test1();
		// service.test2(); // Child, Parent, Object 순으로 출력
		// service.test3();
		// service.test4();
		service.test5();
		
		// 실행   : ctrl + F11
		// 디버그 : F11
	}
}
