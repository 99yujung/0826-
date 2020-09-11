package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	public static Connection getConnnect() {
		Connection conn = null;
		try {
			//driverManager 이용하여 연결
/*			Class.forName("oracle.jdbc.OracleDriver");
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(jdbc_url, "hr", "hr"); */
			//일일이 생성해서 사용하는 방식

			//datasource를 이용하여 connection 획득
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/oracle");
			conn = ds.getConnection();   //conn 을 할당받음
			System.out.println("dbcp에서 conn 할당");
			// ConnectionPool connection 객체를 프로그램이 실행될 때마다 생성하지않고
			// 웹서버에서 미리 생성하여 준비된 Connection을 가져다 사용함
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if( conn != null) conn.close(); //커넥션 풀에 반납
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {			
			try {
				if(! rs.isClosed()) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		if(pstmt != null) {
			try {
				if(! pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				if(! conn.isClosed())  conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
