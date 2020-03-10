package org.country.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "country_id")
	String countryId;
	
	@Column(name = "country_name")
	String countryName;
	
	public String getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
}
