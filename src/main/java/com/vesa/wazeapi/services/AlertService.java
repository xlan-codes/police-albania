package com.vesa.wazeapi.services;

import com.vesa.wazeapi.dto.AlertDto;
import com.vesa.wazeapi.storage.entities.AlertEntity;
import com.vesa.wazeapi.storage.repos.AlertRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertService extends BaseService {

    @Autowired
    AlertRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public List<AlertDto> getAlert() {
        return this.repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<AlertDto> findByParentType(String type) {
        return this.repository.findByParentType(type).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<AlertDto> findByParentTypeAndDate(String type, LocalDateTime localDateTime) {
        return this.repository.findByParentType(type).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public AlertDto findOne(String id) {
        AlertEntity alertEntity = this.repository.findById(id).get();
        return alertEntity == null ? null : this.convertToDto(alertEntity);
    }

    public List<AlertDto> getLatestAlerts(LocalDateTime localDateTime) {
        return this.repository.findAlertsGraterThan(localDateTime).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public AlertDto save(AlertDto alertDto) {
        AlertEntity alertEntity = this.repository.save(convertToEntity(alertDto));
        return convertToDto(alertEntity);
    }

    public AlertDto update(AlertDto alertDto) {
        AlertEntity alertEntity = this.repository.save(convertToEntity(alertDto));
        return convertToDto(alertEntity);
    }

    private AlertDto convertToDto(AlertEntity alertEntity) {
        AlertDto alertDto = modelMapper.map(alertEntity, AlertDto.class);
        return alertDto;
    }

    private AlertEntity convertToEntity(AlertDto alertDto) {
        AlertEntity alertEntity = modelMapper.map(alertDto, AlertEntity.class);
        return alertEntity;
    }

}
