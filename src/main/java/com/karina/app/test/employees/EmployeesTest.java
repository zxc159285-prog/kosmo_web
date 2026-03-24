package com.karina.app.test.employees;

import com.karina.app.employees.EmployeesDAO;

public class EmployeesTest {

	public static void main(String[] args) {
		EmployeesDAO employeesDAO=new EmployeesDAO();
		try {
			employeesDAO.name(101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
