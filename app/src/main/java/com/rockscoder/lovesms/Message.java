package com.rockscoder.lovesms;

/**
 * Created by Siddiqur on 3/8/2018.
 */

public class Message {
    private String messageText;
    private int isFav;
    private int isTurned;

    public Message(String messageText, int isFav, int isTurned) {
        this.messageText = messageText;
        this.isFav = isFav;
        this.isTurned = isTurned;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getIsFav() {
        return isFav;
    }

    public void setIsFav(int isFav) {
        this.isFav = isFav;
    }

    public int getIsTurned() {
        return isTurned;
    }

    public void setIsTurned(int isTurned) {
        this.isTurned = isTurned;
    }
}
