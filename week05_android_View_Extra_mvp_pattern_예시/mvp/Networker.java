package com.tmanager.myapplication;

import android.os.AsyncTask;

/**
 * Created by DoDo on 2017-03-19.
 */

public class Networker implements Model {
    Presenter presenter;

    public Networker(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Data getData(String key) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //통신통신

                presenter.loadData();
            }
        })

        return null;
    }

    @Override
    public void postData(Data data, String key) {

    }

    @Override
    public void putData(Data data, String key) {

    }

    @Override
    public void delete(String key) {

    }
}
