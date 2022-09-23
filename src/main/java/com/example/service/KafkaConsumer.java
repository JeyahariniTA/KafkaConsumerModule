package com.example.service;

import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.model.AuditPayload;
import com.example.repository.AuditPayloadRepository;

@Service
public class KafkaConsumer {

	@Autowired
	AuditPayloadRepository auditPayloadRepository;

	private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "vitalsigns", groupId = "group-id")
	public void consumeAdd(String jsonString) {
		logger.info("consumes message: " + jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);
		AuditPayload auditPayload = new AuditPayload();
		if (jsonObject.has("patientId")) {
			logger.info(" jsonObject has patient id: " + jsonObject.getInt("patientId"));
			auditPayload.setPatientId(jsonObject.getInt("patientId"));
		}

		auditPayload.setAction(jsonObject.optString("action"));
		auditPayload.setDescription(jsonObject.optString("description"));
		auditPayload.setEntityType(jsonObject.optString("entityType"));
		auditPayload.setUserName(jsonObject.optString("username"));
		auditPayload.setAttribute(jsonObject.optString("attributes"));
		auditPayload.setEntityId(jsonObject.optInt("entityId"));
		Date now = new Date();
		auditPayload.setLogDate(now);
		auditPayloadRepository.save(auditPayload);
		logger.info("message saved successfully");
	}

}
