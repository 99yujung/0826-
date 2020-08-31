package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;

public class DeptDAO {
		// 전역 변수, 모든 메서드에 공통으로 사용되는 변수
		Connection conn;
		PreparedStatement pstmt;
		
		
		// 전체 조회
		public ArrayList<DeptVO> selectAll(DeptVO deptVO) {
			DeptVO resultVO = null; // 값을 저장할 변수 선언
			ResultSet rs = null;
			ArrayList<DeptVO> list = new ArrayList<DeptVO>(); // 리턴값을 저장할 변수 객체 선언
			try {
				conn = ConnectionManager.getConnnect();
				String sql = " SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID mgr_id, LOCATION_ID"
							+ " FROM DEPARTMENTS"
							+ " ORDER BY DEPARTMENT_ID";
				// control + shift + X 대문자 전환 , control + shift + Y 소문자 전환
				// " 공백
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					resultVO = new DeptVO();
					resultVO.setDepartment_id(rs.getInt(1));
					resultVO.setDepartment_name(rs.getString("department_name"));
					resultVO.setManager_id(rs.getInt("mgr_id")); // MANAGER_ID의 별칭
					resultVO.setLocation_id(rs.getInt("LOCATION_ID"));
					list.add(resultVO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(null, pstmt, conn);
			}
			return list;
		}
		
		//단건 조회
		public DeptVO selectOne(DeptVO deptVO) {
			DeptVO resultVO = null; // 값을 저장할 변수 선언
			ResultSet rs = null;
			try {
				conn = ConnectionManager.getConnnect();
				String sql = " SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID mgr_id, LOCATION_ID"
							+ " FROM DEPARTMENTS"
							+ " WHERE DEPARTMENT_ID = ?";
				// control + shift + X 대문자 전환 , control + shift + Y 소문자 전환
				// " 공백
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptVO.getDepartment_id());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					resultVO = new DeptVO();
					resultVO.setDepartment_id(rs.getInt(1));
					resultVO.setDepartment_name(rs.getString("department_name"));
					resultVO.setManager_id(rs.getInt("mgr_id")); // MANAGER_ID의 별칭
					resultVO.setLocation_id(rs.getInt("LOCATION_ID"));
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString("department_name"));
				} else {
					System.out.println("no data");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(null, pstmt, conn);
			}
			return resultVO;
		}
		
		public void delete(DeptVO deptVO) {
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "delete departments where department_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptVO.getDepartment_id());
				int r = pstmt.executeUpdate();
				System.out.println(r + "건이 삭제됨");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(null, pstmt, conn);
			}
		}
		
		public void update(DeptVO deptVO) {
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "update departments set department_name = ? where department_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, deptVO.getDepartment_name());
				pstmt.setInt(2, deptVO.getDepartment_id());
				int r = pstmt.executeUpdate();
				System.out.println(r + "건이 수정됨");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(null, pstmt, conn);
			}
		}
	public void insert(DeptVO deptVO) {
		// VO 값을 담는 용도로 쓰는 클래스
		try {
		//1. DB연결
		conn = ConnectionManager.getConnnect();
		//2.sql 구문 실행
		String sql = "insert into departments (department_id, department_name) "
				+ " values (" + deptVO.getDepartment_id() + ", '"
				+ deptVO.getDepartment_name() +"')";
		Statement stmt = conn.createStatement();
		int r = stmt.executeUpdate(sql);
		//3.결과 처리
		System.out.println(r + " 건이 처리됨");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		//4.연결 해제
		ConnectionManager.close(conn);
		}
	}
}
