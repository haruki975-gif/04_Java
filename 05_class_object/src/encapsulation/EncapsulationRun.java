package encapsulation;

public class EncapsulationRun {
	public static void main(String[] args) {
		
		// Person 객체 생성
		Person person1 = new Person();
		// person1.name = "박무현";
		// person1.height = 175;
		person1.setName("박무현");
		person1.setHeight(175);
		
		Person person2 = new Person();
		// person2.name = "이금이";
		// person2.height = -162;
		person2.setName("이금이");
		person2.setHeight(-162);
		
		// 캡슐화 안 했을 때 문제점 (1)
		// -> 잘못된 데이터가 대입될 수 있다
		
		System.out.println("person1의 " + person1.getInfo());
		System.out.println("person2의 " + person2.getInfo());
		
	}
}
