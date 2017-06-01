package com.asuscomm.yangyinetwork.andstudy_05_view.Post;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jaeyoung on 2017. 3. 26..
 */

public class Post implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("uploaded_date")
    private int uploaded_date;

    public Post(String title, String content, int uploaded_date) {
        this.title = title;
        this.content = content;
        this.uploaded_date = uploaded_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUploaded_date() {
        return uploaded_date;
    }

    public void setUploaded_date(int uploaded_date) {
        this.uploaded_date = uploaded_date;
    }
}
