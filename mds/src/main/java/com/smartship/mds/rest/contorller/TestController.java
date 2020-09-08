package com.smartship.mds.rest.contorller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/anonymous/test", method = RequestMethod.GET)
	public ResponseEntity<String> getAnonymous() {
		return ResponseEntity.ok("Hello Anonymous");
	}
	
	@RequestMapping(value = "/authenticated/keycloak", method = RequestMethod.GET)
	//@PreAuthorize("@authorizationService.hasRole('KEYCLOAK')")
	public ResponseEntity<Map<String, String>> keycloakUser() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", "Hello user");
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/authenticated/google", method = RequestMethod.GET)
	@PreAuthorize("@authorizationService.hasRole('GOOGLE')")
	public ResponseEntity<String> googleUser() {
		return ResponseEntity.ok("Hello Google User");
	}
	
	@RequestMapping(value = "/authenticated/outlook", method = RequestMethod.GET)
	@PreAuthorize("@authorizationService.hasRole('OUTLOOK')")
	public ResponseEntity<String> outlookUser() {
		return ResponseEntity.ok("Hello Outlook User");
	}

}
