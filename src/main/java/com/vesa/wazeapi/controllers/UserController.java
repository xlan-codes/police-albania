package com.vesa.wazeapi.controllers;


import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.interfaces.IController;
import com.vesa.wazeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController implements IController<UserDto>
{

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public List<UserDto> getAll() {
        return this.userService.getAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserDto get(@PathVariable("id") String id){
        return this.userService.get(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public UserDto post(UserDto object) {
        return this.userService.save(object);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public UserDto put(UserDto object) {
        return this.userService.save(object);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}