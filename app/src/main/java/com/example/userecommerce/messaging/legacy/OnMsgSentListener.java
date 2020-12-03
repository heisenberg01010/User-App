package com.example.userecommerce.messaging.legacy;

public interface OnMsgSentListener {
    void onSuccess(String response);
    void onFailure(String error);
}
