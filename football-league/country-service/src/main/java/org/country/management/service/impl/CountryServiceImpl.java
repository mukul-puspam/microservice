package org.country.management.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.country.management.entity.Country;
import org.country.management.service.CountryService;
import org.football.league.core.service.RestClient;
import org.football.league.core.util.ApiName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class CountryServiceImpl implements CountryService<Country, String>{

	@Autowired
	RestClient restClient;
	
	@Override
	public Country addCountry(Country country) {
		return null;
	}

	@Override
	public List<Country> getAllCountries() {
//		Object[] obj = restClient.getApi(ApiName.Country, Country[].class);
//		return Arrays.asList(obj).stream().map(x -> (Country) x).collect(Collectors.toList());
//		https://apiv2.apifootball.com/?action=get_leagues&country_id=4&APIkey=c9fe3cad6b9f430c07fbd366fa48c5459f0825bb00be4b5165043e1a64865c76
		String[] queryParamName = new String[3];
		String[] queryParamValue = new String[3];
		queryParamName[0] = "action";
		queryParamName[1] = "country_id";
		queryParamName[2] = "APIkey";
		queryParamValue[0] = "get_leagues";
		queryParamValue[0] = "4";
		queryParamValue[0] = "c9fe3cad6b9f430c07fbd366fa48c5459f0825bb00be4b5165043e1a64865c76";
	}

	@Override
	public Country getCountryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country getCountryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
