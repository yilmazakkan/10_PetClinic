package com.yilmazakkan.petclinic.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yilmazakkan.petclinic.model.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles
@Transactional
public class OwnerRepositoryTests {

	@Autowired
	private OwnerDao ownerDao;
	
	@PersistenceContext
	private EntityManager entityManager;  //1.adım positeve false hatasını düzelmek için database null değer alması gerektiği halde true döndürdü.
		
	@Test(expected = PersistenceException.class) //bu bizim beklediğimiz bir exception olduğunu ve hata olmasına rağmen beklediğimiz sonuc olduğunu gösterir olumlu anlamda null değeri olmaması gerektiğini denedik.
	public void testCreateOwner() {			
		Owner owner = new Owner();
		owner.setFirstName(null);
		owner.setLastName(null);
		
		ownerDao.create(owner);
		
		entityManager.flush(); //2.adım contexteki değişikleri veritabanına yatsıtyıcaz.
	}
}
