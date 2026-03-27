package com.karina.app.countries;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CountryDeleteController
 */
@WebServlet("/country/delete")
public class CountryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("countryId");
		CountryDTO countryDTO=new CountryDTO();
		countryDTO.setCountryId(id);
		CountryDAO countryDAO=new CountryDAO();
		
		try {
			int result=countryDAO.delete(countryDTO);
			if(result>0) {
				response.sendRedirect("/country/list");
			}else {
				response.sendRedirect("detail?countryId="+id); // 슬러시로시작하면 절대경로 .이나 슬러시가없으면 상대경로
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
