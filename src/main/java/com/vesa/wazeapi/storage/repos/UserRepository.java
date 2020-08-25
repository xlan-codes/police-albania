package com.vesa.wazeapi.storage.repos;

import com.vesa.wazeapi.storage.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByEmail(String email);
}
