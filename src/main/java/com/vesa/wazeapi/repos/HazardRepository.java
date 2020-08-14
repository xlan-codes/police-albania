package com.vesa.wazeapi.repos;

import com.vesa.wazeapi.entities.HazardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HazardRepository extends MongoRepository<HazardEntity, String> {

}