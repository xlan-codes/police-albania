package com.vesa.wazeapi.services;

import com.vesa.wazeapi.dto.NotificationDto;
import com.vesa.wazeapi.storage.entities.NotificationEntity;
import com.vesa.wazeapi.storage.repos.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService extends BaseService {


    @Autowired
    NotificationRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public List<NotificationDto> getAll() {
        return this.repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }


    public List<NotificationDto> findByToken(String token) {
        return this.repository.getNotificationEntityByToken(token).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<NotificationDto> findByFcmId(String fcmId) {
        return this.repository.getNotificationEntityByFcmId(fcmId).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<NotificationDto> findByMessageId(String messageId) {
        return this.repository.getNotificationEntityByMessageId(messageId).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public NotificationDto findOne(String id) {
        NotificationEntity entity = this.repository.findById(id).get();
        return entity == null ? null : this.convertToDto(entity);
    }

    public List<NotificationDto> getLatestAlerts(LocalDateTime localDateTime) {
        return this.repository.findByDateTime(localDateTime).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public NotificationDto save(NotificationDto dto) {
        NotificationEntity entity = this.repository.save(convertToEntity(dto));
        return convertToDto(entity);
    }

    public NotificationDto update(NotificationDto dto) {
        NotificationEntity entity = this.repository.save(convertToEntity(dto));
        return convertToDto(entity);
    }

    private NotificationDto convertToDto(NotificationEntity entity) {
        NotificationDto dto = modelMapper.map(entity, NotificationDto.class);
        return dto;
    }

    private NotificationEntity convertToEntity(NotificationDto dto) {
        NotificationEntity entity = modelMapper.map(dto, NotificationEntity.class);
        return entity;
    }

}
