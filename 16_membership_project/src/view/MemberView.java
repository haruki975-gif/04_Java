package view;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiConsumer;

// View : 사용자에게 보여지는 역할을 하는 클래스/객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력
public class MemberView {

	private MemberService service = null;
	private Scanner sc = null;
	BufferedReader br = null;

	/**
	 * 기본 생성자 - MemberView 객체 생성 시 필드 초기화 - MemberService 초기화 시 예외가 발생할 수 있으므로 try -
	 * catch 작성
	 */
	public MemberView() {

		try {
			// 객체 생성 중 발생한 예외를 View에 모아서 처리
			service = new MemberServiceImpl();

			// 키보드를 입력 받기 위한 스트림 생성
			sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

		} catch (Exception e) {

			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
	}

	// -------------------------------------------------------------------
	// [메인 메뉴]
	public void mainMenu() {

		int input = 0;
		do {

			try {
				// 메뉴 출력 후 입력된 번호를 반환 받기
				System.out.println("\n===== 회원 관리 프로그램 =====\n");

				System.out.println("1. 회원 가입(추가)");
				System.out.println("2. 회원 전체 조회");
				System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
				System.out.println("4. 특정 회원 사용 금액 누적하기");
				System.out.println("5. 회원 정보 수정");
				System.out.println("6. 회원 탈퇴");
				System.out.println("0. 종료");

				System.out.print("메뉴 선택 >>> ");

				// 입력 받은 문자열을 int 형태로 변환
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				System.out.println(); // 줄바꿈

				// 선택된 메뉴 번호에 따라 case 선택
				switch (input) {
				case 1: addMember(); break;
				case 2: selectAll(); break;
				case 3:	selectName(); break;
				case 4: updateAmount();	break;
				case 5:	updateMember();	break;
				case 6:	deleteMember();	break;
				case 0:	System.out.println("*** 프로그램 종료 ***");	break;
				default:	System.out.println("### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				System.out.println("==========================================");

				
				/* 모든 메서드에서 던져진 예외를 모아서 처리*/
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요 ###\n");
				input = -1; // 첫 반복에서 종료되지 않게 값 변경

			} catch (IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace(); // 예외 추적

			} catch (Exception e) { // 나머지 예외 처리
				e.printStackTrace();
			}

		} while (input != 0);
	}

	
	// ---------------------------------------------------------------
	// [1. 회원 가입(추가)]
	public void addMember() throws IOException {
		System.out.println("\n----- 회원 가입(추가) -----\n");

		System.out.print("이름 : ");
		String name = sc.nextLine(); // 이름
		
		String phone; // 번호
		
    while (true) {
      System.out.print("휴대폰 번호(- 제외) : ");
      phone = sc.nextLine();

      if (phone.length() == 11) break; // 11자리 숫자로 입력되면 반복 종료
      else System.out.println("*** 다시 입력 해주세요. ***\n");
    }
    
    boolean add = service.addMember(name, phone);
    
    if(add) System.out.println("*** 회원이 추가되었습니다 ***"); 
    System.out.println(); // 줄바꿈

	}

	
	// -------------------------------------------------------------
	// [2. 회원 전체 조회]
	public void selectAll() {
		System.out.println("\n----- 회원 전체 조회 -----\n");
		
		// view <-> service <-> dao
		List<Member> memberLsit =	service.getMemberList();
		
		// 출력 부분
		System.out.print("------------------------------------------\n");
		System.out.println("[이름] [휴대폰 번호]   [누적금액] [등급]");
		System.out.print("------------------------------------------\n");
		memberLsit.stream().forEach(member->{
			
			String gradeText; // 등급 > 글자
			
			if(member.getGrade() == 0) {
				gradeText = "일반";
			} else if(member.getGrade() == 1){
				gradeText = "골드";
			} else {
				gradeText = "다이아";
			}
			
			System.out.printf("%-7s %-13s %-13d %s\n", //공간 확보하고 정렬 : %숫자(+,-)타입
										member.getName(), member.getPhone(), member.getAmount(), gradeText);
		});

	}

	// ------------------------------------------------------------------------
	// [3. 이름으로 검색(동명이인)]
	public void selectName() throws IOException {
		System.out.println("\n----- 이름 검색(동명이인 있으면 모두 조회) -----\n");
		
		System.out.print("검색할 이름 입력 : ");
		String name = sc.nextLine(); // 이름
		
		List<Member> searchName = service.selectName(name);
		
		if(searchName == null) {
			System.out.println("### 검색 결과가 없습니다 ###");
			return;
		}
		else {
			for(Member search : searchName) {
				System.out.println(search); // 이름 1개씩 꺼내기
			}
		}
		
	}

	// ------------------------------------------------------------
	// [4. 특정 회원 사용 금액 누적하기]
	public void updateAmount() throws IOException {
		System.out.println("\n----- 특정 회원 사용 금액 누적하기 -----\n");
		
		System.out.print("회원 이름 입력 : ");
		String target = sc.nextLine(); // 이름
		
		List<Member> foundMembers = service.selectName(target);
		
		// 검색 결과가 없을 경우
    if (foundMembers == null) {
        System.out.println("### 해당 이름의 회원이 없습니다 ###");
        return;
    }
    
    Member selectedMember; // 선택된 회원 저장 변수
    
    // 검색된 회원 목록 출력
    if(foundMembers.size() > 1) {
	    System.out.println("\n*** 대상 회원을 선택 해주세요 ***\n");
	    for (int i = 0; i < foundMembers.size(); i++) {
	        System.out.printf("%d) %s (%s)\n", i + 1, foundMembers.get(i).getName(), foundMembers.get(i).getPhone());
	    }
	    
	    // 사용자에게 선택 입력 받기
	    System.out.print("선택할 회원의 번호를 입력 : ");
	    int index;
	    while (true) {
	      try {
	      	index = Integer.parseInt(sc.nextLine()) - 1;
	          if (index >= 0 && index < foundMembers.size()) break;
	      } catch (NumberFormatException e) {
	          // 숫자가 아닌 값 입력 방지
	      }
	      System.out.println("*** 올바른 번호를 입력하세요 ***");
	    }
	    
	    // 선택된 회원 정보
	    selectedMember = foundMembers.get(index);
	    
    } else {
    	// 동명이인 없을 때
    	selectedMember = foundMembers.get(0);
    }
    
    // 누적할 금액
    System.out.print("누적할 금액 입력 : ");
    int acc = sc.nextInt();
    sc.nextLine();
    
    String result = service.updateAmount(selectedMember, acc);

    // 결과 출력
    System.out.println(result);
    
	}
	

	// -----------------------------------------------------------------
	// [5.회원 정보 수정]
	public void updateMember() throws IOException {
		System.out.println("\n----- 회원 정보 수정 -----\n");
		
		System.out.print("회원 이름 입력 : ");
		String target = sc.nextLine(); // 이름
		
		List<Member> foundMembers = service.selectName(target);
		
		// 검색 결과가 없을 경우
    if (foundMembers == null) {
        System.out.println("### 해당 이름의 회원이 없습니다 ###");
        return;
    }
    
    Member selectedMember; // 선택된 회원 저장 변수
    
    // 검색된 회원 목록 출력
    if(foundMembers.size() > 1) {
	    System.out.println("\n*** 대상 회원을 선택 해주세요 ***\n");
	    for (int i = 0; i < foundMembers.size(); i++) {
	        System.out.printf("%d) %s (%s)\n", i + 1, foundMembers.get(i).getName(), foundMembers.get(i).getPhone());
	    }
	    
	    // 사용자에게 선택 입력 받기
	    System.out.print("선택할 회원의 번호를 입력 : ");
	    int index;
	    while (true) {
	      try {
	      	index = Integer.parseInt(sc.nextLine()) - 1;
	          if (index >= 0 && index < foundMembers.size()) break;
	      } catch (NumberFormatException e) {
	          // 숫자가 아닌 값 입력 방지
	      }
	      System.out.println("*** 올바른 번호를 입력하세요 ***");
	    }
	    
	    // 선택된 회원 정보
	    selectedMember = foundMembers.get(index);
	    
    } else {
    	// 동명이인 없을 때
    	selectedMember = foundMembers.get(0);
    }

    // 수정할 전화번호 입력
    System.out.print("수정할 전화번호 입력 : ");
    String newPhone = sc.nextLine();

    // 회원 정보 업데이트 요청
    String result = service.updateMember(selectedMember, newPhone);

    // 결과 출력
    System.out.println(result);

	}

	
	// ------------------------------------------------------------
	// [6.회원 탈퇴]
	public void deleteMember() throws IOException {
		System.out.println("\n----- 회원 탈퇴 -----\n");
		
		System.out.print("회원 이름 입력 : ");
		String target = sc.nextLine(); // 이름
		
		List<Member> foundMembers = service.selectName(target);
		
		// 검색 결과가 없을 경우
    if (foundMembers == null) {
        System.out.println("### 해당 이름의 회원이 없습니다 ###");
        return;
    }
    
    Member selectedMember; // 선택된 회원 저장 변수
    
    // 검색된 회원 목록 출력(동명이인 있을 떄)
    if(foundMembers.size() > 1) {
	    System.out.println("\n*** 대상 회원을 선택 해주세요 ***\n");
	    for (int i = 0; i < foundMembers.size(); i++) {
	        System.out.printf("%d) %s (%s)\n", i + 1, foundMembers.get(i).getName(), foundMembers.get(i).getPhone());
	    }
	    
	    // 사용자에게 선택 입력 받기
	    System.out.print("선택할 회원의 번호를 입력 : ");
	    int index;
	    while (true) {
	      try {
	      	index = Integer.parseInt(sc.nextLine()) - 1;
	          if (index >= 0 && index < foundMembers.size()) break;
	      } catch (NumberFormatException e) {
	          // 숫자가 아닌 값 입력 방지
	      }
	      System.out.println("*** 올바른 번호를 입력하세요 ***");
	    }
	    
	    // 선택된 회원 정보
	    selectedMember = foundMembers.get(index);
	    
    } else {
    	// 동명이인 없을 때
    	selectedMember = foundMembers.get(0);
    }
    
    
    // 탈퇴 처리 여부
    System.out.print("정말 탈퇴 처리 하시겠습니까? (y/n) : ");
    String input = sc.next(); // 소문자로 변환하여 비교
    
    if(input.equals("y")) {
    	// 회원 정보 삭제 요청
      String result = service.deleteMember(selectedMember);
      System.out.println(result);
    } else {
    	System.out.println("### 탈퇴 취소 ###");
    }
	}
	
}