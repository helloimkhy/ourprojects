package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.mysql.cj.protocol.Resultset;

import db.JdbcUtil;
import vo.ActionForward;
import vo.MemberDTO;

public class MemberDAO {
	
	PreparedStatement pstmt = null, pstmt2 = null;
	ResultSet rs = null;
	//----------------------------------------------------
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	//-----------------------------------------------------
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	//-----------------------------------------------------
	// 회원가입 작업
	public int insertMember(MemberDTO member) {
		System.out.println("MemberDAO - insertMember()");
		int insertCount = 0;
		
		try {
			int member_idx = 1; // 기본값이 있으므로 밑의 if문에서 else가 따로 필요X
			String sql = "SELECT MAX(member_idx) FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_idx = rs.getInt(1) +1;
				sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?,now(), ?, ?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, member_idx);
				pstmt2.setString(2, member.getMember_id());
				pstmt2.setString(3, member.getMember_passwd());
				pstmt2.setString(4, member.getMember_name());
				pstmt2.setString(5, member.getMember_email());
				pstmt2.setString(6, member.getMember_phone());
				pstmt2.setDate(7, member.getMember_birth_date());
				pstmt2.setString(8, member.getMember_point());
				insertCount = pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insertMember()!");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(pstmt);
		}
		
		return insertCount;
	}
	
	// 로그인 작업
	public boolean isRightUser(MemberDTO member) {
		System.out.println("MemberDAO - isRightUser()");
		System.out.println(member.getMember_id() + ", " + member.getMember_passwd());
		
		boolean isRightUser = false;
		
		con = JdbcUtil.getConnection();
		
		try {
			// 아이디, 패스워드가 일치하는 레코드 검색
			String sql = "SELECT member_id FROM member WHERE member_id=? AND member_passwd=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_passwd());
			
			rs = pstmt.executeQuery();
			
			// 조회 결과 레코드가 존재할 경우 isLoginSuccess 를 true 로 변경
			if(rs.next()) {
				isRightUser = true;
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - loginMember()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isRightUser;
		
	}
	
	// 회원 목록 조회 
	public List<MemberDTO> selectMemberList() {
		List<MemberDTO> memberList = null;
		
		try {
			// 전체 회원 목록 조회(임시로 아이디 오름차순 정렬)
			String sql = "SELECT * FROM member ORDER BY member_id ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 전체 회원정보를 저장할 List 객체 생성
			memberList = new ArrayList<MemberDTO>();
			
			while(rs.next()) {
				// 1명의 회원 정보를 저장할 MemberBean 객체 생성
				MemberDTO member = new MemberDTO();
				member.setMember_idx(rs.getInt("member_idx"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_passwd(rs.getString("member_passwd"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_phone(rs.getString("member_phone"));
				member.setMember_join_date(rs.getDate("member_join_date"));
				member.setMember_birth_date(rs.getDate("member_birth_date"));
				member.setMember_point(rs.getString("member_point"));
				
				//List 객체에 MemberBean 객체 추가
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("selectMemberList - SQL 구문 오류!");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return memberList;
	}

	}
