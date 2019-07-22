package com.yilmazakkan.petclinic;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration extends AbstractSecurityConfiguration {
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
		http.authorizeRequests().antMatchers("/**/favicon.ico","/css/**","/js/**","/images/**","/webjars/**","/login.html").permitAll(); // bu sayfalara log olmadan erişebilmeye izin verdik. login html eklemek zorundayız.
	//	http.authorizeRequests().antMatchers("/rest/**").access("hasRole('EDITOR')"); //database authorities editör olana rest ile ilgili herşeye girebilmesine izin verdik
		http.authorizeRequests().antMatchers("/actuator/**").access("hasRole('ADMIN')"); //database authorities admin olana  herşeye girebilmesine izin verdik rest - actuator 
		http.authorizeRequests().anyRequest().authenticated(); //conf çalışıyor login yok diyor açmıyor 403
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true"); // login sayfasına yönelebilmek için metodu çağırdık
		
		http.rememberMe().userDetailsService(userDetailsService); //beni hatırla için	
		
	//	http.httpBasic(); //http basic authentication "login" için
	}
	

}
