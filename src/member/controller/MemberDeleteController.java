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
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/member/delete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }
//로그인한 사람은 자기 아이디를 삭제할 수 있다
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		//ⓐ★로그인한 사람의 정보를 삭제할때: 세션 가져와서 로그인할떄 저장한 정보인 멤버 가져와
		MemberService mService = new MemberServiceImpl();
		try {
			Member member = ((Member)session.getAttribute("member")); 
			//ⓑ다운캐스팅 해줘야함. 겟어트리뷰트 하면 오브젝트로 불러와져서.
			String memberId = member.getMemberId();
			//ⓒ이렇게 세줄로 로그인한 사용자의 아이디를 가져올수있음
			int result = mService.deleteMember(memberId);
			
			if(result>0) {
				
				response.sendRedirect("/member/logout.do");
			}else {
				request.setAttribute("msg", "회원탈퇴 미완료!");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
			
			
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	

}
