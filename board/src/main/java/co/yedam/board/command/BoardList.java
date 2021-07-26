package co.yedam.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 전체 목록 조회
		BoardService dao = new BoardServiceImpl();
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = dao.boardSelectList();
		request.setAttribute("boards", list);
		
		return "board/boardList";
	}

}
