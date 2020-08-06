package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.TrafficJamDto;
import org.springframework.web.bind.annotation.RestController;

@RestController("/traffic-jam")
public class TrafficJamController extends BaseController<TrafficJamDto> {
}
