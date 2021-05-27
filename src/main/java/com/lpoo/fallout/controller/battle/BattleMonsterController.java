package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.TurnModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleMonsterController {
    private static List<BattleMenuModel.OPTION> monsterOptions;
    private TurnModel turn;

    static {
        monsterOptions = new ArrayList<>();
        monsterOptions.add(BattleMenuModel.OPTION.ATTACK);
        monsterOptions.add(BattleMenuModel.OPTION.DEFEND);
        monsterOptions.add(BattleMenuModel.OPTION.INTIMIDATE);
    }

    public BattleMonsterController(TurnModel turn) {
        this.turn = turn;
    }

    void step(Random randomEngine) {
        BattleMenuModel.OPTION chosenOption = monsterOptions.get(randomEngine.nextInt(monsterOptions.size()));
        switch (chosenOption) {
            case ATTACK: {
                break;
            }
            case DEFEND: {
                break;
            }
            case INTIMIDATE: {
                break;
            }
            default: {
                System.out.println("Impossible Path");
            }
        }
    }
}
