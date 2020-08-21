package com.vesa.wazeapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "Maybe you start reverse engineering. We are here and monitor you";
    }

}
