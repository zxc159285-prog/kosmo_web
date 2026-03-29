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
	public int update(CommunityDTO communityDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql="""
				UPDATE COMMUNITY
				SET TITLE=?,
				NAME=?,
				CONTENTS=?,
				CREATETIME=SYSDATE,
				STAR=?
				WHERE NUM=?
				""";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,communityDTO.getTitle());
			st.setString(2,communityDTO.getName());
			st.setString(3,communityDTO.getContents());
			st.setInt(4, communityDTO.getStar());
			st.setInt(5,communityDTO.getNum());
			
			int result=st.executeUpdate();
			st.close();
			con.close();
			return result;
	}
	
	public int delete(CommunityDTO communityDTO) throws Exception {
		Connection con= connection.getConnection();
		String sql="DELETE COMMUNITY WHERE NUM=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,communityDTO.getNum());
		int result= st.executeUpdate();
		
		st.close();
		con.close();
		return result;
		
		
	}
	public int create(CommunityDTO communityDTO) throws Exception {
		Connection con=connection.getConnection();
		String sql="""
					INSERT INTO COMMUNITY(NUM,TITLE,CONTENTS,NAME,CREATETIME,STAR)
					VALUES(COMM_SEQ.NEXTVAL,?,?,?,SYSDATE,?)
					""";
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1,communityDTO.getTitle());
		st.setString(2,communityDTO.getContents() );
		st.setString(3,communityDTO.getName());
		st.setInt(4,communityDTO.getStar());
		
		int result=st.executeUpdate();
		
		st.close();
		con.close();
		return result;
				 
				
		
	}
	
	public CommunityDTO detail(int num) throws Exception {
		Connection con=connection.getConnection();
		String sql="SELECT * FROM COMMUNITY WHERE NUM=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,num);
		ResultSet rs=st.executeQuery();
		
		CommunityDTO dto=null;
		
		if(rs.next()) {
			dto=new CommunityDTO();
			dto.setNum(rs.getInt("NUM"));
			dto.setTitle(rs.getString("TITLE"));
			dto.setContents(rs.getString("CONTENTS"));
			dto.setName(rs.getString("NAME"));
			dto.setDate(rs.getDate("CREATETIME"));
			dto.setStar(rs.getInt("STAR"));
			
			
		}
		rs.close();
		st.close();
		con.close();
		return dto;
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
