package com.karina.app.userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.karina.app.util.DBConnection;

public class UserinfoDAO {

	private DBConnection connection=new DBConnection();
	
	public UserinfoDAO() {
		this.connection=new DBConnection();
	}
	public UserinfoDTO login(UserinfoDTO userinfoDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql="""
				SELECT * FROM USERINFO
				WHERE ID=? AND PASSWORD=?
				""";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, userinfoDTO.getId());
		st.setString(2,userinfoDTO.getPw());
		
		ResultSet rs=st.executeQuery();
		
		if(rs.next()) {
			userinfoDTO.setId(rs.getString("ID"));
			userinfoDTO.setName(rs.getString("NAME"));
			userinfoDTO.setEmail(rs.getString("EMAIL"));
			
			rs.close();
			st.close();
			con.close();
			return userinfoDTO;
		}
		
			return null;
		
		
		
	}
	
	public int signup(UserinfoDTO userinfoDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql=
				"""
				INSERT INTO USERINFO (ID,PASSWORD,NAME,EMAIL)
				VALUES (?,?,?,?)
				""";
				
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,userinfoDTO.getId());
		st.setString(2,userinfoDTO.getPw());
		st.setString(3,userinfoDTO.getName());
		st.setString(4,userinfoDTO.getEmail());
		
		int result=st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
}
