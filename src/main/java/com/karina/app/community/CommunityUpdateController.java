package com.karina.app.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;

/**
 * Servlet implementation class CommunityUpdateController
 */
@WebServlet("/comm/update")
public class CommunityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num=request.getParameter("num");
		int n = Integer.parseInt(num);
		CommunityDAO dao=new CommunityDAO();
		
		CommunityDTO dto;
		try {
			dto = dao.detail(n);
			request.setAttribute("dto", dto);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/views/comm/update.jsp");
		view.forward(request, response);
		
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num=request.getParameter("num");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		String name=request.getParameter("name");
		String star=request.getParameter("star");
		
		CommunityDTO dto=new CommunityDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setName(name);
		dto.setStar(Integer.parseInt(star));
		
		CommunityDAO dao=new CommunityDAO();
		try {
			int result=dao.update(dto);
			if(result>0) {
				response.sendRedirect("/comm/list");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
