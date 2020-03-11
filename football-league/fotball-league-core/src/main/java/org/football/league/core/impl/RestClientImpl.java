package org.football.league.core.impl;

import org.football.league.core.service.RestClient;
import org.football.league.core.util.ApiName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestClientImpl implements RestClient{

	@Autowired
	Environment env;

	@Override
	public <T> T getApi(ApiName api, Class<?> responseType) {

		String apiHostIpPort = env.getProperty(api.name()) + "key=" + env.getProperty("key");
		RestTemplate restTemplate;
		T result = null;

		UriComponents uriComponents = UriComponentsBuilder.fromUriString(apiHostIpPort).build(false).encode();

		try {
			restTemplate = new RestTemplate();
			result = (T) restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, null, responseType).getBody();
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	@Override
	public Object getApi(ApiName api, String[] queryParamName, String[] queryParamValue, Class<?> responseType) {
		RestTemplate restTemplate;
		String apiHostIpPort = env.getProperty(api.name());
		UriComponentsBuilder builder = null;
		UriComponents uriComponents = null;
		builder = UriComponentsBuilder.fromUriString(apiHostIpPort);
		if (apiHostIpPort != null) {
			if(queryParamName.length!=0) {
				for(int i=0;i<queryParamName.length; i++) {
					builder.queryParam(queryParamName[i], queryParamValue[i]);
				}
			}
			uriComponents = builder.build(false).encode();
		}
		try {
			restTemplate = new RestTemplate();
			return restTemplate.getForObject(uriComponents.toUri(), responseType);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
