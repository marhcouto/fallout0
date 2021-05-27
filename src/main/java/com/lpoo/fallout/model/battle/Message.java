package com.lpoo.fallout.model.battle;

public class Message {
    private BattleMenuModel.OPTION option;
    private final boolean succeeded;
    private final String messageDescriptor;
    private final long endTime;
    public final long MAX_DISPLAY_TIME = 3000; //Milliseconds


    public Message() {
        this("WAITING FOR COMMANDS", BattleMenuModel.OPTION.ATTACK, false);
    }
    public Message(String messageDescriptor, BattleMenuModel.OPTION option, boolean succeeded) {
        this.succeeded = succeeded;
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

    public String getMessageDescriptor() {
        return messageDescriptor;
    }

    public long getEndTime() {
        return endTime;
    }
}
