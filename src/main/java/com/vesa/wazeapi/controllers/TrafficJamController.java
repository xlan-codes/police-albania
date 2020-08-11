package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.TrafficJamDto;
import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TrafficJamController implements IController<TrafficJamDto> {


    @Override
    @RequestMapping(value = "/traffic-jam", method = RequestMethod.GET, produces = "application/json")
    public TrafficJamDto get() {
        return null;
    }

    @RequestMapping(value = "/traffic-jam", method = RequestMethod.POST, produces = "application/json")
    @Override
    public TrafficJamDto post(TrafficJamDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
    @Override
    public TrafficJamDto post(ArrayList<TrafficJamDto> objects) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.POST)
    @Override
    public TrafficJamDto put(ArrayList<TrafficJamDto> objects) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.POST)
    @Override
    public TrafficJamDto put(TrafficJamDto object) {
        return null;
    }

    @RequestMapping(value = "/traffic-jam", method = RequestMethod.PUT, produces = "application/json")
    @Override
    public TrafficJamDto update(TrafficJamDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.PUT, produces = "application/json")
    @Override
    public TrafficJamDto update(ArrayList<TrafficJamDto> objects) {
        return null;
    }

    @RequestMapping(value = "/traffic-jam/{id}", method = RequestMethod.DELETE)
    @Override
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}