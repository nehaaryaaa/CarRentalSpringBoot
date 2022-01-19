package com.neosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.neosoft.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

	@Query("SELECT c FROM Car c WHERE car_id = :carid AND quantity > issued")
	Optional<Car> checkIssue(Long carid);
	
	@Transactional
	@Modifying
	@Query("UPDATE Car c SET c.issued = :issued_status WHERE c.carid = :carid") //done
	int updateIssueStatus(int issued_status, long carid);
	
}
