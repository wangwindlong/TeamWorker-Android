package cn.chestnut.mvvm.teamworker.module.massage.adapter;

import android.content.Context;

import java.util.List;

import cn.chestnut.mvvm.teamworker.databinding.ItemMessageBinding;
import cn.chestnut.mvvm.teamworker.main.adapter.BaseRecyclerViewAdapter;
import cn.chestnut.mvvm.teamworker.module.massage.MessageDaoUtils;
import cn.chestnut.mvvm.teamworker.module.massage.bean.MessageUser;
import cn.chestnut.mvvm.teamworker.module.massage.bean.MessageVo;
import cn.chestnut.mvvm.teamworker.utils.PreferenceUtil;

/**
 * Copyright (c) 2017, Chestnut All rights reserved
 * Author: Chestnut
 * CreateTime：at 2017/12/29 15:36:20
 * Description：
 * Email: xiaoting233zhang@126.com
 */

public class MessageAdapter extends BaseRecyclerViewAdapter<MessageVo, ItemMessageBinding> {

    private MessageDaoUtils messageDaoUtils;

    private OnUpdateMessageLayoutListener onUpdateMessageLayoutListener;

    private Context mContext;

    public MessageAdapter(List<MessageVo> mItems, Context mContext) {
        super(mItems);
        messageDaoUtils = new MessageDaoUtils(mContext);
        this.mContext = mContext;
    }

    @Override
    protected void handleViewHolder(ItemMessageBinding binding, MessageVo obj, int position) {
        if (obj.getMessageUser() == null) {
            long updateTime = PreferenceUtil.getInstances(mContext).getPreferenceLong("updateTime");
            //本地获取
            MessageUser messageUser = messageDaoUtils.queryMessageUserByUserId(obj.getMessage().getSenderId());
            //本地SQLite没有记录，则从服务器拿并插入本地
            if (messageUser == null) {
                updateMessageUser(this, obj, false);
            }
            //本地有记录，再判断是否到更新时间，是则从服务器拿并更新本地
            else if (updateTime != 0 || updateTime < System.currentTimeMillis()) {
                obj.setMessageUser(messageUser);
            } else updateMessageUser(this, obj, true);

        }
    }

    private void updateMessageUser(MessageAdapter messageAdapter, MessageVo obj, boolean isUpdate) {
        if (onUpdateMessageLayoutListener != null) {
            onUpdateMessageLayoutListener.onUpdate(messageAdapter, obj, isUpdate);
        }
    }

    public void setOnUpdateMessageLayoutListener(OnUpdateMessageLayoutListener onUpdateMessageLayoutListener) {
        this.onUpdateMessageLayoutListener = onUpdateMessageLayoutListener;
    }

    public interface OnUpdateMessageLayoutListener {
        void onUpdate(MessageAdapter messageAdapter, MessageVo obj, boolean isUpdate);
    }
}
