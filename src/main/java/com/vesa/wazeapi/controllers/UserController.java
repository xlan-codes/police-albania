package com.vesa.wazeapi.controllers;


import com.vesa.wazeapi.dto.UserDto;
import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController
//        implements
//        IController<UserDto> 
{



    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public UserDto getUser() {
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public UserDto post(UserDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
//    public UserDto post(ArrayList<UserDto> objects) {
//        return null;
//    }
//
//    //    @RequestMapping(value = "/",method = RequestMethod.POST)
//
//    public UserDto put(ArrayList<UserDto> objects) {
//        return null;
//    }
//
//    //    @RequestMapping(value = "/",method = RequestMethod.POST)
//
//    public UserDto put(UserDto object) {
//        return null;
//    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public UserDto update(UserDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.PUT, produces = "application/json")
//    public UserDto update(ArrayList<UserDto> objects) {
//        return null;
//    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}