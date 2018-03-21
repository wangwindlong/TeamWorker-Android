package cn.chestnut.mvvm.teamworker.main.common;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.multidex.MultiDex;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;
import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;

import cn.chestnut.mvvm.teamworker.BuildConfig;
import cn.chestnut.mvvm.teamworker.core.TeamWorkerMessageHandler;

/**
 * Copyright (c) 2017, Chestnut All rights reserved
 * Author: Chestnut
 * CreateTime：at 2017/12/10 20:49:36
 * Description：Application类
 * Email: xiaoting233zhang@126.com
 */

public class MyApplication extends Application {

    private static MyApplication application;

    public static MyApplication getInstance() {
        return application;
    }

    private static TeamWorkerMessageHandler mHandler;

    private static UploadManager uploadManager;


    public static TeamWorkerMessageHandler getTeamWorkerMessageHandler() {
        if (mHandler == null) {
            mHandler = TeamWorkerMessageHandler.getInstance();
        }
        return mHandler;
    }

    public static UploadManager getUploadManager() {
        return uploadManager;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        KLog.init(BuildConfig.DEBUG);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        //    上传图片的管理对象
        Configuration configuration = new Configuration.Builder()
                .connectTimeout(10)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(60)          // 服务器响应超时。默认60秒
                .zone(AutoZone.autoZone).build();

        uploadManager = new UploadManager(configuration);

    }
}
