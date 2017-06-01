package com.tmanager.myapplication;

/**
 * Created by DoDo on 2017-03-19.
 */

public interface Model {
    Data getData(String key);
    void postData(Data data, String key);
    void putData(Data data, String key);
    void delete(String key);
}
