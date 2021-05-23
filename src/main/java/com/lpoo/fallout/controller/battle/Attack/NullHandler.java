package com.lpoo.fallout.controller.battle.Attack;

import com.lpoo.fallout.controller.battle.CommandHandler;

public class NullHandler implements CommandHandler {
    @Override
    public void handle() { }

    @Override
    public void setNext(CommandHandler commandHandler) { }
}
