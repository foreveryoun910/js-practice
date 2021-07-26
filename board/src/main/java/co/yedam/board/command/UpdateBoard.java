package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class UpdateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 수정
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		int n = dao.boardUpdate(vo);
		String view = "";
		if(n != 0) {
			view = "boardList.do";
		} else {
			view = "board/ErrorPage";
		}
		return view;
	}

}
