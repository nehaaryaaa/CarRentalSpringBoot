package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import com.neosoft.model.Car;
import com.neosoft.model.IssueCarBean;

public interface IssueCarService{

	IssueCarBean issueCar(IssueCarBean c);

	List<IssueCarBean> getAllIssuedCar();

	Optional<IssueCarBean> findByCustomerId(long customerid);

	IssueCarBean updateIssueStatusAndReturnStatus(IssueCarBean bean, Car car);
}
