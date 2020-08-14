package com.vesa.wazeapi.interfaces;

import java.util.List;

public interface IController<T> {

    T get(String id);

    T post(T object);

    T put(T object);

    boolean delete(String object);


}
