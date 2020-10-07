package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.MessageDto;
import com.employee.dto.RelationShipsDto;

public interface IRelationShipsService {
	
	
	
	
	ResponseEntity<MessageDto> addRelationShips(RelationShipsDto relationShipsDto);
	ResponseEntity<MessageDto> removeRelationShips(Integer relationShipsId);
	ResponseEntity<List<RelationShipsDto>> getAllRelationShips();


}
