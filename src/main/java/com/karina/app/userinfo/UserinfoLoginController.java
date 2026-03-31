package com.karina.app.userinfo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class UserinfoLoginController
 */
@WebServlet("/userinfo/login")
public class UserinfoLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/userinfo/login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		UserinfoDTO userinfoDTO=new UserinfoDTO();
		userinfoDTO.setId(id);
		userinfoDTO.setPw(pw);
		
		UserinfoDAO userinfoDAO=new UserinfoDAO();
		try {
			UserinfoDTO result=userinfoDAO.login(userinfoDTO);
			if(result!=null) {
				System.out.println("로그인 성공");
				
				
			}
			else {
				System.out.println("아이디 또는 비밀번호 틀림");
			}
			HttpSession session=request.getSession();
			session.setAttribute("dto", userinfoDTO);
			response.sendRedirect("/home");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
