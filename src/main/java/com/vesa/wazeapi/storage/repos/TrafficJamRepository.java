package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.TrafficJamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrafficJamRepository extends MongoRepository<TrafficJamEntity, String> {

}
