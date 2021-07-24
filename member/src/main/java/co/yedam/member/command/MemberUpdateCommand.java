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
		vo.setId(request.getParameter("id"));
		request.setAttribute("member", vo);
		int n = ms.memberUpdate(vo);
		String view;
		if(n != 0) {
			view = "memberList.do";
		} else {
			request.setAttribute("message", "입력 실패!");
			view = "member/memberInsertFail";
		}
		
		return view;
	}

}
