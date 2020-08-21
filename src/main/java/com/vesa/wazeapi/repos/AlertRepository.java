package com.vesa.wazeapi.repos;

import com.vesa.wazeapi.entities.AlertEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AlertRepository  extends MongoRepository<AlertEntity, String> {

    @Query("{'created' : { '$gte' : ?0 }}")
    List<AlertEntity> findAlertsGraterThan(LocalDateTime created);

}
