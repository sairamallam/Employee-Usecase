package com.employee.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.employee.dto.ERecordStatus;
import com.employee.dto.EmployeeFamilyDeatilsDto;
import com.employee.dto.MessageDto;
import com.employee.exception.EmployeeException;
import com.employee.model.EmployeeDetails;
import com.employee.model.EmployeeFamilyDeatils;
import com.employee.model.identies.IdentityProofType;
import com.employee.model.identies.RelationShips;
import com.employee.model.repository.EmployeeFamilyDeatilsRepository;
import com.employee.service.IEmployeeFamilyDeatilsService;

public class EmployeeFamilyDeatilsService implements IEmployeeFamilyDeatilsService {
	@Autowired
	EmployeeFamilyDeatilsRepository employeeFamilyDeatilsRepository;

	@Override
	public ResponseEntity<MessageDto> addEmployeeIdentityProof(
			List<EmployeeFamilyDeatilsDto> employeeFamilyDeatilsDtos) {

		List<EmployeeFamilyDeatils> employeeFamilyDeatilsList = new ArrayList<>();

		employeeFamilyDeatilsDtos.stream().forEach(employeeFamilyDeatilsDto -> {

			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setEmployeeId(employeeFamilyDeatilsDto.getEmployeeId());

			IdentityProofType identityProofType = new IdentityProofType();
			identityProofType.setIdentityCardsTypeId(employeeFamilyDeatilsDto.getIdentityProofTypeId());

			RelationShips relationShips = new RelationShips();
			relationShips.setRelationShipId(employeeFamilyDeatilsDto.getRelationShipId());

			EmployeeFamilyDeatils employeeFamilyDeatils = new EmployeeFamilyDeatils();
			employeeFamilyDeatils.setEmployeeDetails(employeeDetails);
			employeeFamilyDeatils.setIdentityNumber(employeeFamilyDeatilsDto.getIdentityNumber());
			employeeFamilyDeatils.setIdentityProofType(identityProofType);
			employeeFamilyDeatils.setRelationShips(relationShips);
			employeeFamilyDeatils.setName(employeeFamilyDeatilsDto.getName());

			employeeFamilyDeatils.setEntryDate(LocalDateTime.now());
			employeeFamilyDeatils.setEntryUser(1L);
			employeeFamilyDeatils.setRecordStatus(ERecordStatus.ACTIVE.name());

			employeeFamilyDeatilsList.add(employeeFamilyDeatils);

		});
		employeeFamilyDeatilsRepository.saveAll(employeeFamilyDeatilsList);

		MessageDto messageDto = new MessageDto();
		messageDto.setMessage(" employee Employee Identity proof added sucessfully");
		return ResponseEntity.ok().body(messageDto);
	}

	@Override
	public ResponseEntity<MessageDto> updateEmployeeIdentityProof(EmployeeFamilyDeatilsDto employeeFamilyDeatilsDto) {

		Optional<EmployeeFamilyDeatils> employeeFamilyDeatilsOptional = employeeFamilyDeatilsRepository
				.findById(employeeFamilyDeatilsDto.getEmployeFamilyDetailsId());

		if (employeeFamilyDeatilsOptional.isPresent()) {

			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setEmployeeId(employeeFamilyDeatilsDto.getEmployeeId());

			IdentityProofType identityProofType = new IdentityProofType();
			identityProofType.setIdentityCardsTypeId(employeeFamilyDeatilsDto.getIdentityProofTypeId());

			RelationShips relationShips = new RelationShips();
			relationShips.setRelationShipId(employeeFamilyDeatilsDto.getRelationShipId());

			EmployeeFamilyDeatils employeeFamilyDeatils = new EmployeeFamilyDeatils();
			employeeFamilyDeatils.setEmployeeDetails(employeeDetails);
			employeeFamilyDeatils.setIdentityNumber(employeeFamilyDeatilsDto.getIdentityNumber());
			employeeFamilyDeatils.setIdentityProofType(identityProofType);
			employeeFamilyDeatils.setRelationShips(relationShips);
			employeeFamilyDeatils.setName(employeeFamilyDeatilsDto.getName());

			employeeFamilyDeatils.setEntryDate(LocalDateTime.now());
			employeeFamilyDeatils.setEntryUser(1L);
			employeeFamilyDeatils.setRecordStatus(ERecordStatus.ACTIVE.name());

			employeeFamilyDeatilsRepository.save(employeeFamilyDeatils);
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage(" employee Employee Identity proof added sucessfully");
			return ResponseEntity.ok().body(messageDto);
		} else {
			throw new EmployeeException("failed to update the employeeFamilyDeatils");

		}

	}

