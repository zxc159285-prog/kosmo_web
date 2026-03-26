package com.karina.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentCreateController
 */
@WebServlet("/dept/create")
public class DepartmentCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/create.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DB에 저장해야돼");
		String name=request.getParameter("departmentName");
		String mid=request.getParameter("managerId");
		String lid=request.getParameter("locationId");
		
		DepartmentDTO departmentDTO=new DepartmentDTO();
		departmentDTO.setDepartmentName(name);
		departmentDTO.setManagerId(Integer.parseInt(mid));
		departmentDTO.setLocationId(Integer.parseInt(lid));
		
		DepartmentDAO departmentDAO=new DepartmentDAO();
		try {
			int result =departmentDAO.create(departmentDTO);
			
			if(result >0) {
				response.sendRedirect("/dept/list"); //이 주소를 줄테니 이걸받고 다시 요청해라 라고 사용자에게 보내는것
				//이렇게해야 doget메서드가 호출되어서 list.jsp를 다시 실행하는게 됨
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
