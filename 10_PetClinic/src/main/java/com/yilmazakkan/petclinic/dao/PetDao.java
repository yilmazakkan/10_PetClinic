package com.yilmazakkan.petclinic.dao;

import java.util.List;

import com.yilmazakkan.petclinic.model.Pet;

public interface PetDao {
	Pet findById(Long id);
	List<Pet> findByOwnerId(Long ownerId);
	void create (Pet pet);
	Pet update(Pet pet);
	void delete(Long id);
	void deleteByOwnerId(Long ownerId);
	
}
