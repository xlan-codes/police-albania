package com.vesa.wazeapi.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.vesa.wazeapi.Constants;
import com.vesa.wazeapi.dto.AlertDto;
import com.vesa.wazeapi.model.PushNotificationRequest;
import com.vesa.wazeapi.services.AlertService;
import com.vesa.wazeapi.services.AndroidPushNotificationsService;
import com.vesa.wazeapi.services.PushNotificationService;
import com.vesa.wazeapi.utils.NotificationServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AlertController {

    public static final String BASE_ALERT_CONTROLLER = "/alert";

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    AlertService alertService;

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER, method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> get() {
        List<AlertDto> alertDtoList = this.alertService.getAlert();
        return alertDtoList;
    }

    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER + "/{id}", method = RequestMethod.GET, produces = "application/json")
    public AlertDto getOne(@PathVariable("id") String id) {
        AlertDto alertDtoList = this.alertService.findOne(id);
        return alertDtoList;
    }

    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER + "/getLatestAlertsByDate", method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> getLatestAlerts(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        List<AlertDto> alertDtoList = this.alertService.getLatestAlerts(localDateTime);
        return alertDtoList;
    }

    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER + "/getAlertByTypeAndDate", method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> getAlertByType(@RequestParam("type") String type, @RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<LocalDateTime> localDateTime) {

        LocalDateTime time = localDateTime.isPresent() ? localDateTime.get():null;
        List<AlertDto> alertDtoList = this.alertService.findByParentTypeAndDate(type, time);
        return alertDtoList;
    }

//    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER + "/getAlertByTypeAndDate", method = RequestMethod.GET, produces = "application/json")
    public List<AlertDto> getAlerts(@RequestParam("parentType") Optional<String> pType,
                                    @RequestParam("like") Optional<Integer> l,
                                    @RequestParam("dislike") Optional<Integer> disl,
                                    @RequestParam("lat") Optional<Double> lt,
                                    @RequestParam("lng") Optional<Double> ln,
                                    @RequestParam("type") Optional<String> t,
                                    @RequestParam("name") Optional<String> n,
                                    @RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<LocalDateTime> localDateTime
                                    ) {

        LocalDateTime created = localDateTime.isPresent() ? localDateTime.get():null;
        String parentType = pType.isPresent() ? pType.get():null;
        String type = t.isPresent() ? t.get():null;
        Integer like = l.isPresent() ? l.get():null;
        Integer dislike = disl.isPresent() ? disl.get():null;
        Double lat = lt.isPresent() ? lt.get():null;
        Double lng = ln.isPresent() ? ln.get():null;
        String name = n.isPresent() ? n.get():null;

//        List<AlertDto> alertDtoList = this.alertService.find(parentType, like, type, name, lng, lat, dislike, created);
//        return alertDtoList;

        return null;
    }

    @RequestMapping(value = "/alert", method = RequestMethod.POST, produces = "application/json")
    public AlertDto post(@RequestBody AlertDto object) throws FirebaseAuthException {
        AlertDto alertDto = this.alertService.save(object);

        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + Constants.FIREBASE_TOPIC);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", Constants.FIREBASE_TITLE);
        notification.put("body", NotificationServices.getMessage(alertDto.getType()));

        JSONObject data = new JSONObject();
        data.put("lat", alertDto.lat);
        data.put("lng", alertDto.lng);

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return alertDto;
    }


    @RequestMapping(value = AlertController.BASE_ALERT_CONTROLLER, method = RequestMethod.PUT, produces = "application/json")
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
