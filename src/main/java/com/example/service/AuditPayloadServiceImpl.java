package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AuditPayload;
import com.example.repository.AuditPayloadRepository;

@Service
public class AuditPayloadServiceImpl implements AuditPayloadService {

	@Autowired
	AuditPayloadRepository auditPayloadRepository;

	@Override
	public List<AuditPayload> listAuditPayloads() {
		return auditPayloadRepository.findAll();
	}

	@Override
	public AuditPayload fetchAuditPayloadById(int id) {
		if (auditPayloadRepository.existsById(id)) {
			return auditPayloadRepository.findById(id).get();
		}
		return new AuditPayload();
	}

	@Override
	public AuditPayload addAuditPayload(AuditPayload auditPayload) {
		return auditPayloadRepository.save(auditPayload);
	}

	@Override
	public AuditPayload updateAuditPayload(AuditPayload auditPayload) {

		return auditPayloadRepository.save(auditPayload);

	}

	@Override
	public String deleteAuditPayload(int id) {
		if (auditPayloadRepository.existsById(id)) {
			auditPayloadRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Provide valid id to delete";

	}

	public AuditPayload fetchAuditPayloadByEntityId(int id) {
		if (auditPayloadRepository.existsByEntityId(id)) {
			return auditPayloadRepository.findByEntityId(id);
		}
		return new AuditPayload();
	}

	@Override
	public List<AuditPayload> getByPatientIdAndDate(int patientId, Date startDate, Date endDate) {
		return auditPayloadRepository.findByPatientIdAndLogDateBetween(patientId, startDate, endDate);
	}

}
