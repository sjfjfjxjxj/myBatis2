package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.service.MemberServiceImpl;
import member.model.vo.Member;
import member.model.vo.PageData;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/member/list.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberServiceImpl();
		int currentPage = 1;
		//page라는 애는 쿼리스트링을 써줄거라 부여하는 문자열(개떡같은데 기억하렴) 
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		try {
			 PageData pd = mService.selectAllMembers(currentPage);
			 List<Member> mList = pd.getMemberList();
			 String pageNavi = pd.getPageNavigator();
			request.setAttribute("mList", mList);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(request,response);
			
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
	}


}
