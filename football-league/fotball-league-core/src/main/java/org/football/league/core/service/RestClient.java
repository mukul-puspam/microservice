package org.football.league.core.service;

import org.football.league.core.util.ApiName;
import org.springframework.stereotype.Service;

@Service
public interface RestClient {

	public <T> T getApi(ApiName api, Class<?> responseType);
	
	public Object getApi(ApiName api, String[] queryParamName, String[] queryParamValue, Class<?> responseType);
	
}
