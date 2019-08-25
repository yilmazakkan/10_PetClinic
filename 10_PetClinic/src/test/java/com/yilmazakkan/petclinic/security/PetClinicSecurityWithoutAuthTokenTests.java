package com.yilmazakkan.petclinic.security;

import javax.naming.AuthenticationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.yilmazakkan.petclinic.service.PetClinicService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=dev")
public class PetClinicSecurityWithoutAuthTokenTests {

	@Autowired
	private PetClinicService petClinicService;
	
	@Test(expected = AuthenticationCredentialsNotFoundException.class)  //yetki yok
	public void testFindOwners() {
		petClinicService.findOwners();
	}
}
