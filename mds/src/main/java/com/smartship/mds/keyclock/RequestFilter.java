/*
 * package com.smartship.mds.keyclock;
 * 
 * 
 * 
 * import java.io.IOException; import java.util.Arrays; import
 * java.util.HashMap; import java.util.Map;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.ServletRequest; import javax.servlet.ServletResponse;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.keycloak.TokenVerifier; import
 * org.keycloak.adapters.spi.UserSessionManagement; import
 * org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
 * import org.keycloak.common.VerificationException; import
 * org.keycloak.representations.AccessToken; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.stereotype.Component;
 * 
 * import com.smartship.mds.keyclock.CustomerContext; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @Component public class RequestFilter extends KeycloakPreAuthActionsFilter {
 * 
 * 
 * public RequestFilter(UserSessionManagement userSessionManagement) {
 * super(userSessionManagement); }
 * 
 * public RequestFilter() { super(); }
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletRequest httpServletRequest = (HttpServletRequest) request;
 * httpServletRequest.getHeaderNames(); if
 * (httpServletRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
 * HttpServletResponse httpServletResponse = (HttpServletResponse) response;
 * httpServletResponse.sendError(HttpStatus.OK.value()); return; } if (null ==
 * httpServletRequest.getHeader("Authorization")) {
 * this.sendAccessDeniedErrorResponse("Authorization header not present",
 * response); return; } AccessToken token = null; try { token = TokenVerifier
 * .create(httpServletRequest.getHeader("Authorization").replace("Bearer ", ""),
 * AccessToken.class) .getToken(); } catch (VerificationException e) {
 * this.sendAccessDeniedErrorResponse("Unable to extract token information",
 * response); return; } if (null == token) {
 * this.sendAccessDeniedErrorResponse("Token should not be null", response);
 * return; } CustomerContext context = this.extractCustomerContext(token);
 * if(null==context ||
 * !context.getAllowedClients().contains(token.getIssuedFor())) {
 * this.sendAccessDeniedErrorResponse("Unauthorized client", response); return;
 * } super.doFilter(request, response, chain); }
 * 
 * private void sendAccessDeniedErrorResponse(String message, ServletResponse
 * servletResponse) { HttpServletResponse httpServletResponse =
 * (HttpServletResponse) servletResponse;
 * 
 * Map<String, Object> errorDetails = new HashMap<>();
 * errorDetails.put("message", message);
 * 
 * httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
 * httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE); final
 * ObjectMapper mapper = new ObjectMapper(); try {
 * mapper.writeValue(httpServletResponse.getWriter(), errorDetails); } catch
 * (IOException e) { e.printStackTrace(); } }
 * 
 * private CustomerContext extractCustomerContext(AccessToken token) { String[]
 * segments = token.getIssuer().split("/"); String realm =
 * segments[segments.length - 1]; return new CustomerContext("public-library",
 * "spring-boot-app", Arrays.asList("spring-boot-app")); }
 * 
 * }
 */