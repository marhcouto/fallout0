package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.battle.command.CureCommand;
import com.lpoo.fallout.controller.battle.command.DefendCommand;
import com.lpoo.fallout.controller.battle.command.IntimidateCommand;
import com.lpoo.fallout.controller.battle.command.attack.AttackCommand;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.TurnModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleMonsterController {
    private static List<BattleMenuModel.OPTION> monsterOptions;
    private final Observable<TurnObserver> observable;
    private TurnModel turn;

    static {
        monsterOptions = new ArrayList<>();
        monsterOptions.add(BattleMenuModel.OPTION.ATTACK);
        monsterOptions.add(BattleMenuModel.OPTION.DEFEND);
        monsterOptions.add(BattleMenuModel.OPTION.INTIMIDATE);
    }

    public BattleMonsterController(TurnModel turn, Observable<TurnObserver> observable) {
        this.observable = observable;
        this.turn = turn;
    }

    void step(Random randomEngine) {
        BattleMenuModel.OPTION chosenOption = monsterOptions.get(randomEngine.nextInt(monsterOptions.size()));
        switch (chosenOption) {
            case ATTACK: {
                observable.subscribe(new TurnEffect(0, new AttackCommand(turn, new Random()), observable));
                break;
            }
            case DEFEND: {
                observable.subscribe(new TurnEffect(0, new DefendCommand(turn), observable));
                break;
            }
            case INTIMIDATE: {
                observable.subscribe(new TurnEffect(0, new IntimidateCommand(turn), observable));
                break;
            }
            default: {
                System.out.println("Impossible Path");
            }
        }
    }
}
