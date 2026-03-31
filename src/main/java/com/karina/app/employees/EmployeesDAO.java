package com.karina.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.karina.app.util.DBConnection;

public class EmployeesDAO {
	//로그인 검증
	private DBConnection connection;
	public EmployeesDAO( ) {
		this.connection = new DBConnection();
	}
	public EmployeesDTO login(EmployeesDTO employeesDTO) throws Exception {
		Connection con= connection.getConnection();
		String sql="""	
					SELECT * FROM EMPLOYEES
					WHERE EMPLOYEE_ID = ? AND PASSWORD = ?
					""";
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setInt(1,employeesDTO.getEmployeeId());
		st.setString(2,employeesDTO.getPassword());
		
		ResultSet rs= st.executeQuery();
		
		if(rs.next()) {
			employeesDTO.setFirstName(rs.getNString("FIRST_NAME"));
			employeesDTO.setLastName(rs.getNString("LAST_NAME"));
			employeesDTO.setHireDate(rs.getDate("HIRE_DATE"));
			employeesDTO.setSalary(rs.getDouble("SALARY"));
			employeesDTO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			
			return employeesDTO; //로그인 성공하면 데이터를 리턴
		}
	
		return null; //로그인에 실패하면 널을 리턴
	}
}
