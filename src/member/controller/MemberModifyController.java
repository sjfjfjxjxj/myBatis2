package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberModifyController
 */
@WebServlet("/member/modify.do")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberModifyController() {
		super();
		// TODO Auto-generated constructor stub
	}

//로그인한 아이디로 조회할거라서 쿼리스트링 필요없대
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService mService = new MemberServiceImpl();
		// 클래스간의 결합도를 낮추기 위해 인터페이스를 중간에 둔다
		// 세션에서 ID값 가벼오기↓
		HttpSession session = request.getSession();
		try {
			Member member = (Member) session.getAttribute("member");
			// session은 nullpointexception 발생할수 있음ㅇㅇ
			String memberId = member.getMemberId();
			Member mOne = mService.selectOneById(memberId);
			// syntax error 이런거 날수있음
			if (mOne != null) {
				request.setAttribute("mOne", mOne);
				request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "아이디 없음!");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String memberId=request.getParameter("member-id");
			String memberPw=request.getParameter("member-pw");
			String memberEmail=request.getParameter("member-email");
			String memberPhone=request.getParameter("member-phone");
			String memberAddr=request.getParameter("member-addr");
			String memberHobby=request.getParameter("member-hobby");
			Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddr, memberHobby);
			//1. 멤버서비스 객체 생성
			MemberService mService = new MemberServiceImpl();
			//2. 결과값 받기위해 modifyMember 로직 완성
			int result = mService.modifyMember(member);
			
			if(result>0) {
				response.sendRedirect("/member/modify.do");
			}else {
				request.setAttribute("msg", "수정 실패!!");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			
		}
		
		
	}

}
