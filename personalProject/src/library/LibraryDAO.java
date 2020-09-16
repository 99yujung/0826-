package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class LibraryDAO {

	/*
	 * create table book_information ( ISBN varchar2(100), name varchar2(20), author
	 * varchar2(20), publisher varchar2(20), published_date date, book_size
	 * varchar2(20), primary key (ISBN) ); 도서코드, 도서명, 저자, 출판사, 출판일자, 책 크기(??)
	 * 
	 * =============================
	 * 
	 * 수정 alter table book_information rename column name to title; alter table
	 * book_information rename to book; alter table book drop column book_size;
	 * alter table book rename column ISBN to ISBN;
	 * 
	 * 테이블명 book_information rename to book 컬럼명 name to title, ISBN to ISBN 컬럼 삭제
	 * book_size
	 */
/*
	private static LibraryDAO dao = new LibraryDAO();
	private LibraryDAO(){ }
	public static LibraryDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"jsp", "jsp");
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		close(conn, ps);
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
	}
	
	public void libraryInsert(LibraryVO library) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into library value(?,?,?,?,?)");
			pstmt.setString(1, library.getISBN());
			pstmt.setString(2, library.getTitle());
			pstmt.setString(3, library.getAuthor());
			pstmt.setString(4, library.getPublisher());
			pstmt.setString(5, library.getPublished_date());
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		}
	}
	*/
	// ======================
	// 전역 변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;

	// 싱글톤
	static LibraryDAO instance;

	public static LibraryDAO getInstance() {
		if (instance == null)
			instance = new LibraryDAO();
		return instance;
	}

	// 전체 조회
	public ArrayList<LibraryVO> selectAll(LibraryVO libraryVO) {
		LibraryVO resultVO = null;
		ResultSet rs = null;
		ArrayList<LibraryVO> list = new ArrayList<LibraryVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT * FROM book ORDER BY ISBN";
			pstmt = conn.prepareStatement(sql);
			//
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVO = new LibraryVO();
				resultVO.setISBN(rs.getString(1));
				resultVO.setTitle(rs.getString(2));
				resultVO.setAuthor(rs.getString(3));
				resultVO.setPublisher(rs.getString(4));
				resultVO.setPublished_date(rs.getString(5));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return list;
	}

	// 단건 조회
	public LibraryVO selectOne(LibraryVO libraryVO) {
		LibraryVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ISBN, TITLE, AUTHOR, PUBLISHER, PUBLISHED_DATE " + " FROM book";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, libraryVO.getISBN());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVO = new LibraryVO();
				resultVO.setISBN(rs.getString(1));
				resultVO.setTitle(rs.getString(2));
				resultVO.setAuthor(rs.getString(3));
				resultVO.setPublisher(rs.getString(4));
				resultVO.setPublished_date(rs.getString(5));

			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVO;
	}

	// 삭제
	public void delete(LibraryVO libraryVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM book WHERE ISBN = ?"; // where ISBN
			pstmt = conn.prepareStatement(sql);
			// pstmt .setString(1, LibraryVO.getCOLUMN_NAME());
			pstmt.setString(1, libraryVO.getISBN()); // 오류 'getISBN()' to 'static'
			int r = pstmt.executeUpdate(); // int r
			System.out.println(r + " 건이 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	// 수정
	public void update(LibraryVO libraryVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE book SET  TITLE = ?, AUTHOR = ?, "
					+ "PUBLISHER = ?, PUBLISHED_DATE = ? where ISBN = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, libraryVO.getISBN());
			pstmt.setString(2, libraryVO.getTitle());
			pstmt.setString(3, libraryVO.getAuthor());
			pstmt.setString(4, libraryVO.getPublisher());
			pstmt.setString(5, libraryVO.getPublished_date());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	// insert
	public int insert(LibraryVO libraryVO) {
		int r = 0;
		try {
			// 1.DB연결
			conn = ConnectionManager.getConnnect();
			// 2.SQL 구문 실행
			String sql = "INSERT INTO book(ISBN, title, author, publisher, published_date)" + " VALUES (?, ?, ?, ?, ?)"; // ?
																															// ,
																															// sysdate
			pstmt = conn.prepareStatement(sql); // 예외처리?
			pstmt.setString(1, libraryVO.getISBN());
			pstmt.setString(2, libraryVO.getTitle());
			pstmt.setString(3, libraryVO.getAuthor());
			pstmt.setString(4, libraryVO.getPublisher());
			pstmt.setString(5, libraryVO.getPublished_date());
			r = pstmt.executeUpdate();
			// 3.결과 처리
			System.out.println(r + " 건이 처리됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. 연결해제(DB에 접속 session수는 제한적 그래서 해제해야 됨)
			ConnectionManager.close(conn);

		}
		return r;
	}

//
	public LibraryVO librarySearch(String ISBN) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LibraryVO library = null;

		try {
			conn = ConnectionManager.getConnnect();
			pstmt = conn.prepareStatement("select * from book where id=?");
			pstmt.setString(1, ISBN);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				library = new LibraryVO();
				library.setISBN(rs.getString(1));
				library.setTitle(rs.getString(2));
				library.setAuthor(rs.getString(3));
				library.setPublisher(rs.getString(4));
				library.setPublished_date(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			ConnectionManager.close(conn);
		}
		return library;
	}

	public void libraryUpdate(LibraryVO library) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionManager.getConnnect();
			pstmt = conn.prepareStatement("update book set ISBN=?, title=?, author=? publisher=? published_date=?");
			pstmt.setString(1, library.getISBN());
			pstmt.setString(2, library.getTitle());
			pstmt.setString(3, library.getAuthor());
			pstmt.setString(4, library.getPublisher());
			pstmt.setString(5, library.getPublished_date());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			ConnectionManager.close(conn);
		}
	}

	public void libraryDelete(String ISBN) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionManager.getConnnect();
			pstmt = conn.prepareStatement("delete from book where ISBN=?");
			pstmt.setString(1, ISBN);
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			ConnectionManager.close(conn);
		}

	}

	public ArrayList<LibraryVO> libraryList() {
		ArrayList<LibraryVO> list = new ArrayList<LibraryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LibraryVO library = null;
		try {
			conn = ConnectionManager.getConnnect();
			pstmt = conn.prepareStatement("select * from book");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				library = new LibraryVO();
				library.setISBN(rs.getString(1));
				library.setTitle(rs.getString(2));
				library.setAuthor(rs.getString(3));
				library.setPublisher(rs.getString(4));
				library.setPublished_date(rs.getString(5));
				list.add(library);
			}
		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}

	// select count(ISBN) from book where 꺼내올 정보

}
