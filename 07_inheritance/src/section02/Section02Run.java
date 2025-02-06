package section02;

public class Section02Run {
	public static void main(String[] args) {
		
		// 학생 객체 생성 1 -> 기본 생성자
		Student s1 = new Student();
		
		// 학생 객체 생성 2 -> 매개 변수 있는 생성자
		Student s2 = new Student("신해량", 27, "종로 고등학교");
		System.out.println(s2.toString());
		
		
		// Object 상속 확인
		// s2.equals(s2)
		
		System.out.println("-------------------------------------");
		/* 오버라이딩 테스트 */
		Person p3 = new Person("신해량", 28);
		System.out.println(p3);
		System.out.println(p3.introduce("엔지니어 가팀"));
		// System.out.println(p3.toString());

		
		System.out.println("-------------------------------------");
		Student s3 = new Student("서지혁", 26, "엔지니어 가팀");
		System.out.println(s3);
		System.out.println(s3.introduce("경호원"));
		
		/* [참고]
		 * print 관련 메서드 또는 문자열 + 연결 시
		 * 참조 변수명만 작성하면 자동으로 toString() 호출된다!!
		 * (컴파일러가 자동으로 .toString() 추가)
		 */
	}
}
