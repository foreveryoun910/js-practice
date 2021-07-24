package co.yedam.member.service;

import java.util.List;

import co.yedam.member.vo.MemberVO;

public interface MemberService {

	List<MemberVO> memberSelectList(); // 회원전체목록
	MemberVO memberSelect(MemberVO vo); // 한명의 회원 조회
	int memberInsert(MemberVO vo); // 회원가입
	int memberDelete(MemberVO vo); // 회원삭제
	int memberUpdate(MemberVO vo); // 회원정보변경
}
