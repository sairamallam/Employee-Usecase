/**
 * 
 */
package com.employee.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.employee.dto.ERecordStatus;
import com.employee.dto.EmployeeIdentityProofDto;
import com.employee.dto.MessageDto;
import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeDetails;
import com.employee.model.EmployeeIdentityProof;
import com.employee.model.identies.IdentityProofType;
import com.employee.model.repository.EmployeeIdentityProofRepository;
import com.employee.service.IEmployeeIdentityProofService;

/**
 * @author admin
 *
 */
public class EmployeeIdentityProofService implements IEmployeeIdentityProofService {
	@Autowired
	EmployeeIdentityProofRepository employeeIdentityProofRepository;

	@Override
	public ResponseEntity<MessageDto> addEmployeeIdentityProof(
			List<EmployeeIdentityProofDto> employeeIdentityProofDtos) {
		
		List<EmployeeIdentityProof> employeeIdentityProofList=new ArrayList<>();
		
		employeeIdentityProofDtos.stream().forEach(employeeIdentityProofDto->{
			
			EmployeeDetails employeeDetails=new EmployeeDetails();
			employeeDetails.setEmployeeId(employeeIdentityProofDto.getEmployeeId());
			
			IdentityProofType identityProofType=new IdentityProofType();
			identityProofType.setIdentityCardsTypeId(employeeIdentityProofDto.getIdentityProofTypeId());
			
			EmployeeIdentityProof employeeIdentityProof=new EmployeeIdentityProof();
			employeeIdentityProof.setEmployeeDetails(employeeDetails);
			employeeIdentityProof.setEmployeeIdentityProofPath("path");
			employeeIdentityProof.setIdentityProofType(identityProofType);
			employeeIdentityProof.setIdentityProofValue(employeeIdentityProofDto.getIdentityProofValue());
			
			employeeIdentityProof.setEntryDate(LocalDateTime.now());
			employeeIdentityProof.setRecordStatus(ERecordStatus.ACTIVE.name());
			employeeIdentityProof.setEntryUser(1L);
			
			employeeIdentityProofList.add(employeeIdentityProof);
		});
		employeeIdentityProofRepository.saveAll(employeeIdentityProofList);
		
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(" employee add sucessfully");
		return ResponseEntity.ok().body(messageDto);
		
	}

	@Override
	public ResponseEntity<MessageDto> updateEmployeeIdentityProof(EmployeeIdentityProofDto employeeIdentityProofDto) {
		EmployeeDetails employeeDetails=new EmployeeDetails();
		employeeDetails.setEmployeeId(employeeIdentityProofDto.getEmployeeId());
		
		IdentityProofType identityProofType=new IdentityProofType();
		identityProofType.setIdentityCardsTypeId(employeeIdentityProofDto.getIdentityProofTypeId());
		
		EmployeeIdentityProof employeeIdentityProof=new EmployeeIdentityProof();
		employeeIdentityProof.setEmployeeIdentityProofId(employeeIdentityProofDto.getEmployeeIdentityProofId());
		employeeIdentityProof.setEmployeeDetails(employeeDetails);
		employeeIdentityProof.setEmployeeIdentityProofPath("path");
		employeeIdentityProof.setIdentityProofType(identityProofType);
		employeeIdentityProof.setIdentityProofValue(employeeIdentityProofDto.getIdentityProofValue());
		
		employeeIdentityProof.setEntryDate(LocalDateTime.now());
		employeeIdentityProof.setRecordStatus(ERecordStatus.ACTIVE.name());
		employeeIdentityProof.setEntryUser(1L);
		
		employeeIdentityProofRepository.save(employeeIdentityProof);
		
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(" employee updated sucessfully");
		return ResponseEntity.ok().body(messageDto);
	}

	@Override
	public ResponseEntity<EmployeeIdentityProofDto> getEmployeeIdentityProof(Integer employeeIdentityProofId) {
		
		Optional<EmployeeIdentityProof> employeeIdentityProofOption = employeeIdentityProofRepository.findById(employeeIdentityProofId);
		
		if(employeeIdentityProofOption.isPresent()) {
			EmployeeIdentityProof employeeIdentityProof = employeeIdentityProofOption.get();
			EmployeeIdentityProofDto employeeIdentityProofDto=new EmployeeIdentityProofDto();
			employeeIdentityProofDto.setEmployeeId(employeeIdentityProof.getEmployeeDetails().getEmployeeId());
			employeeIdentityProofDto.setIdentityProofTypeId(employeeIdentityProof.getIdentityProofType().getIdentityCardsTypeId());
			employeeIdentityProofDto.setIdentityProofValue(employeeIdentityProof.getIdentityProofValue());
			
			return ResponseEntity.ok().body(employeeIdentityProofDto);
		}else {
			throw new EmployeeException("failed get Employee Identity Proof");
	}
	}

	@Override
	public ResponseEntity<List<EmployeeIdentityProofDto>> getAllEmployeeIdentityProof() {
		List<EmployeeIdentityProof> employeeIdentityProofOptionList = employeeIdentityProofRepository.findAll();
		
		List<EmployeeIdentityProofDto> employeeIdentityProofDtoList=new ArrayList<>();
		employeeIdentityProofOptionList.stream().forEach(employeeIdentityProof->{
			EmployeeIdentityProofDto employeeIdentityProofDto=new EmployeeIdentityProofDto();
			employeeIdentityProofDto.setEmployeeId(employeeIdentityProof.getEmployeeDetails().getEmployeeId());
			employeeIdentityProofDto.setIdentityProofTypeId(employeeIdentityProof.getIdentityProofType().getIdentityCardsTypeId());
			employeeIdentityProofDto.setIdentityProofValue(employeeIdentityProof.getIdentityProofValue());
			employeeIdentityProofDtoList.add(employeeIdentityProofDto);
		});
		
		return ResponseEntity.ok().body(employeeIdentityProofDtoList);
	}

	@Override
	public ResponseEntity<MessageDto> deleteEmployee(Integer employeeIdentityProofId) {
	 employeeIdentityProofRepository.deleteById(employeeIdentityProofId);
	 if( employeeIdentityProofRepository.findById(employeeIdentityProofId).isPresent()) {
			throw new EmployeeException("failed delete Employee Identity Proof");

	 }else {
			
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage(" employee updated sucessfully");
			return ResponseEntity.ok().body(messageDto);
	 }
	}

}
