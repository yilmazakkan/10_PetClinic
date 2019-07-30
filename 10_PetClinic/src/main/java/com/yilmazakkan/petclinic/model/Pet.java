package com.yilmazakkan.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity {
	
	
	@Column(name = "name")
	private String name;
	@Column(name = "birth_Date")
	private Date birthDate;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" +getId()+"name=" + name + ", birthDate=" + birthDate + ", owner=" + owner + "]";
	}
	
	
	
}
