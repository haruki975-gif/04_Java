package section02;

public class Person {

	private String name;
	private int age;
	
	// 기본 생성자
	public Person() {
		System.out.println("[Person 기본 생성자로 생성됨]");
	}
	
	// 매개 변수 생성자 자동 생성 : alt + shift + s -> o
	public Person(String name, int age) {
		System.out.println("[Person 매개 변수 있는 생성자로 생성됨]");
		
		this.name = name;
		this.age = age;
	}

	// getter/setter 자동 생성 : alt + shift + s -> r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// toString()
	public String toString() {
		return String.format("name : %s / age : %d", name, age);
	}
	
	
	
}
