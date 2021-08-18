package co.yedam.otd.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import co.yedam.otd.common.Command;
import co.yedam.otd.common.DataSource;
import co.yedam.otd.review.service.ReviewService;
import co.yedam.otd.review.serviceImpl.ReviewServiceImpl;
import co.yedam.otd.review.vo.ReviewVO;

public class ReviewInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//TODO 리뷰작성
		ReviewService dao = new ReviewServiceImpl();
		HttpSession session = request.getSession();
		ReviewVO vo = new ReviewVO();
		vo.setEmail(request.getParameter("email"));
		vo.setReviewLike(Integer.valueOf(request.getParameter("reviewLike")));
		vo.setReviewContent(request.getParameter("reviewContent"));
		dao.reviewInsert(vo);
		dao.reviewList();
		session.getAttribute("sessionEmail");

		SqlSession sqlSession = DataSource.getInstance().openSession();
		sqlSession.close();		
		
		return "review/reviewList";
	}

}
