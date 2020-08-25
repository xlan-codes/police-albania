package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.AlertEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AlertRepository  extends MongoRepository<AlertEntity, String> {

    @Query("{'created' : { '$gte' : ?0 }}")
    List<AlertEntity> findAlertsGraterThan(LocalDateTime created);

    List<AlertEntity> findByParentType(String parentType);

}

