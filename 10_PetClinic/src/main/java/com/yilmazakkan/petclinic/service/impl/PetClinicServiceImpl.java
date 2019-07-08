package com.yilmazakkan.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazakkan.petclinic.dao.OwnerDao;
import com.yilmazakkan.petclinic.exception.OwnerNotFoundException;
import com.yilmazakkan.petclinic.model.Owner;
import com.yilmazakkan.petclinic.service.PetClinicService;

@Service
public class PetClinicServiceImpl implements PetClinicService {

	private OwnerDao ownerDao;
	
	@Autowired
	public void setOwnerDao(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}
	
	@Override
	public List<Owner> findOwners() {
		
		return ownerDao.findAll();
	}

	@Override
	public List<Owner> findOwners(String lastName) {
		
		return ownerDao.findByLastName(lastName);
	}

	@Override
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
		ownerDao.delete(id);

	}

}
