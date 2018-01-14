package cn.chestnut.mvvm.teamworker.module.massage.bean;

import cn.chestnut.mvvm.teamworker.BR;
import cn.chestnut.mvvm.teamworker.R;
import cn.chestnut.mvvm.teamworker.main.adapter.BindingItem;
import cn.chestnut.mvvm.teamworker.utils.FormatDateUtil;

/**
 * Created by king on 2018/1/14.
 */
public class MessageVo extends BindingItem {

    private Message message;

    private MessageUser messageUser;

    public String showSenderName() {
        if (messageUser == null) {
            return "";
        } else {
            return messageUser.getNickname();
        }
    }

    public String showTime() {
        return FormatDateUtil.getMessageTime(System.currentTimeMillis(), message.getTime());
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public MessageUser getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(MessageUser messageUser) {
        this.messageUser = messageUser;
    }

    @Override
    public int getViewType() {
        return R.layout.item_message;
    }

    @Override
    public int getViewVariableId() {
        return BR.message;
    }
}
