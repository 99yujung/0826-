package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;
import dept.DeptVO;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;

	// 싱글톤
	static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
	// 전체조회
	public ArrayList<BoardVO> selectAll(BoardVO boardVO) {
		BoardVO resultVO = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME " + "FROM BOARD "
					+ "ORDER BY NO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				resultVO = new BoardVO();
				resultVO.setNo(rs.getString(1));
				resultVO.setPoster(rs.getString(2));
				resultVO.setSubject(rs.getString(3));
				resultVO.setContents(rs.getString(4));
				resultVO.setLastpost(rs.getString(5));
				resultVO.setViews(rs.getString(6));
				resultVO.setFilename(rs.getString(7));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}

	// 단건 조회
	public BoardVO selectOne(BoardVO boardVO) {
		BoardVO resultVO = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME " + "FROM DEPARTMETNS "
					+ "WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getNo());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultVO = new BoardVO();
				resultVO.setNo(rs.getString(1));
				resultVO.setPoster(rs.getString(2));
				resultVO.setSubject(rs.getString(3));
				resultVO.setContents(rs.getString(4));
				resultVO.setLastpost(rs.getString(5));
				resultVO.setViews(rs.getString(6));
				resultVO.setFilename(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVO;
	}

	// 삭제
	public void delete(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM BOARD WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
	}

	// 수정
	public void update(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE BOARD SET SUBJECT = ? WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getSubject());
			pstmt.setString(2, boardVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
	}

	// 삽입
	public void insert(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);	//오토커밋 안되게 해놓는거.
			//보드 번호 조회, 업데이트
			String seqSql = "select no from seq where tablename = 'board'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(seqSql);
			rs.next();
			int no = rs.getInt(1);
			// boardVO.setNo(Integer, result);
			
			seqSql = "update seq set no = no + 1 where tablename = 'board'";
			stmt = conn.createStatement();
			stmt.executeUpdate(seqSql);
					
			//게시글 등록
			//시퀀스 번호 사용
			String sql = "INSERT INTO BOARD(NO, POSTER, SUBJECT, CONTENTS,LASTPOST, VIEWS, FILENAME) VALUES (SEQ_BOARD.NEXTVAL,?,?,?,SYSDATE,1,?)";
			//번호증가되는 테이블을 따로 선언해서 사용.
//			String sql = "INSERT INTO BOARD(NO, POSTER, SUBJECT, CONTENTS,LASTPOST, VIEWS, FILENAME) VALUES (?,?,?,?,SYSDATE,1,?)";
			pstmt = conn.prepareStatement(sql);;
			pstmt.setInt(1, no);
			pstmt.setString(2, boardVO.getPoster());
			pstmt.setString(3, boardVO.getSubject());
			pstmt.setString(4, boardVO.getContents());
			pstmt.setString(5, boardVO.getFilename());
			int r = pstmt.executeUpdate();
			conn.commit();	//작업 다 수행한 후 commit
			System.out.println(r + "건이 처리됨.");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();	//rollback도 예외처리 필요.
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionManager.close(conn);
		}
	}
}

