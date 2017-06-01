package com.asuscomm.yangyinetwork.andstudy_05_view.Post;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jaeyoung on 2017. 3. 26..
 */

public class PostNetworkServiceImpl {
    DefaultRestClient<PostService> PostRestClient;
    PostService mPostService;

    public interface Listener {
        void onGetPostsSuccess(List<Post> posts);
    }
    Listener mListener;

    public PostNetworkServiceImpl(Listener listener) {
        mListener = listener;
        init();
    }

    private void init() {
        PostRestClient = new DefaultRestClient<>();
        mPostService = PostRestClient.getClient(PostService.class);
    }

    Post mPost;
    List<Post> mPosts;

    public void getPosts() {
        Call<List<Post>> call = mPostService.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "getDto success");
                    mPosts = response.body();
                    Log.d("jyp", mPosts.toString());
                    //sendGetMessageDto(MessageDto);
                    mListener.onGetPostsSuccess(mPosts);

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("jyp", "get fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","getMessagePageDto");
    }

    void send_getPosts(List<Post> posts){

    }
}
