package com.karina.app.community;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.karina.app.util.DBConnection;

import oracle.sql.DATE;

public class CommunityDAO {
	
	private DBConnection connection=new DBConnection();
	
	public CommunityDAO() {
		this.connection=new DBConnection();
	}
	public void detail(CommunityDTO communityDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql="SELECT CONTENTS FROM COMMUNITY WHERE NUM=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,communityDTO.getNum());
		ResultSet rs=st.executeQuery();
		
		if(rs.next()) {
			String contents=rs.getString("contents");
		}
		rs.close();
		st.close();
		con.close();
	}
	
	public ArrayList<CommunityDTO> list() throws Exception {
		Connection con=connection.getConnection();
		String sql="SELECT * FROM COMMUNITY ORDER BY NUM DESC";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		
		ArrayList<CommunityDTO> ar=new ArrayList<>();
		
		while(rs.next()) {
			CommunityDTO communityDTO=new CommunityDTO();
			int num=rs.getInt("NUM");
			String title=rs.getString("TITLE");
			String contents=rs.getString("CONTENTS");
			String name =rs.getString("NAME");
			Date date=rs.getDate("CREATETIME");
			int star=rs.getInt("STAR");
			
			communityDTO.setNum(num);
			communityDTO.setTitle(title);
			communityDTO.setContents(contents);
			communityDTO.setName(name);
			communityDTO.setDate(date);
			communityDTO.setStar(star);
			
			ar.add(communityDTO);
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
}
