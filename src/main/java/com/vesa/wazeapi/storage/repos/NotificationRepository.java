package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository  extends MongoRepository<NotificationEntity, String> {

    List<NotificationEntity> getNotificationEntityByToken(String token);

    List<NotificationEntity> getNotificationEntityByFcmId(String fcmId);

    List<NotificationEntity> getNotificationEntityByTitle(String fcmId);

    List<NotificationEntity> getNotificationEntityByMessageId(String messageId);

    @Query("{'created' : { '$gte' : ?0 }}")
    List<NotificationEntity> findByDateTime(LocalDateTime created);

}
