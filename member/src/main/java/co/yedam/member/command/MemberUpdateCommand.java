package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberUpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원정보변경
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String[] hobbies = request.getParameterValues("hobbies"); // 여기 있는 변수는 form에 있는 변수(checkbox로 입력받은)
		String hobby = "";
		for(String str : hobbies) { // 여러개 입력받은 거(배열) 처리
			hobby += str + ",";
		}
		hobby = hobby.substring(0, hobby.length()-1);
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(vo.getName());
		vo.setAge(Integer.valueOf(request.getParameter("age")));
		vo.setHobby(hobby);
		int n = ms.memberUpdate(vo);
		String view;
		if(n != 0) {
			view = "memberList.do"; // update 성공하면 추가된 회원 확인하게 전체회원조회
		} else {
			request.setAttribute("message", "입력 실패!");
			view = "member/memberUpdateFail";
		}
		
		return view;
	}

}
