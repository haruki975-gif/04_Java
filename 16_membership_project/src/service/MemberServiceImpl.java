package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
    	
    	List<Member> memberList = dao.getMemberList();
    	
    	for(Member member : memberList) {
    		if (member.getPhone().equals(phone)) {
          System.out.println("### 중복되는 휴대폰 번호가 존재합니다 ###");
          return false; // 번호 중복
    		}
    	}
    	// 새로운 회원 추가
      dao.addMember(new Member(name, phone, 0, 0));
      
      return true;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
    	
    	// dao에서 반환 받은 memberList를 그대로 view로 리턴
      return dao.getMemberList();
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
    	
    	List<Member> searchList = dao.getMemberList();
    	List<Member> search = new ArrayList<Member>();
    	
    	
    	for(Member member : searchList) {
    		if(member.getName().equals(searchName)) {
    			search.add(member);
    		}
    	}

    	// 리스트가 비어 있으면 null 반환, 아니면 리스트 반환
      return search.isEmpty() ? null : search;
    }


    // 금액 누적
    @Override
    public String updateAmount(Member target, int acc) throws IOException {

    	// 금액
    	int oldAcc = target.getAmount(); // 업데이트 전
    	int newAcc = oldAcc + acc; // 업데이트 후(누적)
    	target.setAmount(newAcc); // 금액 업데이트
    	
    	// 등급
    	int grade; // 숫자
    	int oldGrade = target.getGrade(); // 업데이트 전
    	int newGrade; // 업데이트 후
    	
    	// 금액 범위에 따른 현재 등급 변경
//    	if(newAcc >= 0 && newAcc < 100_000) {
//    		newGrade = Member.COMMON;
//    		
//    	} else if(newAcc < 1_000_000) {
//    		newGrade = Member.GOLD;
//    		
//    	} else {
//    		newGrade = Member.DIAMOND;
//    	}
    	
    	// -> 위 IF문을 삼항연산자로 수정
    	newGrade = (newAcc < 100_100) ? Member.COMMON : (newAcc < 1_000_000) ? Member.GOLD : Member.DIAMOND;
    	
    	// 등급(숫자) 덮어쓰기
    	target.setGrade(newGrade);
    	
    	dao.saveFile(); // 파일 업데이트
    	
    	// 이전 등급과 현재 등급이 다를 경우
    	if(oldGrade != newGrade) {
    		String gradeText = (newGrade == Member.COMMON) ? "일반" : (newGrade == Member.GOLD) ? "골드" : "다이아";
    		
    		return String.format("%d -> %d\n"
    				+ "* %s * 등급으로 변경 되셨습니다", oldAcc, newAcc, gradeText);
    	}
    	
    	return String.format("%d -> %d", oldAcc, newAcc);
      
      //ex)
      // 2000 -> 100000
      // * 골드 * 등급으로 변경 되셨습니다
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {
    	
    	String oldPhone = target.getPhone();
    	target.setPhone(phone);
    	dao.saveFile();
    	
    	// 결과 메시지 반환
      return String.format("%s님의 전화번호가 변경 되었습니다\n%s -> %s", target.getName(), oldPhone, phone);
      
      // ex)
      // 홍길동님의 전화번호가 변경 되었습니다
      // 01012341234 -> 01044445555
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {
    	
    	List<Member> searchList = dao.getMemberList();
    	searchList.remove(target);
    	
    	dao.saveFile();
    	
    	return String.format("%s 회원이 탈퇴 처리 되었습니다", target.getName());
    	
      // return null; // 결과 문자열 반환
      // ex)
      // "홍길동 회원이 탈퇴 처리 되었습니다"
    }

}