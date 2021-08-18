package co.yedam.otd.review.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.otd.common.DataSource;
import co.yedam.otd.review.service.ReviewMapper;
import co.yedam.otd.review.service.ReviewService;
import co.yedam.otd.review.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService {
	private SqlSession sqlSession = DataSource.getInstance().openSession();
	private ReviewMapper map = sqlSession.getMapper(ReviewMapper.class);
	
	@Override
	public List<ReviewVO> reviewList() {
		// TODO 전체리뷰목록
		return map.reviewList();
	}
	
	@Override
	public ReviewVO reviewSelect(ReviewVO vo) {
		return map.reviewSelect(vo);
	}

	@Override
	public List<ReviewVO> reviewSelectList(ReviewVO vo) {
		// TODO 리뷰조회(내가 쓴 리뷰만 조회할 수 있도록, 리뷰를 여러개 쓴 경우도 있을 수 있으니 list로 받아옴)
		return map.reviewSelectList(vo);
	}

	@Override
	public int reviewInsert(ReviewVO vo) {
		// TODO 리뷰작성(서비스를 이용한 사람만)
		int n = map.reviewInsert(vo);
		sqlSession.commit();
		return n;
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		// TODO 리뷰수정(리뷰 작성자 본인만)
		int n = map.reviewUpdate(vo);
		sqlSession.commit();
		return n;
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		// TODO 리뷰삭제(리뷰 작성자 본인만)
		int n = map.reviewDelete(vo);
		sqlSession.commit();
		return n;
	}

}
