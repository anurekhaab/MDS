/*
 * package com.smartship.mds.keyclock;
 * 
 * import org.keycloak.adapters.springsecurity.authentication.
 * KeycloakAuthenticationProvider; import
 * org.keycloak.adapters.springsecurity.config.
 * KeycloakWebSecurityConfigurerAdapter; import
 * org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
 * import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
 * import org.springframework.security.core.session.SessionRegistryImpl; import
 * org.springframework.security.web.authentication.session.
 * RegisterSessionAuthenticationStrategy; import
 * org.springframework.security.web.authentication.session.
 * SessionAuthenticationStrategy;
 * 
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
 * 
 * @ComponentScan(value = "com.smartship.mds.keyclock") public class
 * SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) {
 * SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
 * grantedAuthorityMapper.setPrefix("ROLE_");
 * 
 * KeycloakAuthenticationProvider keycloakAuthenticationProvider =
 * keycloakAuthenticationProvider();
 * keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(
 * grantedAuthorityMapper);
 * auth.authenticationProvider(keycloakAuthenticationProvider); }
 * 
 * @Bean protected HttpSessionManager httpSessionManager() { return new
 * HttpSessionManager(); }
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * super.configure(http); http.authorizeRequests().anyRequest().permitAll();
 * http.csrf().disable(); }
 * 
 * @Bean
 * 
 * @Override protected SessionAuthenticationStrategy
 * sessionAuthenticationStrategy() { return new
 * RegisterSessionAuthenticationStrategy(new SessionRegistryImpl()); }
 * 
 * @Override protected KeycloakPreAuthActionsFilter
 * keycloakPreAuthActionsFilter() { return new
 * RequestFilter(httpSessionManager()); }
 * 
 * }
 */