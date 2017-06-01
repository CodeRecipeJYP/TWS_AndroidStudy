package com.tmanager.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.net.HttpURLConnection;

public class MVP extends AppCompatActivity implements Presenter{
    Viewer viewer;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        viewer = new ViewerVer1() ;
        model = new Networker();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void saveData(String title, String content, String author) {
        Data data = new Data();
        data.title = title;
        data.content = content;
        data.author = author;
        String key = title+":"+author;
        model.postData(data, key);
    }

    @Override
    public void loadData(String title, String author) {
        String key = title+":"+author;
        model.getData(key);
        viewer.showMessage(로드됨);
    }
}
