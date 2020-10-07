package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.IdentityProofTypeDto;
import com.employee.dto.MessageDto;

public interface IIdentityProofTypeService {
	
	ResponseEntity<MessageDto> addIdentityProofType(IdentityProofTypeDto identityProofTypeDto);
	ResponseEntity<MessageDto> removeIdentityProofType(Integer identityProofTypeId);
	ResponseEntity<List<IdentityProofTypeDto>> getAllIdentityProofTypes();


}
