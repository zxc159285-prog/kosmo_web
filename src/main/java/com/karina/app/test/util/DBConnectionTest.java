package com.karina.app.test.util;

import java.sql.Connection;

import com.karina.app.countries.CountryDAO;
import com.karina.app.departments.DepartmentDAO;
import com.karina.app.util.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		
		CountryDAO cdao=new CountryDAO();
		try {
			cdao.countries();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
