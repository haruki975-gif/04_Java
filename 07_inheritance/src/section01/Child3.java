package section01;

public class Child3 extends Parent {

//	private String lastName = "신"; // 성
//	private String firstName = "재희"; // 이름
//	private String address = "충북 청주시";
//	private int money = 9000;
	
	private double bitCoin;
	
	public Child3() {
		System.out.println("*** Child3 객체 생성됨 ***");
		
		setFirstName("재희");
		
		// protected String firstName;
		// -> 상속 받은 자식 객체가 부모의 필드에 직접 접근 가능
		firstName = "무현";
		
		setAddress("충북 청주시");
//		address = "직접 접근 안됩니다";
		
		setMoney(9000);
		bitCoin = 0.1;
	}

	public double getBitCoin() {
		return bitCoin;
	}

	public void setBitCoin(double bitCoin) {
		this.bitCoin = bitCoin;
	}
	
	
	
	
}
