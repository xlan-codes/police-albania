package com.vesa.wazeapi.services;

import com.vesa.wazeapi.dto.AlertDto;
import com.vesa.wazeapi.entities.AlertEntity;
import com.vesa.wazeapi.repos.AlertRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
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

    public AlertDto save(AlertDto alertDto) {
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
