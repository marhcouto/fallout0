package com.lpoo.fallout.model.battle;

public class Message {
    private final boolean succeeded;
    private boolean unseen;
    private String messageDescriptor;
    private final long endTime;
    public final long MAX_DISPLAY_TIME = 1600; //Milliseconds


    public Message() {
        this("WAITING FOR\nCOMMANDS", false, true);
    }
    public Message(String messageDescriptor, boolean succeeded, boolean unseen) {
        this.succeeded = succeeded;
        this.unseen = unseen;
        this.messageDescriptor = messageDescriptor;
        this.endTime = System.currentTimeMillis() + MAX_DISPLAY_TIME;
    }

    public boolean succeeded() {
        return succeeded;
    }

    public void setMessageDescriptor(String messageDescriptor) {
        this.messageDescriptor = messageDescriptor;
    }

    public boolean isUnseen() {
        return unseen;
    }

    public void setUnseen(boolean unseen) {
        this.unseen = unseen;
    }

    public String getMessageDescriptor() {
        return messageDescriptor;
    }

    public long getEndTime() {
        return endTime;
    }
}
