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

    public static final String BASE_TRAFFIC_JAM_CONTROLLER = "/traffic-jam";

    @Override
    @RequestMapping(value = TrafficJamController.BASE_TRAFFIC_JAM_CONTROLLER + "/{id}", method = RequestMethod.GET, produces = "application/json")
    public TrafficJamDto get(@PathVariable("id") String id) {
        return null;
    }

    @RequestMapping(value = TrafficJamController.BASE_TRAFFIC_JAM_CONTROLLER, method = RequestMethod.POST, produces = "application/json")
    @Override
    public TrafficJamDto post(TrafficJamDto object) {
        return null;
    }

    @RequestMapping(value = TrafficJamController.BASE_TRAFFIC_JAM_CONTROLLER, method = RequestMethod.PUT, produces = "application/json")
    @Override
    public TrafficJamDto put(TrafficJamDto object) {
        return null;
    }

    @RequestMapping(value = TrafficJamController.BASE_TRAFFIC_JAM_CONTROLLER + "/{id}", method = RequestMethod.DELETE)
    @Override
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}