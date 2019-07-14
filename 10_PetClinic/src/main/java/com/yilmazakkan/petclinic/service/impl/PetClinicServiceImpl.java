package com.yilmazakkan.petclinic.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yilmazakkan.petclinic.dao.OwnerDao;
import com.yilmazakkan.petclinic.dao.PetDao;
import com.yilmazakkan.petclinic.exception.OwnerNotFoundException;
import com.yilmazakkan.petclinic.model.Owner;
import com.yilmazakkan.petclinic.service.PetClinicService;

@Service
@Transactional(rollbackFor = Exception.class )
public class PetClinicServiceImpl implements PetClinicService {

	private OwnerDao ownerDao;
	
	private PetDao petDao;
	
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
	public void createOwner(Owner owner) {
		ownerDao.create(owner);

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

}
