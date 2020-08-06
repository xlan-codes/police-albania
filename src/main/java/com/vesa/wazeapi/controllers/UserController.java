package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.UserDto;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController extends BaseController<UserDto>{
}
