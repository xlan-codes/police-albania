package com.vesa.wazeapi.interfaces;

import java.util.ArrayList;

public interface IController<T> {

    T get();

    T post(T object);

    T post(ArrayList<T> objects);


    T put(ArrayList<T> objects);


    T put(T object);


    T update(T object);


    T update(ArrayList<T> objects);


    boolean delete(String object);


}
