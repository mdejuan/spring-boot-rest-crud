package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Owner;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
