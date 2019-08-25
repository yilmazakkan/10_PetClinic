package com.yilmazakkan.petclinic.security;





import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import com.yilmazakkan.petclinic.model.Owner;
import com.yilmazakkan.petclinic.service.PetClinicService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=dev")
public class PetClinicSecurityWithValidAuthTokenTests {

	@Autowired
	private PetClinicService petClinicService;
	
	@Before
	public void setUp() {
		TestingAuthenticationToken auth = new TestingAuthenticationToken("user", "secret","ROLE_USER"); // yetki uygun 
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	@After
	public void tearDown() {
		SecurityContextHolder.clearContext();
	}
	
	@Test
	public void testFindOwners() {
		List<Owner> owners = petClinicService.findOwners();
		MatcherAssert.assertThat(owners.size(), Matchers.equalTo(10));
	}
}
