package set.dto;

import java.util.Objects;

public class Person {

	// [필드(멤버 변수)] - 인스턴스 변수, 클래스 변수 작성 가능
	private String name; // 인스턴스 변수
	private int age;
	private char gender;
	// public static int nationalCode; // 클래스 변수
	
	// [생성자]
	public Person() {}
	
	// 매개 변수가 있는 생성자 (오버로딩, 매개 변수만 다르면 됨)
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// getter/setter
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	
	// toString()
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	
	// equals(), hashCode() 오버라이딩 예정
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}
	
	
	
	
	
}
