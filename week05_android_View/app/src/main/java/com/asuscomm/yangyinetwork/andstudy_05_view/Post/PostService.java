package com.asuscomm.yangyinetwork.andstudy_05_view.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jaeyoung on 2017. 3. 26..
 */

public interface PostService {
    @GET("api/post")
    Call<List<Post>> getPosts();

//    @GET("api/message")
//    Call<MessageDto> getMessagePageDto();
//
//    @POST("api/message")
//    Call<Message> postMessage(@Body Message message);
//
//    @DELETE("api/message/{message_id}")
//    Call<Void> deleteRecord(@Path("message_id") String id);

}
