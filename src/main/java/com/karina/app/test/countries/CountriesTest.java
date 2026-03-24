package com.karina.app.test.countries;

import com.karina.app.countrie.CountriesDAO;

public class CountriesTest {

	public static void main(String[] args) {

		CountriesDAO dao=new CountriesDAO();
		try {
			dao.countryid("IN");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
