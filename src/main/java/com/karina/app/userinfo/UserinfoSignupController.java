package com.karina.app.userinfo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

/**
 * Servlet implementation class UserinfoSignupController
 */
@WebServlet("/userinfo/signup")
public class UserinfoSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoSignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/userinfo/signup.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserinfoDTO userinfoDTO=new UserinfoDTO();
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		userinfoDTO.setId(id);
		userinfoDTO.setPw(pw);
		userinfoDTO.setName(name);
		userinfoDTO.setEmail(email);
		
		UserinfoDAO userinfoDAO=new UserinfoDAO();
		try {
			int result=userinfoDAO.signup(userinfoDTO);
			
			if(result>0) {
				response.sendRedirect("/userinfo/login");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
