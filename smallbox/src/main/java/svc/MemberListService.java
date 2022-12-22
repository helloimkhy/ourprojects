package svc;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberDTO;

public class MemberListService {

	public List<MemberDTO> getMemberList() {
		List<MemberDTO> memberList = null;
		
		// 공통작업-1. Connection 객체 가져오기
				Connection con = JdbcUtil.getConnection();
				
				// 공통작업-2. BoardDAO 객체 가져오기
				MemberDAO dao = MemberDAO.getInstance();
				
				// 공통작업-3. BoardDAO 객체에 Connection 객체 전달하기
				dao.setConnection(con);
				
				memberList = dao.selectMemberList();
				System.out.println("리스트서비스" + memberList);
				
				
				// 공통작업-4. Connection 객체 반환하기
				JdbcUtil.close(con);
		
		return memberList;
	}
}
