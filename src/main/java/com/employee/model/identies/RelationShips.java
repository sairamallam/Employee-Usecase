package com.employee.model.identies;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class RelationShips {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer relationShipId;
	private String relationShipsValue;
	
	
	//madetory fields
	private LocalDateTime entryDate;
	private Integer	entryUser;
	private LocalDateTime removeDate;
	private Integer removeUser;
	private String recordStatus;
	

}
