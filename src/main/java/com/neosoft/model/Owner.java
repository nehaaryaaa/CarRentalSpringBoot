package com.neosoft.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "owner")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Size(max = 10)
	private String mobile;
	
	@NotNull
	@Size(max = 50)
	private String email;
	
	@NotNull
	@Size(max = 20)
	private String password;
}
