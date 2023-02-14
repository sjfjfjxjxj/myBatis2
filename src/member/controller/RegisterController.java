package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;
import member.model.vo.Member;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId=request.getParameter("member-id");
		String memberPw=request.getParameter("member-pw");
		String memberName=request.getParameter("member-name");
		int memberAge=Integer.parseInt(request.getParameter("member-age"));
		String memberEmail=request.getParameter("member-email");
		String memberPhone=request.getParameter("member-phone");
		String memberAddr=request.getParameter("member-addr");
		String memberGender=request.getParameter("member-gender");
		String memberHobby=request.getParameter("member-hobby");
		Member mOne = new Member(memberId, memberPw, memberName, memberAge, memberEmail, memberPhone, memberAddr, memberGender, memberHobby);
		
		MemberService mService = new MemberServiceImpl();
		try {
			int result = mService.registerMember(mOne);
			if(result>0) {
				response.sendRedirect("/index.jsp");
			}else {
				request.setAttribute("msg", "회원가입 미완료!!");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
