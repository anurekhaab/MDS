/* Licensed under Apache-2.0 */
package com.smartship.mds;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.smartship.mds.rest.GenericRestService;

import ro.common.rest.CommonDTOConverter;

/**
 * Bootstrap class for MDSClient test microservice
 *
 * @author r.krishnakumar 
 */
@SpringBootApplication
public class MDSClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(MDSClientApplication.class, args);
  }
  
	
	@Bean
	public GenericRestService genericRestService(final RestTemplateBuilder restTemplateBuilder) {
		final RestTemplate restTemplate = restTemplateBuilder
				.requestFactory(() -> new HttpComponentsClientHttpRequestFactory()).build();
		return new GenericRestService(restTemplate);
	}
	 
  @Bean
  public CommonDTOConverter commonDTOConverter() {
	  return new CommonDTOConverter(new ModelMapper());
  }
 
}