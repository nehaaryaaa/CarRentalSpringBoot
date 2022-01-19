package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{

	Owner findByEmail(String email);

	Owner findByPassword(String password);

}
