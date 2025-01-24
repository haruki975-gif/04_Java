package abstraction;

public class AbstractionRun {

	public static void main(String[] args) {
		
		// 객체 생성 : 
		// - 클래스에 정의된 내용대로 Heap 메모리 영역에 할당(객체 생성)
		
		Student std = new Student();
		
		// std 참조형 변수가 참조하는 객체의 필드값 세팅
		std.setStudentNumber("20250101");
		std.setName("에이스");
		std.setHtml(100);
		std.setCss(100);
		std.setJs(50);
		std.setJava(25);
		
		// 성적 합계
		System.out.println(std.getName() + "의 점수 합계 : " + std.getSum());
		
		// std가 참조하는 객체의 모든 필드 + 합계, 평균 출력
		String result = std.toString();
		System.out.println(result);
		
//		[결과]
//		에이스의 점수 합계 : 275
//		[20250101] 에이스
//		HTML : 100 / CSS : 100 / JS : 50 / Java : 25
//		합계 : 275
//		평균 : 68.75
		
		System.out.println("----------------------------------------");
		
		Student std2 = new Student();
		std2.setStudentNumber("20230502");
		std2.setName("듀스");
		std2.setHtml(78);
		std2.setCss(40);
		std2.setJs(79);
		std2.setJava(90);
		
		System.out.println(std2.getName() + "의 점수 합계 : " + std2.getSum());
		
		String result2 = std2.toString();
		System.out.println(result2);
		
		System.out.println("----------------------------------------");
		
		Student std3 = new Student();
		std3.setStudentNumber("19950619");
		std3.setName("마르코");
		std3.setHtml(50);
		std3.setCss(70);
		std3.setJs(60);
		std3.setJava(100);
		
		System.out.println(std3.getName() + "의 점수 합계 : " + std3.getSum());
		
		String result3 = std3.toString();
		System.out.println(result3);
		
		
	}
}
