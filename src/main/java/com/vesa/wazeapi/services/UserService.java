package com.vesa.wazeapi.services;

import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.storage.entities.UserEntity;
import com.vesa.wazeapi.interfaces.IService;
import com.vesa.wazeapi.storage.repos.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService  implements IService, UserDetailsService {

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
       return this.repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }


    public UserDetails getUserDetails(String email) {
        Optional<UserEntity> user = this.repository.findByEmail(email);
       return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
    }

    public UserDto getUserDetailsByEmail(String email) {
        Optional<UserEntity> user = this.repository.findByEmail(email);
       return  user.isPresent() ? this.convertToDto(user.get()) : null;
    }


    private UserDto convertToDto(UserEntity userEntity) {
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    private UserEntity convertToEntity(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = repository.findByEmail(username);
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
    }
}
