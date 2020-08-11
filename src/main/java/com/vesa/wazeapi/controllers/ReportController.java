package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.dto.ReportDto;
import com.vesa.wazeapi.dto.ReportDto;
import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReportController
{


    
    @RequestMapping(value = "/report", method = RequestMethod.GET, produces = "application/json")
    public ReportDto get() {
        return null;
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST, produces = "application/json")
    public ReportDto post(@RequestBody ReportDto object) {
        return object;
    }
//
//    //    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
//
//    public ReportDto post(ArrayList<ReportDto> objects) {
//        return null;
//    }
//
//    //    @RequestMapping(value = "/",method = RequestMethod.POST)
//
//    public ReportDto put(ArrayList<ReportDto> objects) {
//        return null;
//    }
//
//    //    @RequestMapping(value = "/",method = RequestMethod.POST)
//
//    public ReportDto put(ReportDto object) {
//        return null;
//    }

    @RequestMapping(value = "/report", method = RequestMethod.PUT, produces = "application/json")
    public ReportDto update(@RequestBody ReportDto object) {
        return null;
    }

    //    @RequestMapping(value = "/",method = RequestMethod.PUT, produces = "application/json")
//
//    public ReportDto update(ArrayList<ReportDto> objects) {
//        return null;
//    }

    @RequestMapping(value = "/report/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}