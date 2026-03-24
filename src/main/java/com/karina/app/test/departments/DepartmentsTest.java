package com.karina.app.test.departments;

import com.karina.app.departments.DepartmentDAO;

public class DepartmentsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepartmentDAO dao=new DepartmentDAO();
		try {
			dao.detail(50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
