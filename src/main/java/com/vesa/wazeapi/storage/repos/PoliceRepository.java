package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.PoliceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PoliceRepository extends MongoRepository<PoliceEntity, String> {
}
