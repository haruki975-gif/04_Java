package section01.service;

import java.util.Scanner;

public class TryCatchService {
	
	 private Scanner sc = new Scanner(System.in);

	/* Exception(예외) : 코드로 해결 가능한 에러(if, try-catch, throws)
	 * Exception Handling(예외 처리) : 발생된 예외를 처리하는 구문(try-catch, throws)
	 */
	
	/** try-catch 작성법
	 * <pre>
	 * try { 예외가 발생할 것 같은 구문 }
	 * - 예외가 발생할 가능성이 있는 코드를 시도하는 구문({}블럭)
	 *  
	 * catch(예외 참조 변수){}
	 * - try에서 던져진 예외를 () 예외 참조 변수가 잡아서 처리하는 구문
	 *   -> 잡아서 처리하면 예외가 사라짐
	 *   -> 프로그램이 종료되지 않고 계속 정상수행!
	 * </pre>
	 */
	public void test1() {
		
		System.out.println("입력 받은 두 정수를 나눈 몫 계산하기_v1");
		
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		try {
			System.out.println("몫 : " + num1/num2);
			// ArithmeticException: / by zero
			// -> 산술적 예외 : 0으로 나눌 수 없습니다
			// + 예외 발생 시 프로그램 비정상 종료!!
			
		} catch(ArithmeticException e) {
			// try에서 ArithmeticException 객체가 던져지면
			// 매개변수 e를 이용해서 잡음
			// -> 잡아서 처리 -> 예외가 사라짐 -> 프로그램 정상 운영
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		System.out.println("--- 프로그램 종료 ---");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
