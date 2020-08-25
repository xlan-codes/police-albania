package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.HazardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HazardRepository extends MongoRepository<HazardEntity, String> {

}