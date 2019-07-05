package com.example.hp.passengerapplication.Model;

public class MessageChat {
    private String chatId;
    private String msg ;
    private long timestamp;
    private String msgId;// particular msg id
    private String senderId;

    public MessageChat(){}

    public MessageChat(String chatId, String msg, long timestamp, String msgId, String senderId) {
        this.chatId = chatId;
        this.msg = msg;
        this.timestamp = timestamp;
        this.msgId = msgId;
        this.senderId = senderId;
    }

    public String getChatId() {
        return chatId;
    }

    public String getMsg() {
        return msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getSenderId() {
        return senderId;
    }
}

