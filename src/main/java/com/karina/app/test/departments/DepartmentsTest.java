package com.karina.app.test.departments;

import com.karina.app.departments.DepartmentDAO;
import com.karina.app.departments.DepartmentDTO;

public class DepartmentsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepartmentDAO dao=new DepartmentDAO();
		try {
			DepartmentDTO departmentDTO=new DepartmentDTO();
			departmentDTO.setDepartmentName("Class3");
			departmentDTO.setManagerId(null);
			departmentDTO.setLocationId(null);
			
			dao.create(departmentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
