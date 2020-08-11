package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.interfaces.IController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


public class BaseController<T> implements IController<T> {


    @Override
    @RequestMapping(value = "/",method = RequestMethod.GET,  produces = "application/json")
    public T get() {
        return null;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
    @Override
    public T post(T object) {
        return null;
    }

//    @RequestMapping(value = "/",method = RequestMethod.POST,  produces = "application/json")
    @Override
    public T post(ArrayList<T> objects) {
        return null;
    }

//    @RequestMapping(value = "/",method = RequestMethod.POST)
    @Override
    public T put(ArrayList<T> objects) {
        return null;
    }

//    @RequestMapping(value = "/",method = RequestMethod.POST)
    @Override
    public T put(T object) {
        return null;
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT,  produces = "application/json")
    @Override
    public T update(T object) {
        return null;
    }

//    @RequestMapping(value = "/",method = RequestMethod.PUT, produces = "application/json")
    @Override
    public T update(ArrayList<T> objects) {
        return null;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @Override
    public boolean delete(@PathVariable("id") String object) {
        return false;
    }
}
