package co.yedam.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.command.BoardList;
import co.yedam.board.command.BoardSelect;
import co.yedam.board.command.Command;
import co.yedam.board.command.HomeCommand;
import co.yedam.board.command.InsertBoard;
import co.yedam.board.command.InsertForm;

@WebServlet("*.do") // 어노테이션 활용
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO 사용할 Command를 정의 (Command 초기화, 생성한다는 개념)
		map.put("/home.do", new HomeCommand());
		map.put("/boardList.do", new BoardList()); // 게시글 목록 조회 (전체조회)
		map.put("/boardSelect.do", new BoardSelect()); // 한 행 조회 (게시글 상세 조회)
		map.put("/insertForm.do", new InsertForm()); // 게시글 작성 폼
		map.put("/insertBoard.do", new InsertBoard()); // 게시글 작성
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 실제 수행 부분을 분석, 실행, 리턴페이지를 돌려준다
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
