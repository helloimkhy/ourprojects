package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.MemberJoinProAction;
import action.MemberLoginProAction;
import action.MemberLogoutProAction;
import action.Action;
import vo.ActionForward;

	@WebServlet("*.sm")
	public class MemberController extends HttpServlet {
		// GET or POST 방식 요청을 공통으로 처리할 doProcess() 메서드 정의
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("MemberFrontController - doProcess()");
			
			String command = request.getServletPath();
			System.out.println("command : " + command);
			
			// 공통으로 사용할 변수 선언
			ActionForward forward = null; // 포워딩 정보를 저장할 ActionForward 타입 변수
			Action action = null;
				
			if (command.equals("/MemberJoinForm.sm")) {
				forward = new ActionForward();
				forward.setPath("test/join_form.jsp");
				forward.setRedirect(false); // 생략 가능
				
			} else if (command.equals("/MemberJoinPro.sm")) {
				action = new MemberJoinProAction();
				forward = action.execute(request, response);
				
			} else if (command.equals("/MemberJoinResult.sm")) {
				forward = new ActionForward();
				forward.setPath("test/join_result.jsp");
				forward.setRedirect(false); // 생략 가능
				
			} else if (command.equals("/MemberLoginForm.sm")) {
				forward = new ActionForward();
				forward.setPath("test/login.jsp");
				forward.setRedirect(false); // 생략 가능
				
			} else if (command.equals("/MemberLoginPro.sm")) {
				action = new MemberLoginProAction();
				forward = action.execute(request, response);
				
			} else if (command.equals("/MemberLogout.sm")) {
				action = new MemberLogoutProAction();
				forward = action.execute(request, response);
				
			} else if (command.equals("/FindIdForm.sm")) {
				forward = new ActionForward();
				forward.setPath("test/find_id_form.jsp");
				forward.setRedirect(false); // 생략 가능
				
			} 
			
			if(forward != null) {
				// 2. Actionforward 객체에 저장된 포워딩 방식 판별
				if(forward.isRedirect()) { // Rerdirect 방식
					// Redirect 방식의 포워딩 작업 수행
					// => 포워딩 경로는 ActionForward 객체의 getPath() 메서드 활용
					response.sendRedirect(forward.getPath());
				} else { // Dispatch 방식
					// Dispatch 방식의 포워딩 작업 수행
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}
			
		} // doProcess() 메서드 끝(응답 데이터 전송 시점)
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}

	}

