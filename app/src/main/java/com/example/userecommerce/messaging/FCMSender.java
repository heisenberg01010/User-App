package com.example.userecommerce.messaging;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MediaType;

public class FCMSender {
    private static final String FCM_URL = "https://fcm.googleapis.com/fcm/send"
            , KEY_STRING = "key=AAAAG8Pk3mc:APA91bHtZ-CpUxh2iYotApbLSrrbs_ULOdCbi8XtuzvkbUJ832fcKhR2FoPqFR0hboFEZ4hhfAX8xjNgiLVwp0cPjiNfjuQurvm8czHdHZBFZmJYOlty84RtUt4x9Q1GIMwbEOb49qc-";

    OkHttpClient client = new OkHttpClient();

    public void send(String message, Callback callback){
        RequestBody reqBody = RequestBody.create(MediaType
                        .get("application/json")
                        , message);

        Request request = new Request.Builder()
                .url(FCM_URL)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", KEY_STRING)
                .post(reqBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
