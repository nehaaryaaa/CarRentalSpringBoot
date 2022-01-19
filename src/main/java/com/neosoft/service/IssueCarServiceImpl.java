package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Car;
import com.neosoft.model.IssueCarBean;
import com.neosoft.repository.CarRepository;
import com.neosoft.repository.IssueCarRepository;

@Service
public class IssueCarServiceImpl implements IssueCarService{

	@Autowired
	private IssueCarRepository issueCarRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	@Override
	public IssueCarBean issueCar(IssueCarBean c) {
		boolean status=false;
		long carid=c.getCar().getCarid();
		c.setIssueddate(new java.sql.Date(System.currentTimeMillis()));
		c.setReturnstatus("No");
		Optional<Car> checkissue=carRepo.checkIssue(carid);
		int issued=checkissue.get().getIssued()+1;
		if(checkissue != null)
			status=true;
		IssueCarBean car=(status==true)?issueCarRepo.save(c):null;
		carRepo.updateIssueStatus(issued,carid);
		return car;
	}

	@Override
	public List<IssueCarBean> getAllIssuedCar() {
		return issueCarRepo.findAll();
	}

	@Override
	public Optional<IssueCarBean> findByCustomerId(long customerid) {
		return issueCarRepo.findById(customerid);
	}

	@Override
	public IssueCarBean updateIssueStatusAndReturnStatus(IssueCarBean bean, Car car) {
		int issued = car.getIssued()-1;
		long id = car.getCarid();
		car.setIssued(issued);
		carRepo.updateIssueStatus(issued, id);
		return issueCarRepo.save(bean);
	}
}
