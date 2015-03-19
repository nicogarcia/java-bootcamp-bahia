package com.globant.app.security.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

	@Override public void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
				.requestMatchers().anyRequest()
			.and()
				.authorizeRequests().anyRequest().permitAll();
		//@formatter:on
	}

	@Override public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

	}
}
