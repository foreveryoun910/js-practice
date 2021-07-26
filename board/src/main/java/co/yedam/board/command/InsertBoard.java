package co.yedam.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 작성
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbWriter(request.getParameter("bWriter"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		
		int n = dao.boardInsert(vo);
		String view = "";
		if(n != 0) {
			view = "boardList.do";
		} else {
			view = "board/ErrorPage";
		}
		return view;
	}

}
