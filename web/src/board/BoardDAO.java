package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;
import dept.DeptVO;
import sun.security.action.GetIntegerAction;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	public ArrayList<BoardVO> selectAll(BoardVO boardVO) {
		BoardVO boardVO = null; // 값을 저장할 변수 선언
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); // 리턴값을 저장할 변수 객체 선언
		try {
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			// 보드 번호 조회
			String seqSql = "select no from seq where tablename = 'board'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(seqSql);
			rs.next();
			int no = rs.getInt(1);
			// 보드 번호 업데이트
			seqSql = "update seq set no = no + 1 where tablename = 'board' ";
			stmt = conn.createStatement();
			stmt.executeUpdate(seqSql);
			//게시글 등록
			String sql = "insert into board (lastpost, contents, subject, poster, no) "
						+ " values (sysdate, ?, ?, ?, ?) ";
			// " 공백
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  bean.getContents()); //
			// pstmt.setString(1, bean.getContents());	//
			pstmt.setString(2, bean.getPoster);	//
			pstmt.setInt(3, bean.getNo);	//
			conn.commit();
			if(rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return list;
	}

	public void insert(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}
}
