package com.vesa.wazeapi.repos;

import com.vesa.wazeapi.entities.ReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<ReportEntity, String> {
}
