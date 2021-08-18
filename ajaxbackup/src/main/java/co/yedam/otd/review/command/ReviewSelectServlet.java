package co.yedam.otd.review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.otd.common.DataSource;
import co.yedam.otd.review.service.ReviewService;
import co.yedam.otd.review.serviceImpl.ReviewServiceImpl;
import co.yedam.otd.review.vo.ReviewVO;

@WebServlet("/ReviewSelectServlet")
public class ReviewSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		vo.setReviewNo(Integer.valueOf(request.getParameter("reviewNo")));
		request.setAttribute("review", dao.reviewSelect(vo));
		HttpSession session = request.getSession();
		List<ReviewVO> list = dao.reviewList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
		String se = (String) session.getAttribute("sessionEmail");
		System.out.println(se);		
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		sqlSession.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
