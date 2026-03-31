package com.karina.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.karina.app.util.DBConnection;


public class CountryDAO {
	private DBConnection connection=new DBConnection();
	
	
	public CountryDAO() {
		this.connection=new DBConnection();
	}
	
//	public int update(CountryDTO countryDTO) throws Exception{
//		Connection con=connection.getConnection();
//		String sql="""
//				UPDATE COUNTRIES
//				SET COUNTRY_NAME="?",
//				REGION_ID="?"
//				WHERE COUNTRY_ID="?"
//				""";
//		PreparedStatement st=con.prepareStatement(sql);
		
		
//	}
	public int delete(CountryDTO countryDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql="DELETE COUNTRIES WHERE COUNTRY_ID=?";
		
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, countryDTO.getCountryId());
		
		int result=st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int create(CountryDTO countryDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql=
				"""
				INSERT INTO COUNTRIES(COUNTRY_ID,COUNTRY_NAME,REGION_ID)
				VALUES(?,?,?)
				""";
		
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1,countryDTO.getCountryId());
		st.setString(2,countryDTO.getCountryName());
		st.setInt(3,countryDTO.getRegionId());
		
		int result=st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public CountryDTO countryid(String coid) throws Exception {
		
		Connection con=connection.getConnection();
		String sql="SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st=con.prepareStatement(sql); //sql을 디비로 컴파일해서 보냄
		
		st.setString(1, coid);
		
		ResultSet rs=st.executeQuery();
		CountryDTO dto=null;
		
		if(rs.next()) {
			dto=new CountryDTO();
			dto.setCountryName(rs.getString("COUNTRY_NAME"));
			dto.setCountryId(rs.getNString("COUNTRY_ID"));
			dto.setRegionId(rs.getInt("REGION_ID"));
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	
	public ArrayList<CountryDTO> countries() throws Exception {
		//DB연결
		
		
		Connection con=connection.getConnection();
		//쿼리문 작성
		String sql="SELECT * FROM COUNTRIES";
		//미리전송
		PreparedStatement ps= con.prepareStatement(sql);
		//최종전송 및 결과출력
		ResultSet rs=ps.executeQuery();
		ArrayList<CountryDTO> ar=new ArrayList<>();
		
		while(rs.next()) {
		CountryDTO dto=new CountryDTO();
		String cid=rs.getString("COUNTRY_ID");
		String name=rs.getString("COUNTRY_NAME");
		int rid=rs.getInt("REGION_ID");
		
		dto.setCountryId(cid);
		dto.setCountryName(name);
		dto.setRegionId(rid);
		
		ar.add(dto);
		}
		rs.close();
		ps.close();
		con.close();
		
		return ar;
	}
}
