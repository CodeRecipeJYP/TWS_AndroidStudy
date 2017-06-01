package com.tmanager.myapplication;

/**
 * Created by DoDo on 2017-03-19.
 */

public interface Presenter {
    void saveData(String title, String content, String author);
    void loadData(String title);
}
