package com.karina.app.test.countries;

import com.karina.app.countries.CountryDAO;

public class CountriesTest {

	public static void main(String[] args) {

		CountryDAO dao=new CountryDAO();
		try {
			dao.countryid("IN");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
