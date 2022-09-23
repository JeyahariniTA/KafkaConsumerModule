package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuditPayload;
import com.example.service.AuditPayloadService;

@RestController
@RequestMapping("/auditpayload")
public class AuditPayloadController {

	@Autowired
	AuditPayloadService auditPayloadService;

	@GetMapping(path = "/get")
	public List<AuditPayload> listAuditPayloads() {
		return auditPayloadService.listAuditPayloads();
	}

	@GetMapping(path = "/get/{id}")
	public AuditPayload getAuditPayloadById(@RequestParam("id") int id) {
		return auditPayloadService.fetchAuditPayloadById(id);
	}

	@PostMapping(path = "/add")
	public AuditPayload addAuditPayload(@RequestBody AuditPayload auditPayload) {
		return auditPayloadService.addAuditPayload(auditPayload);
	}

	@PutMapping(path = "/update")
	public AuditPayload updateAuditPayload(@RequestBody AuditPayload auditPayload) {
		return auditPayloadService.updateAuditPayload(auditPayload);
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteAuditPayload(@RequestParam("id") int id) {
		return auditPayloadService.deleteAuditPayload(id);
	}

	@GetMapping(path = "/getPatientByIdAndDate/{patientId}/{startDate}/{endDate}")
	public List<AuditPayload> getByPatientIdAndDate(@RequestParam("patientId") int patientId,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
		return auditPayloadService.getByPatientIdAndDate(patientId, startDate, endDate);
	}

}
