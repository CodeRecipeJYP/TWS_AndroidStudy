package com.asuscomm.yangyinetwork.andstudy_05_view.Models;

/**
 * Created by jaeyoung on 2017. 3. 19..
 */

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jaeyoung on 2017. 3. 4..
 */

public class Message implements Serializable {
    @SerializedName("message")
    private String message;
    @SerializedName("id")
    private String id;

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }
}
