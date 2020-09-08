/* Licensed under Apache-2.0 */
package com.smartship.mds.rest.contorller;


import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.smartship.mds.rest.GenericRestService;
import com.smartship.mds.springdata.domain.NamesOnly;
import com.smartship.mds.springdata.domain.PersonDTO;
import com.smartship.mds.springdata.entity.Person;
import com.smartship.mds.springdata.services.PersonService;

import lombok.extern.log4j.Log4j2;
import ro.common.exception.CommonRestException;
import ro.common.exception.GenericServiceException;
import ro.common.rest.CommonDTOConverter;
import ro.common.rest.CommonErrorCodes;

/** Testing Rest controller service */
@RestController
@Validated
@Log4j2
public class TestRestController {

  @Autowired private PersonService service;

  @Autowired private CommonDTOConverter dtoConverter;
  
	@Autowired private GenericRestService genericRestService; 

  /**
   * Get method to retrieve names only from the person table
   *
   * @param lastName
   * @param headers
   * @return
   * @throws CommonRestException
   */
  @GetMapping(
      value = "/person/:lastName",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<NamesOnly> getPersonNames(
      @NotBlank(message = CommonErrorCodes.E_HTTP_BAD_REQUEST) @PathVariable final String lastName,
      @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      return service.getPersonNamesOnlyByLastName(lastName);
    } catch (GenericServiceException e) {
      log.error("Test Rest error ", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatus.SERVICE_UNAVAILABLE,
          e.getMessage(),
          e);
    }
  }

  /**
   * POST Method to store a new person entity. Use only DTO with validation properties objects with
   * RequestBody annotations. Use common dto converter to convert to entity from DTO class.
   *
   * @param personDTO
   * @param headers
   * @return
   * @throws CommonRestException
   */
  @PostMapping(
      value = "/person",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Person savePerson(
      @Valid @RequestBody PersonDTO personDTO, @RequestHeader HttpHeaders headers)
      throws CommonRestException {
    try {
      Person person = dtoConverter.convertToEntity(personDTO, Person.class);
      return service.save(person);
    } catch (GenericServiceException e) {
      log.error("Test Rest error ", e);
      throw new CommonRestException(
          CommonErrorCodes.E_GEN_INTERNAL_ERR,
          headers,
          HttpStatus.SERVICE_UNAVAILABLE,
          e.getMessage(),
          e);
    }
  }
  
	
	@GetMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Root> test( @RequestHeader HttpHeaders headers) throws CommonRestException {
		ResponseEntity<Root> response = null;
		try {
			HttpHeaders headers1 = new HttpHeaders();
			headers1.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers1);
			response = genericRestService.callRestService("http://dummy.restapiexample.com/api/v1/employees",
					requestEntity, null, HttpMethod.GET, Root.class);
		} catch (Exception e) {
			log.error("Test Rest error ", e);

		}
		return response;
	}
	 
}
