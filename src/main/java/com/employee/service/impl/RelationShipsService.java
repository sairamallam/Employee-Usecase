package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.employee.dto.MessageDto;
import com.employee.dto.RelationShipsDto;
import com.employee.exception.EmployeeException;
import com.employee.model.identies.RelationShips;
import com.employee.model.identies.repository.RelationShipsRepository;
import com.employee.service.IRelationShipsService;

public class RelationShipsService implements IRelationShipsService {
	@Autowired
	RelationShipsRepository  relationShipsRepository;

	@Override
	public ResponseEntity<MessageDto> addRelationShips(RelationShipsDto relationShipsDto) {
		
		RelationShips  relationShips=new RelationShips();
		BeanUtils.copyProperties(relationShipsDto, relationShips);
		relationShipsRepository.save(relationShips);
		
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(relationShips.getRelationShipsValue() + " successfully saaved");

		return ResponseEntity.status(HttpStatus.OK).body(messageDto);
	}

	@Override
	public ResponseEntity<MessageDto> removeRelationShips(Integer relationShipsId) {
		relationShipsRepository.deleteById(relationShipsId);
		if(relationShipsRepository.findById(relationShipsId).isPresent()) {
			throw new EmployeeException("RelationShip not deleted");

		}else {

			MessageDto messageDto = new MessageDto();
			messageDto.setMessage("successfully deleted");

			return ResponseEntity.status(HttpStatus.OK).body(messageDto);
		}
	}

	@Override
	public ResponseEntity<List<RelationShipsDto>> getAllRelationShips() {

		List<RelationShips> relationShipsList = relationShipsRepository.findAll();
		List<RelationShipsDto> relationShipsDtos=new ArrayList<>();
		
		relationShipsList.forEach(relationShips->{
			RelationShipsDto relationShipsDto=new RelationShipsDto();
			BeanUtils.copyProperties(relationShips, relationShipsDto);
			relationShipsDtos.add(relationShipsDto);
		});
		return ResponseEntity.ok().body(relationShipsDtos);
	}
	
}
