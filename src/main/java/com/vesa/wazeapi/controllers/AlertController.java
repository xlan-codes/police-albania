package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.AlertDto;
import com.vesa.wazeapi.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(value = "/alert", method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> get() {
        List<AlertDto> alertDtoList = this.alertService.getAlert();
        return alertDtoList;
    }

    @RequestMapping(value = "/alert", method = RequestMethod.POST, produces = "application/json")
    public AlertDto post(@RequestBody AlertDto object) {
        AlertDto alertDto = this.alertService.save(object);
        return alertDto;
    }

    @RequestMapping(value = "/alert", method = RequestMethod.PUT, produces = "application/json")
    public AlertDto update(@RequestBody AlertDto object) {
        return null;
    }

    @RequestMapping(value = "/alert/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}
