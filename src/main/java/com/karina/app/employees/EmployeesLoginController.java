package com.karina.app.employees;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

/**
 * Servlet implementation class EmployeesLoginController
 */
@WebServlet("/emp/login")
public class EmployeesLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//f or r
		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/emp/login.jsp");
		view.forward(request, response); //리퀘스트 리스폰스는 메서드가 종료되도 살아서 jsp로 보냄 jsp에서 거기들어있는값을 사용할수있음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String i=request.getParameter("employeeId");
		int id= Integer.parseInt(i);
		String pw=request.getParameter("password");
		
		EmployeesDTO dto=new EmployeesDTO();
		dto.setEmployeeId(id);
		dto.setPassword(pw);
		
		EmployeesDAO dao=new EmployeesDAO();
		try {
			dto=dao.login(dto);
			if(dto!=null) {
				System.out.println("ok");
			}
			else {
				System.out.println("로그인 실패");
			}
			
			HttpSession session=request.getSession();
			
			
			session.setAttribute("dto", dto); //어트리뷰트는 담는것.
			
			response.sendRedirect("/home"); //세션은 포워드로보내면안됨 리다이렉트로보내야함
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
