package com.globant.app.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthenticationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
		securityConfigurer
				.allowFormAuthenticationForClients();
	}

	@Override public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
		clientDetailsServiceConfigurer
				.inMemory()
				.withClient("CLIENT_ID")
				.authorizedGrantTypes("password", "authorization_code", "client_credentials", "implicit", "refresh_token")
				.authorities("ROLE_USER")
				.scopes("read", "write");
	}

	@Override public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws Exception {
		endpointsConfigurer
				.authenticationManager(authenticationManager);
	}
}
