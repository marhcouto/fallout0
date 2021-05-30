package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.controller.battle.command.BattleCommand;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class AttackCommand extends BattleCommand {
    private Random randomEngine;

    public AttackCommand(@NotNull TurnModel turn, @NotNull Random randomEngine) {
        super(turn);
        this.randomEngine = randomEngine;
    }

    @Override
    public void activate() {
        SendAttack sendAttack = new SendAttack(getTurn(), randomEngine);
        ReceiveAttack receiveAttack = new ReceiveAttack(getTurn(), randomEngine);
        DealDamage dealDamage = new DealDamage(getTurn(), randomEngine);
        sendAttack.setNext(receiveAttack);
        receiveAttack.setNext(dealDamage);
        sendAttack.handle();
    }

    @Override
    public void deactivate() {

    }
}
