package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public UserDto post(@RequestBody UserDto object) {
        return this.userService.save(object);
    }

}
