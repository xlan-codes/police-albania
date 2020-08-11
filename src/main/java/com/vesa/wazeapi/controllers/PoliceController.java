package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.PoliceDto;
import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PoliceController  {

    
    @RequestMapping(value = "/police", method = RequestMethod.GET, produces = "application/json")
    public PoliceDto getPolice() {
        return null;
    }

    @RequestMapping(value = "/police", method = RequestMethod.POST, produces = "application/json")
    public PoliceDto post(@RequestBody PoliceDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
    
//    public PoliceDto post(ArrayList<PoliceDto> objects) {
//        return null;
//    }

    //    @RequestMapping(value = "/",method = RequestMethod.POST)
    
//    public PoliceDto put(ArrayList<PoliceDto> objects) {
//        return null;
//    }
//
//    //    @RequestMapping(value = "/",method = RequestMethod.POST)
//
//    public PoliceDto put(PoliceDto object) {
//        return null;
//    }

    @RequestMapping(value = "/police", method = RequestMethod.PUT, produces = "application/json")
    public PoliceDto update(@RequestBody PoliceDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.PUT, produces = "application/json")
    
//    public PoliceDto update(ArrayList<PoliceDto> objects) {
//        return null;
//    }

    @RequestMapping(value = "/police/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}