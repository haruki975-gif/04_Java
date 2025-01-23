package loop.practice;

import java.util.Scanner;


/**
 * 기능 제공용 클래스
 */
public class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 1번)
	 * 
	 * 	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
			단, 입력한 수는 1보다 크거나 같아야 합니다.
			만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력
	 */
	public void practice1() {
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >= 1) {
			
			for(int i=1 ; i<=num ; i++) {
				System.out.print(i + " ");
			}
			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		
	}
	
	
	/**
	 * 2번)
	 * 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		 단, 입력한 수는 1보다 크거나 같아야 합니다.
	 */
	public void practice2() {
		
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >= 1) {
			
			for(int i=num ; i>0 ; i--) {
				System.out.print((i) + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
			return;
		}
	}
	
	
	/**
	 * 3번)
	 * 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
	 */
	public void practice3() {
		
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		String plus;
		
		for(int i=1 ; i<=num ; i++) {
			sum += i;
			
			if(i == num) {
				plus = " = ";
			} else {
				plus = " + ";
			}
			System.out.print(i + plus);
		}
		System.out.println(sum);
	}
	
	
	/**
	 * 4번)
	 * 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요
	 */
	public void practice4() {
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
			return;
		}
		
		if(num1 <= num2) { // num1이 num2보다 작다면

			for(int i=num1 ; i<=num2 ; i++) {
				System.out.print(i + " ");
			}
		} else {
			
			for(int i=num2 ; i<=num1 ; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	
	/**
	 * 5번)
	 * 사용자로부터 입력 받은 숫자의 단을 출력하세요
	 */
	public void practice5() {
		
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		// 단
		System.out.printf("\n===== %d단 =====\n", dan);
		
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		}
	}
	
	
	/**
	 * 6번)
	 * 사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
		 단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요.
	 */
	public void practice6() {
		
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		if(dan < 2 || dan > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요");
			return;
		}
		
		for(int i=dan ; i<=9 ; i++) {

			System.out.printf("\n===== %d단 =====\n", i);
			
			for(int num=1; num<=9 ; num++) {
				
				System.out.printf("%d * %d = %d\n", i, num, i*num);
				
			}
		}
	}
	
	
	/**
	 * 7번)
	 * 다음과 같은 실행 예제를 구현하세요
	 *
			정수 입력 : 4
			*
			**
			***
			****
	 */
	public void practice7() {
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int row=1 ; row<=num ; row++) { // row
			
			for(int i=1 ; i<=row ; i++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * 8번)
	 * 다음과 같은 실행 예제를 구현하세요
	 * 
	 * 정수 입력 : 4
		 ****
		 ***
		 **
		 *
	 */
	public void practice8() {
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int row=num ; row>0 ; row--) {
			
			for(int i=0 ; i<row ; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	
	/**
	 * 9번)
	 * 정수 입력 : 4
			 *
			**
		 ***
		****
	 */
	public void practice9() {
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for (int row=1; row<=num; row++) {
      
      for (int j=1; j <= num-row; j++) {
          System.out.print(" ");
      }
      
      for (int i=1; i<=row; i++) {
          System.out.print("*");
      }
      System.out.println();
		}
	}
	
	
	/**
	 * 10번)
	 * 정수 입력 : 4
		   *
			 **
			 ***
			 **
			 *
	 */
	public void practice10() {
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int row=1 ; row<=num ; row++) { // row
			
			for(int i=1 ; i<=row ; i++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	
	/**
	 * 11번)
	 * 
	 * 정수 입력 : 4
				 *
				***
			 *****
			*******
	 */
	public void practice11() {
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		

		for(int row=1; row<=input; row++) {
			
			// 앞쪽 공백 추가 방법 1			
			for(int blank=1; blank <= input-row; blank++) { // 3 2 1 0
				System.out.print(" ");
			}
			
			for(int col=1; col <= 2 * row-1; col++) {
				System.out.print("*");
			}
			
			System.out.println(""); // 줄바꿈
		}

		
		System.out.println("-----------------------------");
		
		for(int row=1; row<=input; row++) {
			
			for(int col=1; col<= 2 * input-1; col++) {
				
				// 앞쪽 공백 추가 방법 2
				//      뒤 깎기              앞 깎기
				if(input-row >= col || input+row <= col) {
					System.out.print(" ");
				} else {
					System.out.print("*");					
				}
			}
			
			System.out.println(""); // 줄바꿈
		}
		
	}
	
	
	/**
	 * 12번)
	 * 
	 * 정수 입력 : 5
			*****
			*   *
			*   *
			*   *
			*****
			첫번째 행/열, 마지막 행/열만 남기기
	 */
	public void practice12() {
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int row=1; row<=input; row++) {
			
			for(int col=1; col<=input; col++) {
				
				// 첫번째/마지막 행/열만 * 출력
				if(row==1 || row==input || col==1 || col==input) {
					System.out.print("*");					
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(""); // 줄바꿈
		}
	}
	
	
	/**
	 * 13번)
	 * 
	 * 1부터 사용자에게 입력 받은 수까지 중에서
		 1) 2와 3의 배수를 모두 출력하고
		 2) 2와 3의 공배수의 개수를 출력하세요.
		 * ‘공배수’는 둘 이상의 수의 공통인 배수라는 뜻으로 어떤 수를 해당 수들로 나눴을 때
		    모두 나머지가 0이 나오는 수
	 */
	public void practice13() {
		
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int count = 0; // 카운트
		
		for(int i=1 ; i<=num ; i++) {
			
			if(i % 2 == 0 || i % 3 == 0) { // 2와 3의 공배수
				count ++;
				System.out.print(i + " ");
			}
			
		}
		System.out.println();
		System.out.println("count : " + count);
	}
	
	
	/**
	 * 14번)
	 * 사용자로부터 입력 받은 하나의 값이 소수인지 판별하는 프로그램을 구현하세요.
		 단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
		 * ‘소수’는 n을 1부터 n까지로 나누었을 때 나누어 떨어지는 수가 1과 n뿐인 수를 말한다.
		 ex) 2, 3, 5, 7, 11 …
	 */
	public void practice14() {
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num < 2) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		
		// 소수
		boolean isPrime = true;
		
		for(int i=2 ; i<=num/2 ; i++) {
			
			if(num % i == 0) { // 나누어 떨어지면 소수 X
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			System.out.println("소수입니다");			
		} else {
			System.out.println("소수가 아닙니다");
		}
	}
	
	
	/**
	 * 15번)
	 * 위 문제와 모든 것이 동일하나, 입력한 수가 2보다 작은 경우
		 “잘못 입력하셨습니다.”를 출력하면서 다시 사용자가 값을 입력하도록 하세요.
	 */
	public void practice15() {
		
		
	}
	
	
	
	
	/**
	 * 16번)
	 * 2부터 사용자가 입력한 수까지의 소수를 모두 출력하고 소수의 개수를 출력하세요.
     단, 입력한 수가 2보다 작은 경우 “잘못 입력하셨습니다.”를 출력하세요.
	 */
	public void practice16() {
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num < 2) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		
		int count = 0; // 소수 개수 세는 변수
		
		// 2부터 입력 받은 수까지 1개씩 접근하는 for문
		for(int i=2; i<=num; i++) {
			
			boolean flag = true; // 깃발(신호 용도)
			// true인 경우  : 소수 O
			// false인 경우 : 소수 X
			
			// 1과 자기자신(num)을 뺀 정수를 한개씩 접근(=x)
			for(int x=2; x<i; x++) {
				
				// 
				if(i % x == 0) { // 1, 자기 자신 빼고 나누어 떨어지는 수 존재
					flag = false;
					break;
				}
			}
			
			if(flag) { // 소수라고 판별된 경우 수행(true)
				System.out.print(i + " ");
				count++;
			}
		}
		
		System.out.println();
		System.out.printf("2부터 %d까지 소수의 개수는 %d개입니다", num, count);
	}


}
