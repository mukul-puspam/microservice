package org.country.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CountryService <T,U>{

	public T addCountry(T t);
	
	public List<T> getAllCountries();
	
	public T getCountryById(U u);
	
	public T getCountryByName(U u);
	
}
