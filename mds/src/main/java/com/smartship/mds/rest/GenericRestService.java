package com.smartship.mds.rest;


import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class GenericRestService {
	
	private RestTemplate restTemplate;

	public GenericRestService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public <T> ResponseEntity<T> callRestService(
			final String requestUrl,
			final HttpEntity<Object> requestEntity,
			final Map<String, String> uriVariables,
			final HttpMethod httpMethod,
			final Class<T> responseType
			)
	{
	ResponseEntity<T> response =null;
	try {
		System.out.println(">>>>>>>>>>>>>>>>"+requestUrl);
	this.restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(requestUrl));	
	
		if(uriVariables !=null) {
			response = this.restTemplate.exchange(requestUrl, httpMethod, requestEntity, responseType, uriVariables);
		}
		else {
			response = this.restTemplate.exchange(requestUrl, httpMethod, requestEntity, responseType);
		}
	}
	catch (final RestClientException rce) {
		rce.printStackTrace();
	}
	catch (final Exception e) {
		
	}
	System.out.println(">>>>>>>>>>>>>>>>"+response.getBody());
	return response;
	}
	

}
