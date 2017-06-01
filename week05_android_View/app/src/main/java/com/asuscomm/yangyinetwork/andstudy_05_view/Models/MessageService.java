package com.asuscomm.yangyinetwork.andstudy_05_view.Models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jaeyoung on 2017. 3. 4..
 */

public interface MessageService {
    @GET("api/message/{message_id}")
    Call<Message> getMessage(@Path("message_id") String id);

    @GET("api/message")
    Call<MessageDto> getMessagePageDto();

    @POST("api/message")
    Call<Message> postMessage(@Body Message message);

    @DELETE("api/message/{message_id}")
    Call<Void> deleteRecord(@Path("message_id") String id);
}

