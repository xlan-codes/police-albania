package com.vesa.wazeapi.services;

import com.vesa.wazeapi.dto.AlertDto;
import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.entities.AlertEntity;
import com.vesa.wazeapi.entities.UserEntity;
import com.vesa.wazeapi.interfaces.IService;
import com.vesa.wazeapi.repos.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements IService {

    @Autowired
    UserRepository repository;


    @Autowired
    ModelMapper modelMapper;

    public UserDto save(UserDto userDto) {
        UserEntity userEntity = this.convertToEntity(userDto);
       return this.convertToDto(this.repository.save(userEntity));
    }


    private UserDto convertToDto(UserEntity userEntity) {
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    private UserEntity convertToEntity(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        return userEntity;
    }
}
