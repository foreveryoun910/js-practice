package co.yedam.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.member.command.DAO;
import co.yedam.member.service.MemberService;
import co.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	

	@Override
	public List<MemberVO> memberSelectList() {
		// TODO 전체회원목록조회
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				members.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO 회원조회
		String sql = "select * from member where id=?";
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	private void close() {
		// TODO 커넥션을 종료
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
