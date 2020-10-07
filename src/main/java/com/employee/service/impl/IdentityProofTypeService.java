package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.employee.dto.IdentityProofTypeDto;
import com.employee.dto.MessageDto;
import com.employee.exception.EmployeeException;
import com.employee.model.identies.IdentityProofType;
import com.employee.model.identies.repository.IdentityProofTypeRepository;
import com.employee.service.IIdentityProofTypeService;

public class IdentityProofTypeService implements IIdentityProofTypeService {

	@Autowired
	IdentityProofTypeRepository identityProofTypeRepository;
	@Override
	public ResponseEntity<MessageDto> addIdentityProofType(IdentityProofTypeDto identityProofTypeDto) {

		IdentityProofType identityProofType=new IdentityProofType();
		BeanUtils.copyProperties(identityProofTypeDto, identityProofType);
		
		identityProofTypeRepository.save(identityProofType);
		
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage("identityProofType added sucessfully");
		return ResponseEntity.ok().body(messageDto);

	}

	@Override
	public ResponseEntity<MessageDto> removeIdentityProofType(Integer identityProofTypeId) {
		identityProofTypeRepository.deleteById(identityProofTypeId);
		if(identityProofTypeRepository.findById(identityProofTypeId).isPresent()) {
			throw new EmployeeException("failed to delete the Identity Proof Type");

		}
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage("identityProofType added sucessfully");
		return ResponseEntity.ok().body(messageDto);

	}

	@Override
	public ResponseEntity<List<IdentityProofTypeDto>> getAllIdentityProofTypes() {
		List<IdentityProofType> identityProofTypes = identityProofTypeRepository.findAll();
		
		List<IdentityProofTypeDto> identityProofTypeDtoList=new ArrayList<>();
		identityProofTypes.forEach(identityProofType->{
			IdentityProofTypeDto identityProofTypeDto=new IdentityProofTypeDto();
			BeanUtils.copyProperties(identityProofType, identityProofTypeDto);
			identityProofTypeDtoList.add(identityProofTypeDto);
		});
		return ResponseEntity.ok().body(identityProofTypeDtoList);
	}

}
