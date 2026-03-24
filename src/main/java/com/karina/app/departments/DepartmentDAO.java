package com.karina.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.karina.app.util.DBConnection;

public class DepartmentDAO {
	
	public void list() throws Exception {
		//1.DB연결
		DBConnection connection=new DBConnection();
		Connection con=connection.getConnection();
		//2.쿼리문작성
		String sql="SELECT * FROM DEPARTMENTS";
		//3.쿼리문 미리 전송
		PreparedStatement st=con.prepareStatement(sql);
		//4.최종전송 및 결과처리
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
			String name=rs.getString("DEPARTMENT_NAME");
			int id=rs.getInt("DEPARTMENT_ID");
			System.out.println(name+" : "+id);
			
		}
		//연결 해제
		rs.close();
		st.close();
		con.close();
	}

}
