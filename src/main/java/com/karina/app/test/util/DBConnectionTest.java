package com.karina.app.test.util;

import java.sql.Connection;

import com.karina.app.countrie.CountriesDAO;
import com.karina.app.departments.DepartmentDAO;
import com.karina.app.util.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		
		CountriesDAO cdao=new CountriesDAO();
		try {
			cdao.countries();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
