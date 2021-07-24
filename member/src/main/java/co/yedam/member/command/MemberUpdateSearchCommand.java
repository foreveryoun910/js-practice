package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberUpdateSearchCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 변경을 위한 조회
		MemberService ms = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = ms.memberSelect(vo);
		if(vo.getName() != null) {
			request.setAttribute("member", vo);
		} else {
			request.setAttribute("message", "존재하지 않는 아이디 입니다.");
		}
		
		return "member/memberUpdate";
	}

}
