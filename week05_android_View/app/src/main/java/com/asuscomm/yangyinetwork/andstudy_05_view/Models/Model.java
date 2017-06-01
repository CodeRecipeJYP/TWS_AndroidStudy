package com.asuscomm.yangyinetwork.andstudy_05_view.Models;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 3. 19..
 */

public interface Model {
    void setMessageDto(MessageDto<Message> messageDto);
    void setMessage(Message message);
    void setMessageList(List<Message> messageList);
}
