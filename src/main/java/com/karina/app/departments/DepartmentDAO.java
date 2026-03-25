package com.karina.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.karina.app.util.DBConnection;

public class DepartmentDAO {
	
	public void detail(int departmentid) throws Exception {
		DBConnection connection=new DBConnection();
		Connection con= connection.getConnection();
		
		String sql= "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?"; //오라클에서는 물음표가 순서대로 1번 2번 3번
		
		PreparedStatement st=con.prepareStatement(sql); //쿼리문 미리전송
		
		//?값을 세팅해주는 작업
		st.setInt(1,departmentid); //첫번째는 물음표순서 두번쨰는 지정값
		
		//최종전송
		ResultSet rs=st.executeQuery();
		
		if(rs.next()) {
			String name=rs.getNString("DEPARTMENT_NAME");
			System.out.println(name);
		}else {
			System.out.println("부서가 없다");
		}
		rs.close();
		st.close();
		con.close();
	}
	
	public ArrayList<DepartmentDTO> list() throws Exception {
		//1.DB연결
		DBConnection connection=new DBConnection();
		Connection con=connection.getConnection();
		//2.쿼리문작성
		String sql="SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID DESC";
		//3.쿼리문 미리 전송
		PreparedStatement st=con.prepareStatement(sql);
		//4.최종전송 및 결과처리
		ResultSet rs= st.executeQuery();
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		while(rs.next()) {
			DepartmentDTO dto=new DepartmentDTO(); 
			String name=rs.getString("DEPARTMENT_NAME");
			int id=rs.getInt("DEPARTMENT_ID");
			int mid=rs.getInt("MANAGER_ID");
			int lid=rs.getInt("LOCATION_ID");
			
			dto.setDepartmentName(name);
			dto.setDepartmentId(id);
			dto.setManagerId(mid);
			dto.setLocationId(lid);
			
			ar.add(dto);
			
		}
		//연결 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}

}
