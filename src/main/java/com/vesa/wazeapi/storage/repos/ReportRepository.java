package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.ReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<ReportEntity, String> {
}
