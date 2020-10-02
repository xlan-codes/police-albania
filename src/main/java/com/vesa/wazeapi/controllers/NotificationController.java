package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.NotificationDto;
import com.vesa.wazeapi.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class NotificationController {

    public static final String BASE_USER_CONTROLLER = "/notification";

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = NotificationController.BASE_USER_CONTROLLER, method = RequestMethod.GET, produces = "application/json")
    public List<NotificationDto> getAll() {
        return this.notificationService.getAll();
    }

    @RequestMapping(value = NotificationController.BASE_USER_CONTROLLER + "/{id}", method = RequestMethod.GET, produces = "application/json")
    public NotificationDto get(@PathVariable("id") String id){
        return this.notificationService.findOne(id);
    }

    @RequestMapping(value = NotificationController.BASE_USER_CONTROLLER + "/fail", method = RequestMethod.GET, produces = "application/json")
    public List<NotificationDto> getFailNotification(){
        return this.notificationService.findByMessageId(null);
    }

    @RequestMapping(value = NotificationController.BASE_USER_CONTROLLER, method = RequestMethod.POST, produces = "application/json")
    public NotificationDto post(@RequestBody NotificationDto object) {
        return this.notificationService.save(object);
    }

    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER + "/get-latest-notifications", method = RequestMethod.GET, produces = "application/json")
    public List<NotificationDto> getAlertByType(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<LocalDateTime> localDateTime) {

        LocalDateTime time = localDateTime.isPresent() ? localDateTime.get():null;
        List<NotificationDto> notificationDtoList = this.notificationService.getLatestAlerts(time);
        return notificationDtoList;
    }

    @RequestMapping(value = NotificationController.BASE_USER_CONTROLLER, method = RequestMethod.PUT, produces = "application/json")
    public NotificationDto put(@RequestBody NotificationDto object) {
        return this.notificationService.save(object);
    }

    @RequestMapping(value = NotificationController.BASE_USER_CONTROLLER + "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }

}
