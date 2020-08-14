package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.ReportDto;
import com.vesa.wazeapi.dto.ReportDto;
import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReportController
{


    
    @RequestMapping(value = "/report/{id}", method = RequestMethod.GET, produces = "application/json")
    public ReportDto get(@PathVariable("id") String id) {
        return null;
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST, produces = "application/json")
    public ReportDto post(@RequestBody ReportDto object) {
        return object;
    }

    @RequestMapping(value = "/report", method = RequestMethod.PUT, produces = "application/json")
    public ReportDto put(@RequestBody ReportDto object) {
        return null;
    }

    @RequestMapping(value = "/report/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}