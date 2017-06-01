package com.asuscomm.yangyinetwork.andstudy_05_view;

import android.app.Activity;
import android.util.Log;

import com.asuscomm.yangyinetwork.andstudy_05_view.Models.DefaultRestClient;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.Message;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.MessageDto;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.MessageService;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jaeyoung on 2017. 3. 19..
 */

public class NetworkService implements Presenter {
    Model model;
    DefaultRestClient<MessageService> ddDefaultRestClient;
    MessageService mMessageService;

    public NetworkService(Model model) {
        this.model= model;
        init();
    }

        private void init() {
            ddDefaultRestClient = new DefaultRestClient<>();
            mMessageService = ddDefaultRestClient.getClient(MessageService.class);
        }

        Message mMessage;
        MessageDto<Message> MessageDto;

    @Override
    public void getMessageDto() {
        Call<MessageDto> call = mMessageService.getMessagePageDto();

        call.enqueue(new Callback<MessageDto>() {
            @Override
            public void onResponse(Call<MessageDto> call, Response<MessageDto> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "getDto success");
                    MessageDto = response.body();
                    List<Message> messageList = MessageDto.getContent();
                    Log.d("jyp", messageList.toString());
                    sendGetMessageDto(MessageDto);
                } else {

                }
            }

            @Override
            public void onFailure(Call<MessageDto> call, Throwable t) {
                Log.d("jyp", "get fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","getMessagePageDto");
    }

    @Override
    public void getMessage(String id) {
        Call<Message> call = mMessageService.getMessage(id);

        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "get success");
                    mMessage = response.body();
                    send_getMessage(mMessage);
                    Log.d("jyp", mMessage.getMessage());
                } else {
                    Log.d("jyp", "get fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("jyp", "get fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","get");
    }

    @Override
    public void postMessage(Message message) {
        Call<Message> call = mMessageService.postMessage(message);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "post success");
                    mMessage = response.body();
                    Log.d("jyp", mMessage.getMessage());
                } else {
                    Log.d("jyp", "post fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("jyp", "post fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","post");
    }

    @Override
    public void deleteMessage(String id) {
        Call<Void> call = mMessageService.deleteRecord(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("jyp", "delete success");
                    Log.d("jyp", response.toString());
                } else {
                    Log.d("jyp", "delete fail");
                    Log.d("jyp", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("jyp", "delete fail2");
                t.printStackTrace();
            }
        });

        Log.d("jyp","delete");
    }

    void send_getMessage(Message message){
        model.setMessage(message);
    }

    void sendGetMessageDto(MessageDto<Message> messageDto){
        model.setMessageDto(messageDto);
    }
}
