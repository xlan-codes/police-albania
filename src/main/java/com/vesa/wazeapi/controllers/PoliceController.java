package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.PoliceDto;
import org.springframework.web.bind.annotation.RestController;

@RestController("/police")
public class PoliceController extends BaseController<PoliceDto> {
}
