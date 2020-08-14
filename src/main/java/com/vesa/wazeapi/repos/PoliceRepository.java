package com.vesa.wazeapi.repos;

import com.vesa.wazeapi.entities.PoliceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PoliceRepository extends MongoRepository<PoliceEntity, String> {
}
