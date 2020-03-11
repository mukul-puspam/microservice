package org.football.league.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Country {


	private String country_id;

	private String country_name;

	public Country(String country_id, String country_name) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
	}

	public Country() {
		
	}
	public String getCountry_id() {
		return country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	

	
}
