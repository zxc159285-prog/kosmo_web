package com.karina.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentUpdateController
 */
@WebServlet("/dept/update")
public class DepartmentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//jsp로 보내주는 코드를 쓰면 됨 . foward
		//jsp의 경로명을 써야한다
		String id=request.getParameter("departmentId");
		int n=Integer.parseInt(id);
		
		DepartmentDAO departmentDAO=new DepartmentDAO();
		try {
			DepartmentDTO departmentDTO=departmentDAO.detail(n);
			request.setAttribute("dto", departmentDTO);//jsp로 보낼건데 포워드에보면 requst가 살아서 가니까 리퀘스트에 담는다
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/views/dept/update.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentDTO departmentDTO=new DepartmentDTO();
		String id=request.getParameter("departmentId");
		int did = Integer.parseInt(id);
		String n = request.getParameter("departmentName");
		
		String m= request.getParameter("managerId");
		int mid=Integer.parseInt(m);
		String o=request.getParameter("locationId");
		int lid=Integer.parseInt(o);
		
		departmentDTO.setDepartmentId(did);
		departmentDTO.setDepartmentName(n);
		departmentDTO.setManagerId(mid);
		departmentDTO.setLocationId(lid);
		
		
		
		DepartmentDAO departmentDAO=new DepartmentDAO();
		
		try {
			int result=departmentDAO.update(departmentDTO);
			if(result>0) {
				response.sendRedirect("./list");
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
