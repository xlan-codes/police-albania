package com.vesa.wazeapi.services;

import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.entities.UserEntity;
import com.vesa.wazeapi.interfaces.IService;
import com.vesa.wazeapi.repos.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService  implements IService {

    @Autowired
    UserRepository repository;


    @Autowired
    ModelMapper modelMapper;

    public UserDto save(UserDto userDto) {
        UserEntity userEntity = this.convertToEntity(userDto);
       return this.convertToDto(this.repository.insert(userEntity));
    }

    public UserDto update(UserDto userDto) {
        UserEntity userEntity = this.convertToEntity(userDto);
       return this.convertToDto(this.repository.save(userEntity));
    }

    public void delete(String id) {
       this.repository.deleteById(id);
    }

    public UserDto get(String id) {
       Optional<UserEntity> userEntityOptional = this.repository.findById(id);

       return userEntityOptional.isPresent() ? this.convertToDto(userEntityOptional.get()) : null;
    }

    public List<UserDto> getAll() {
       List<UserEntity> users = this.repository.findAll();

       return this.repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
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
