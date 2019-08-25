package com.yilmazakkan.petclinic.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilmazakkan.petclinic.model.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {

}
