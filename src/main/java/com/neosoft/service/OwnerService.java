package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Owner;

public interface OwnerService {

	Owner addOwner(Owner owner);

	List<Owner> getAllOwners();

	void deleteOwnerById(Long id);

	Owner getOwnerById(Long id);

	Owner updateOwner(Owner owner);

	Owner getOwnerByEmail(String email);

	Owner getOwnerByPassword(String password);
}
