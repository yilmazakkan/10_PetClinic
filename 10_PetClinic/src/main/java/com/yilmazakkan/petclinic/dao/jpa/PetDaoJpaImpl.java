package com.yilmazakkan.petclinic.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.yilmazakkan.petclinic.dao.PetDao;
import com.yilmazakkan.petclinic.model.Pet;

@Primary
@Repository("petRepository")         //iki aynı isimli bean kullanılmaz öncelik vericeksin primary yada isim//
public class PetDaoJpaImpl implements PetDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Pet findById(Long id) {
		
		return entityManager.find(Pet.class, id);
	}

	@Override
	public List<Pet> findByOwnerId(Long ownerId) {
		
		return entityManager.createQuery("from Pet where owner.id = :ownerId", Pet.class).setParameter("ownerId", ownerId).getResultList();
	}
	@Override
	public void create(Pet pet) {
		entityManager.persist(pet);

	}

	@Override
	public Pet update(Pet pet) {
	
		return entityManager.merge(pet);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Pet.class, id));

	}

	@Override
	public void deleteByOwnerId(Long ownerId) {
		entityManager.createQuery("delete from Pet where owner.id = :ownerId").setParameter("ownerId", ownerId).executeUpdate();

	}

}
