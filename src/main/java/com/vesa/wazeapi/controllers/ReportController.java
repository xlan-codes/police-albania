package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.ReportDto;
import org.springframework.web.bind.annotation.RestController;

@RestController("/report")
public class ReportController extends BaseController<ReportDto> {
}