	@Override
	public ResponseEntity<EmployeeFamilyDeatilsDto> getEmployeeIdentityProof(Integer employeeFamilyDeatilsId) {

		Optional<EmployeeFamilyDeatils> employeeFamilyDeatilsOptional = employeeFamilyDeatilsRepository
				.findById(employeeFamilyDeatilsId);
		if (employeeFamilyDeatilsOptional.isPresent()) {
			EmployeeFamilyDeatils employeeFamilyDeatils = employeeFamilyDeatilsOptional.get();

			EmployeeFamilyDeatilsDto employeeFamilyDeatilsDto = new EmployeeFamilyDeatilsDto();

			employeeFamilyDeatilsDto.setEmployeFamilyDetailsId(employeeFamilyDeatils.getEmployeFamilyDetailsId());
			employeeFamilyDeatilsDto.setIdentityNumber(employeeFamilyDeatils.getIdentityNumber());
			employeeFamilyDeatilsDto
					.setIdentityProofTypeId(employeeFamilyDeatils.getIdentityProofType().getIdentityCardsTypeId());
			employeeFamilyDeatilsDto.setName(employeeFamilyDeatils.getName());
			employeeFamilyDeatilsDto.setRelationShipId(employeeFamilyDeatils.getRelationShips().getRelationShipId());
			employeeFamilyDeatilsDto.setEmployeFamilyDetailsId(employeeFamilyDeatils.getEmployeFamilyDetailsId());

			return ResponseEntity.ok().body(employeeFamilyDeatilsDto);
		} else {
			throw new EmployeeException("failed to get the employeeFamilyDeatils");

		}

	}

	@Override
	public ResponseEntity<List<EmployeeFamilyDeatilsDto>> getAllEmployeeIdentityProof() {

		List<EmployeeFamilyDeatils> employeeFamilyDeatilsList = employeeFamilyDeatilsRepository.findAll();
		
		List<EmployeeFamilyDeatilsDto> employeeFamilyDeatilsDtoList =new ArrayList<>();
				
		employeeFamilyDeatilsList.stream().forEach(employeeFamilyDeatils->{

		EmployeeFamilyDeatilsDto employeeFamilyDeatilsDto = new EmployeeFamilyDeatilsDto();

		employeeFamilyDeatilsDto.setEmployeFamilyDetailsId(employeeFamilyDeatils.getEmployeFamilyDetailsId());
		employeeFamilyDeatilsDto.setIdentityNumber(employeeFamilyDeatils.getIdentityNumber());
		employeeFamilyDeatilsDto
				.setIdentityProofTypeId(employeeFamilyDeatils.getIdentityProofType().getIdentityCardsTypeId());
		employeeFamilyDeatilsDto.setName(employeeFamilyDeatils.getName());
		employeeFamilyDeatilsDto.setRelationShipId(employeeFamilyDeatils.getRelationShips().getRelationShipId());
		employeeFamilyDeatilsDto.setEmployeFamilyDetailsId(employeeFamilyDeatils.getEmployeFamilyDetailsId());
		employeeFamilyDeatilsDtoList.add(employeeFamilyDeatilsDto);
		});
		return ResponseEntity.ok().body(employeeFamilyDeatilsDtoList);
	}

	@Override
	public ResponseEntity<MessageDto> deleteEmployee(Integer employeeFamilyDeatilsId) {
	
		employeeFamilyDeatilsRepository.deleteById(employeeFamilyDeatilsId);
		if(employeeFamilyDeatilsRepository.findById(employeeFamilyDeatilsId).isPresent()) {
			throw new EmployeeException("failed to delete the Identity Proof Type");

		}
		MessageDto messageDto = new MessageDto();
		messageDto.setMessage("identityProofType added sucessfully");
		return ResponseEntity.ok().body(messageDto);
	}

}
