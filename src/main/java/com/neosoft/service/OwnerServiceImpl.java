package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Owner;
import com.neosoft.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Override
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	@Override
	public List<Owner> getAllOwners(){
		return ownerRepository.findAll();
	}

	@Override
	public void deleteOwnerById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner getOwnerById(Long id) {
		return ownerRepository.findById(id).get();
	}

	@Override
	public Owner updateOwner(Owner existingOwner) {
		return ownerRepository.save(existingOwner);
	}

	@Override
	public Owner getOwnerByEmail(String email) {
		
		return ownerRepository.findByEmail(email);
	}

	@Override
	public Owner getOwnerByPassword(String password) {
		
		return ownerRepository.findByPassword(password);
	}

}
