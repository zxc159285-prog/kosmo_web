package com.karina.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.karina.app.util.DBConnection;


public class CountryDAO {
	
	
	public void countryid(String coid) throws Exception {
		DBConnection connection=new DBConnection();
		Connection con=connection.getConnection();
		String sql="SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, coid);
		
		ResultSet rs=st.executeQuery();
		
		if(rs.next()) {
			String name=rs.getString("COUNTRY_NAME");
			System.out.println(name);
			
		}else {
			System.out.println("정보 없음");
		}
		rs.close();
		st.close();
		con.close();
		
	}
	
	
	public void countries() throws Exception {
		//DB연결
		
		DBConnection connection=new DBConnection();
		Connection con=connection.getConnection();
		//쿼리문 작성
		String sql="SELECT * FROM COUNTRIES";
		//미리전송
		PreparedStatement ps= con.prepareStatement(sql);
		//최종전송 및 결과출력
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
		String cid=rs.getString("COUNTRY_ID");
		String name=rs.getString("COUNTRY_NAME");
		int rid=rs.getInt("REGION_ID");
		
		System.out.println(cid+" : "+name+" : "+rid);
		}
		rs.close();
		ps.close();
		con.close();
	}
}
