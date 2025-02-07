package generics;

// 객체 생성 시 지정되는 타입 T는
// Parent 또는 Parent 상속 관계인 타입만 가능!!
public class TestBox<T extends Parent> {
	
	private T obj;

	// getter
	public T getObj() {
		return obj;
	}

	// setter
	public void setObj(T obj) {
		this.obj = obj;
	}
}