package co.yedam.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.dao.DAO;
import co.yedam.board.service.BoardService;
import co.yedam.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public List<BoardVO> boardSelectList() {
		// TODO 게시글 목록 조회
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from board order by bid desc";
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
				//vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 한 행 조회 (게시글 상세 조회)
		String sql = "select * from board where bid = ?";
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid")); // 테이블의 컬럼명과 같게 써준다(대소문자 구분x)
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent")); // 게시글 목록에 글 내용은 불러올 필요x
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				
				hitUpdate(vo.getbId()); // 조회수 증가 메소드
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return vo;
	}

	private void hitUpdate(int id) {
		// TODO 조회수 증가 (게시글 읽으면=상세조회하면 조회수 증가)
		String sql = "update board set bhit = bhit + 1 where bid = ?";
		// 이미 열려 있으니까 (상세조회 중이니까) 커넥션 x
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
	}

	
	@Override
	public int boardInsert(BoardVO vo) {
		// TODO 게시글 작성 (입력)
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO 게시글 삭제
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO 게시글 수정
		return 0;
	}

	
	public void close() {
		// TODO 연결 종료
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
