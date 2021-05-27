package com.lpoo.fallout.model.battle;

public class Message {
    private BattleMenuModel.OPTION option;
    private final boolean succeeded;
    private boolean unseen;
    private String messageDescriptor;
    private final long endTime;
    public final long MAX_DISPLAY_TIME = 3000; //Milliseconds


    public Message() {
        this("WAITING FOR\nCOMMANDS", BattleMenuModel.OPTION.ATTACK, false, false);
    }
    public Message(String messageDescriptor, BattleMenuModel.OPTION option, boolean succeeded, boolean unseen) {
        this.succeeded = succeeded;
        this.unseen = unseen;
        this.option = option;
        this.messageDescriptor = messageDescriptor;
        this.endTime = System.currentTimeMillis() + MAX_DISPLAY_TIME;
    }

    public BattleMenuModel.OPTION getOption() {
        return option;
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
