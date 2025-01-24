package abstraction;

public class ConstructorRun {
	public static void main(String[] args) {
		
		Student std1 = new Student(); // student 기본 생성자를 이용해 객체 생성
				
		System.out.println(std1.toString());
		
		System.out.println("--------------------------------");
		
		// Student(String, String) 매개 변수가 있는 생성자 이용
		Student std2 = new Student("20250004", "박무현");
		System.out.println(std2.toString()); // 학번, 이름 세팅 확인
		
		
		System.out.println("--------------------------------");
		
		// Student 객체의 필드를 모두 초기화하는 생성자 이용
		Student std3 = new Student("20250125", "신해량", 80, 75, 69, 100);
		System.out.println(std3.toString());
		
		Student std4 = new Student("20251212", "백애영", 75, 100, 53, 20);
		System.out.println(std4.toString());
	}
}
