package com.asuscomm.yangyinetwork.andstudy_05_view;

import com.asuscomm.yangyinetwork.andstudy_05_view.Models.Message;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.MessageDto;

/**
 * Created by jaeyoung on 2017. 3. 19..
 */

public interface Presenter {
    void getMessageDto();
    void getMessage(String id);
    void postMessage(Message message);
    void deleteMessage(String id);
}
