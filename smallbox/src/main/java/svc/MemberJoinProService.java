package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberDTO;

public class MemberJoinProService {

	public boolean joinMember(MemberDTO member) {
		System.out.println("BoardJoinProService - joinMember()");
				
			boolean isJoinSeuccess = false;
			
			Connection con = JdbcUtil.getConnection();
			
			MemberDAO dao = MemberDAO.getInstance();
			
			dao.setConnection(con);
			
			
			int insertCount = dao.insertMember(member);
			System.out.println(insertCount);
			if(insertCount > 0) {
				JdbcUtil.commit(con);
				
				isJoinSeuccess = true;
			} else {
				JdbcUtil.rollback(con);
			}
			
			JdbcUtil.close(con);
			
			// 작업결과 리턴
			return isJoinSeuccess; 
		}
	}

