package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.AuditPayload;

@Repository
public interface AuditPayloadRepository extends MongoRepository<AuditPayload, Integer> {

	public boolean existsByEntityId(int entityId);

	public AuditPayload findByEntityId(int entityId);

	@Query("{'logDate': {$gt: ISODate(?1), $lt: ISODate(?2)}, 'patientId' : ?0}")
	public List<AuditPayload> findByPatientIdAndLogDateBetween(int patientId, Date startDate, Date endDate);

}
