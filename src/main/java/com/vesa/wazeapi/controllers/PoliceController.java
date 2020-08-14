package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.PoliceDto;
import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PoliceController  {

    
    @RequestMapping(value = "/police/{id}", method = RequestMethod.GET, produces = "application/json")
    public PoliceDto get(@PathVariable("id") String id) {
        return null;
    }

    @RequestMapping(value = "/police/get-all", method = RequestMethod.GET, produces = "application/json")
    public PoliceDto getAll() {
        return null;
    }

    @RequestMapping(value = "/police", method = RequestMethod.POST, produces = "application/json")
    public PoliceDto post(@RequestBody PoliceDto object) {
        return null;
    }

    @RequestMapping(value = "/police", method = RequestMethod.PUT, produces = "application/json")
    public PoliceDto put(@RequestBody PoliceDto object) {
        return null;
    }

    @RequestMapping(value = "/police/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}