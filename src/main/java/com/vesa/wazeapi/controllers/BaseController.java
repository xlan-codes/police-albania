package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BaseController<T> implements IController<T> {


    @Override
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,  produces = "application/json")
    public T get(@PathVariable("id") String id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
    public T post(T object) {
        return null;
    }

    @Override
    @RequestMapping(value = "/",method = RequestMethod.PUT,  produces = "application/json")
    public T put(T object) {
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}
