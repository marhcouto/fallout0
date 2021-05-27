package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.controller.battle.command.NullData;
import com.lpoo.fallout.model.battle.TurnModel;

import java.util.Random;

public class AttackCommand implements Command<NullData> {
    private Random randomEngine;
    private TurnModel turn;

    public AttackCommand(TurnModel turn, Random randomEngine) {
        this.randomEngine = randomEngine;
        this.turn = turn;
    }

    @Override
    public void activate(NullData requestData) {
        SendAttack sendAttack = new SendAttack(turn, randomEngine);
        ReceiveAttack receiveAttack = new ReceiveAttack(turn, randomEngine);
        DealDamage dealDamage = new DealDamage(turn, randomEngine);
        sendAttack.setNext(receiveAttack);
        receiveAttack.setNext(dealDamage);
        sendAttack.handle();
    }
}
