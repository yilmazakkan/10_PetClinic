package com.yilmazakkan.petclinic;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Order( value = 1)
@Configuration
public class RestSecurityConfiguration extends AbstractSecurityConfiguration {

@Override
protected void configure(HttpSecurity http) throws Exception {
	//super.configure(http);  //bunu kapatırsak rest ile başlayan isteklerde tarayıcı logini gelir açık olursa super.confire metodu bizim formlogin yönledirir.
	http.antMatcher("/rest/**");
	http.authorizeRequests().antMatchers("/rest/**").access("hasRole('EDITOR')");
	http.csrf().disable();
	http.httpBasic();
}
}
