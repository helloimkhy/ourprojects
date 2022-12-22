package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberDTO;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		ActionForward forward = null;
		MemberDTO member = new MemberDTO();
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_passwd(request.getParameter("member_passwd"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_email(request.getParameter("member_email1") + "@" + request.getParameter("member_email2")); // "@" 부분 '@' 가능(? String에 결합되면 String이 되므로)
		member.setMember_phone(request.getParameter("member_phone"));
		member.setMember_join_date(Date.valueOf(request.getParameter("member_join_date")));
		member.setMember_birth_date(Date.valueOf(request.getParameter("member_birth_date")));
//		Date date = Date.valueOf(request.getParameter("member_birth_date"));
		
		member.setMember_point(request.getParameter("member_point"));
		
		System.out.println(member);
		
		// -------------------------------------------------------------------------------
//		// 패스워드 암호화(해싱) 기능 추가
//		// encrypt.MyMessageDigest 클래스 인스턴스 생성
//		MyMessageDigest md = new MyMessageDigest("SHA-256");
//		// MyMessageDigest 객체의 hashing() 메서드를 호출하여 암호화 수행
//		md.hashing(request.getParameter("passwd"));
//		// -------------------------------------------------------------------------------
		
		
		MemberJoinProService service = new MemberJoinProService();
		boolean isJoinSuccess = service.joinMember(member);
			
		if(!isJoinSuccess) { // 실패했을 경우
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입 실패!')");
				out.println("history.back();");
				out.println("/<script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 성공했을 경우
			// 포워딩 정보를 저장할 ActionForward 인스턴스 생성 (forward)
			forward = new ActionForward();
			forward.setPath("MemberJoinResult.sm");
			forward.setRedirect(true);
		}
		
		return forward;
		
	}

}

