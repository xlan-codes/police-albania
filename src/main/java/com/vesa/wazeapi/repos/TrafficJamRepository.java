package com.vesa.wazeapi.repos;

import com.vesa.wazeapi.entities.TrafficJamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrafficJamRepository extends MongoRepository<TrafficJamEntity, String> {

}
