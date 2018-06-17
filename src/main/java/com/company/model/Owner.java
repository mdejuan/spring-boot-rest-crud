package com.company.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "owner")
public class Owner {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Size(max = 250)
	private String name;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "company_id", updatable = false, insertable = true)
	private Company company;
	
	public Owner()
	{
		
	}

	public Owner(String name) {
		
		this.name = name;
		
	}
	
	public Owner(String name, Company company) {
		
		this.name = name;
		this.company = company;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
