package com.karina.app.employees;

import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.karina.app.util.DBConnection;

public class EmployeesDAO {

	private DBConnection connection;
	
	public EmployeesDAO() {
		// TODO Auto-generated constructor stub
	 
		this.connection = new DBConnection();
	}
	public void name(int employeeid) throws Exception {
		Connection con=connection.getConnection();
		
		String sql="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setInt(1, employeeid);
		
		ResultSet rs=st.executeQuery();
		
		if(rs.next()) {
			String eid=rs.getString("EMAIL");
			System.out.println(eid);
		}else {
			System.out.println("없음");
		}
		rs.close();
		st.close();
		con.close();
		
	}
}
