/*
 * package com.smartship.mds.keyclock;
 * 
 * import java.util.Set;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.keycloak.KeycloakSecurityContext; import
 * org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
 * import org.keycloak.representations.AccessToken; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.context.request.RequestContextHolder; import
 * org.springframework.web.context.request.ServletRequestAttributes;
 * 
 * @Service public class AuthorizationService {
 * 
 * public boolean hasRole(String... roles) { HttpServletRequest request =
 * ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
 * .getRequest(); AccessToken accessToken = ((KeycloakSecurityContext)
 * ((KeycloakAuthenticationToken) request.getUserPrincipal())
 * .getCredentials()).getToken(); AccessToken.Access access =
 * accessToken.getRealmAccess(); Set<String> rolesFromToken = access.getRoles();
 * for (String role : roles) { if (rolesFromToken.contains(role)) { return true;
 * } } return false; } }
 */