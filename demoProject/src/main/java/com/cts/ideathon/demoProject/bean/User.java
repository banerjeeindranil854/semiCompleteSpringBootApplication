package com.cts.ideathon.demoProject.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "The database generated user ID")
	private Long id;
	@ApiModelProperty(notes = "The user name")
	private String name;
	@ApiModelProperty(notes = "The user passport")
	private String passportNumber;

	public User() {
    super();
  }

	public User(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
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

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
}
