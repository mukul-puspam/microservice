package org.football.league.management.service.impl;
	
import java.util.Arrays;
import java.util.List;
import org.football.league.core.service.RestClient;
import org.football.league.core.util.ApiName;
import org.football.league.management.entity.Country;
import org.football.league.management.service.LeagueService;
import org.football.league.management.util.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class LeagueServiceImpl implements LeagueService<Object, String, Action>{

	@Autowired
	RestClient restClient;
	
	@Autowired
	Environment env;
	
	@Override
	public Country add(Object country) {
		return null;
	}

	@Override
	public List<Object> getAll(Action action, String countryId) {
		String[] queryParamName = new String[3];
		String[] queryParamValue = new String[3];
		queryParamName[0] = "action";
		queryParamName[1] = "country_id";
		queryParamName[2] = "APIkey";
		queryParamValue[0] = action.name();
		queryParamValue[1] = countryId;
		queryParamValue[2] = env.getProperty("key");
		
				
		if(action.name().equals(Action.get_countries.name())) {
			Country[] result = (Country[])restClient.getApi(ApiName.Country, queryParamName, queryParamValue, Country[].class);
			return Arrays.asList(result);
		}
		return null;
	}

	@Override
	public Country getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
