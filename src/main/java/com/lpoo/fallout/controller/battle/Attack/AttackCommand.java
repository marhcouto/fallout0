package com.lpoo.fallout.controller.battle.Attack;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.model.battle.TurnModel;

import java.util.Random;

public class AttackCommand implements Command<TurnModel> {
    private Random randomEngine;

    public AttackCommand(Random randomEngine) {
        this.randomEngine = randomEngine;
    }

    @Override
    public void activate(TurnModel requestData) {
        SendAttack sendAttack = new SendAttack(requestData, randomEngine);
        ReceiveAttack receiveAttack = new ReceiveAttack(requestData, randomEngine);
        DealDamage dealDamage = new DealDamage(requestData, randomEngine);
        sendAttack.setNext(receiveAttack);
        receiveAttack.setNext(dealDamage);
        sendAttack.handle();
    }
}
