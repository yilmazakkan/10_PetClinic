package com.yilmazakkan.petclinic.dao;

import java.util.List;

import com.yilmazakkan.petclinic.model.Owner;

public interface OwnerDao {
	List<Owner> findAll();
	Owner findById(Long id);
	List<Owner> findByLastName(String lastName);
	void create (Owner owner);
	Owner update(Owner owner);
	void delete(Long id);
		
}
