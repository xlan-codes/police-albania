package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.AlertDto;
import com.vesa.wazeapi.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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

    @RequestMapping(value = "/alert/{id}", method = RequestMethod.GET, produces = "application/json")
    public AlertDto getOne(@PathVariable("id") String id) {
        AlertDto alertDtoList = this.alertService.findOne(id);
        return alertDtoList;
    }

    @RequestMapping(value = "/getLatestAlertsByDate", method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> getLatestAlerts(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        List<AlertDto> alertDtoList = this.alertService.getLatestAlerts(localDateTime);
        return alertDtoList;
    }

    @RequestMapping(value = "/getAlertByType", method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> getAlertByType(@RequestParam("type") String type) {
        List<AlertDto> alertDtoList = this.alertService.findByParentType(type);
        return alertDtoList;
    }

    @RequestMapping(value = "/alert", method = RequestMethod.POST, produces = "application/json")
    public AlertDto post(@RequestBody AlertDto object) {
        AlertDto alertDto = this.alertService.save(object);
        return alertDto;
    }


    @RequestMapping(value = "/alert", method = RequestMethod.PUT, produces = "application/json")
    public AlertDto update(@RequestBody AlertDto object) {
        AlertDto obj =  this.alertService.findOne(object.getId());
        if(obj == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        AlertDto alertDto = this.alertService.update(object);
        return alertDto;
    }

    @RequestMapping(value = "/alert/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}
