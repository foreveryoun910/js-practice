package co.yedam.member.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.command.Command;
import co.yedam.member.command.MainCommand;
import co.yedam.member.command.MemberInsertCommand;
import co.yedam.member.command.MemberInsertFormCommand;
import co.yedam.member.command.MemberSearchCommand;
import co.yedam.member.command.MemberSearchFormCommand;
import co.yedam.member.command.MemberSelectListCommand;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Command 객체를 여기 등록 (map 구조로 등록)
		map.put("/main.do", new MainCommand()); // 홈
		map.put("/memberList.do", new MemberSelectListCommand());
		map.put("/memberSearch.do", new MemberSearchCommand());
		map.put("/memberSearchForm.do", new MemberSearchFormCommand());
		map.put("/memberInsert.do", new MemberInsertCommand());
		map.put("/memberInsertForm.do", new MemberInsertFormCommand());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO command 요청 분석 및 처리, viewPage 선택하는 곳
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 실제 요청 분석
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length()); // uri에서 context 길이만큼 substring 하면 실제 요청page만 추출 가능
		
		Command command = map.get(path); // map에서 path를 key값으로 가지는 value로 command를 초기화, interface는 자기 자신을 초기화 x (new 사용 불가능) // Command command = new MainCommand(); <- 라는 구문을 못 쓰니까 이렇게 표현(같은 의미)
		String viewPage = command.execute(request, response); // viewPage: 실행한 결과를 보여줄 페이지
		
		if(!viewPage.endsWith(".do")) { // 보여줄 페이지를 선택하는 조건문
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 내가 가지고 있는 request 객체를 가지고 새로운 페이지로 넘어간다
		dispatcher.forward(request, response);
	}

}
