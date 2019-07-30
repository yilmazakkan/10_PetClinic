package com.yilmazakkan.petclinic.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.yilmazakkan.petclinic.dao.OwnerDao;
import com.yilmazakkan.petclinic.dao.PetDao;
import com.yilmazakkan.petclinic.dao.jpa.VetRepository;
import com.yilmazakkan.petclinic.exception.OwnerNotFoundException;
import com.yilmazakkan.petclinic.exception.VetNotFoundException;
import com.yilmazakkan.petclinic.model.Owner;
import com.yilmazakkan.petclinic.model.Vet;
import com.yilmazakkan.petclinic.service.PetClinicService;

@Validated //sınıf düzeyinde validated anatasyonunu koymamız lazım
@Service
@Transactional(rollbackFor = Exception.class )
public class PetClinicServiceImpl implements PetClinicService {

	private OwnerDao ownerDao;
	
	private PetDao petDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	private VetRepository vetRepository;
	
	@Autowired
	public void setVetRepository(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Autowired
	public void setOwnerDao(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}
	
	@Autowired
	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@Secured(value = {"ROLE_USER","ROLE_EDITOR"})
	public List<Owner> findOwners() {
		
		return ownerDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<Owner> findOwners(String lastName) {
		
		return ownerDao.findByLastName(lastName);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Owner findOwner(Long id) throws OwnerNotFoundException {
		return ownerDao.findById(id);
	}

	@Override
	@CacheEvict(cacheNames = "allOwners",allEntries = true)  //bu method çalıştığı zaman allOwnersdaki bütün değerler temizlenicek
	public void createOwner(@Valid Owner owner) {  // valid anatasyonunu burayada koyuyoruz interfacedeki ilgili methoda da
		ownerDao.create(owner);
		
		SimpleMailMessage msg =  new SimpleMailMessage();
		msg.setFrom("k@s.com");
		msg.setTo("m@y.com");
		msg.setSubject("Owner Created!!");
		msg.setText("Owner entity with id :" + owner.getId() + " Creted Successfully.");
		mailSender.send(msg);

	}

	@Override
	public void updateOwner(Owner owner) {
		ownerDao.update(owner);

	}

	@Override
	public void deleteOwner(Long id) {
		petDao.deleteByOwnerId(id);
		ownerDao.delete(id);
	//	if (true) throw new RuntimeException("testing rollback");
			
		

	}

	@Override
	public List<Vet> findsVet() {
	
			return vetRepository.findAll();

	}

	@Override
	public Vet findVet(Long id) throws VetNotFoundException {
		return vetRepository.findById(id).orElseThrow(()->{return new VetNotFoundException("Vet not found by id :" + id);});
	}


}
