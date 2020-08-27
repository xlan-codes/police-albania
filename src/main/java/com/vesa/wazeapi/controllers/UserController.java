package com.vesa.wazeapi.controllers;


import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.interfaces.IController;
import com.vesa.wazeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController implements IController<UserDto>
{

    public static final String BASE_USER_CONTROLLER = "/user";

    @Autowired
    UserService userService;

    @RequestMapping(value = UserController.BASE_USER_CONTROLLER, method = RequestMethod.GET, produces = "application/json")
    public List<UserDto> getAll() {
        return this.userService.getAll();
    }

    @RequestMapping(value = UserController.BASE_USER_CONTROLLER + "/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserDto get(@PathVariable("id") String id){
        return this.userService.get(id);
    }

    @RequestMapping(value = UserController.BASE_USER_CONTROLLER, method = RequestMethod.POST, produces = "application/json")
    public UserDto post(@RequestBody UserDto object) {
        return this.userService.save(object);
    }

    @RequestMapping(value = UserController.BASE_USER_CONTROLLER, method = RequestMethod.PUT, produces = "application/json")
    public UserDto put(@RequestBody UserDto object) {
        return this.userService.save(object);
    }

    @RequestMapping(value = UserController.BASE_USER_CONTROLLER + "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}