package co.yedam.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberSelectListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원전체목록조회
		MemberService ms = new MemberServiceImpl(); // 모델을 호출
		List<MemberVO> members = new ArrayList<MemberVO>(); // List가 추상객체여서 생성자로 생성 불가능
		members = ms.memberSelectList(); // 결과값을 members 리스트에 담는다
		request.setAttribute("list", members); // 페이지에 값을 전달 // 페이지에서 쓸 이름: list, list에 members를 실어보낸다
		
		return "member/memberSelectList"; // 보여줄 페이지 선택
	}

}
