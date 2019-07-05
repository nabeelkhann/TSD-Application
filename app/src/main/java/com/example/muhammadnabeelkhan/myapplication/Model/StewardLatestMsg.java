package com.example.hp.passengerapplication.Model;

public class StewardLatestMsg {
    String userId;
    String msg;

    StewardLatestMsg(){}

    public StewardLatestMsg(String userId, String msg) {
        this.userId = userId;
        this.msg = msg;
    }

    public String getUserId() {
        return userId;
    }

    public String getMsg() {
        return msg;
    }
}
