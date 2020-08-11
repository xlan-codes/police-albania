package com.vesa.wazeapi.repos;

import com.vesa.wazeapi.entities.AlertEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertRepository  extends MongoRepository<AlertEntity, String> {
}
