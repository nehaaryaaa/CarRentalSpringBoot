package com.neosoft.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name = "issue_car")
public class IssueCarBean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerid;
	
	@NotNull
	@Column(name = "customer_name")
	private String customername;
	
	@NotNull
	@Size(max = 10)
	private String customermobile;
	
	@ManyToOne
	@JoinColumn(name = "car_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car;
	
	@NotNull
	@Column(name = "duration_in_hour")
	private int durationinhours;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date")
	private Date issueddate;
	
	@NotNull
	@Column(name = "returnstatus")
	private String returnstatus;
	

	
}
/*CREATE TABLE  IF NOT EXISTS IssueCar 
   (	carId VARCHAR(500) NOT NULL, 
	CUSTOMERID VARCHAR(500) NOT NULL, 
	CUSTOMERNAME VARCHAR(500), 
	CUSTOMERMOBILE INT, 
	DURATIONINHOURS INT NOT NULL,
	ISSUEDDATE DATE, 
	RETURNSTATUS VARCHAR(500)
   )
; */