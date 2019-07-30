package com.yilmazakkan.petclinic.service;

import java.util.List;

import javax.validation.Valid;

import com.yilmazakkan.petclinic.exception.OwnerNotFoundException;
import com.yilmazakkan.petclinic.exception.VetNotFoundException;
import com.yilmazakkan.petclinic.model.Owner;
import com.yilmazakkan.petclinic.model.Vet;

public interface PetClinicService {
	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	Owner findOwner(Long id) throws OwnerNotFoundException;
	void createOwner(@Valid Owner owner);  //interface @valid anatasyonunu ekliyoruz. eğer bir implemantasyon sınıf üzerinde veya metod üzeirnde gerçekleriyorsa interface methoda kullanılması şart
	void updateOwner(Owner owner);
	void deleteOwner(Long id);
	
	List<Vet> findsVet();
	Vet findVet(Long id) throws VetNotFoundException;
}
