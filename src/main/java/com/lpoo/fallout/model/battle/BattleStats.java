package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.element.Character;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BattleStats {
    private Integer healthPoints;
    private Float dodgeChance;
    private Float missChance;
    private Integer baseDamage;
    private Float critRatio;
    private Integer actions;
    public static Float CRIT_MULTIPLIER = (float) 1.50;

    public BattleStats(@NotNull Integer healthPoints, @NotNull Float dodgeChance, @NotNull Float missChange, @NotNull Integer baseDamage, @NotNull Float critRatio, @NotNull Integer actions) {
        this.healthPoints = healthPoints;
        this.dodgeChance = dodgeChance;
        this.missChance = missChange;
        this.baseDamage = baseDamage;
        this.critRatio = critRatio;
        this.actions = actions;
    }

    public BattleStats(@NotNull Character character, @NotNull Random randomEngine) {
        this.healthPoints = 15 + character.getAttributes().getStrength() * character.getLevel();
        this.dodgeChance = (float) (character.getAttributes().getIntelligence() / 100);
        this.missChance = (float) ((80 - character.getAttributes().getLuck()) / 100);
        this.baseDamage = character.getWeapon().getDamage();
        this.critRatio = (float) (character.getAttributes().getIntelligence() / 100 + character.getAttributes().getLuck() / 100);
        this.actions = (int) Math.ceil(2 + character.getAttributes().getAgility() * 0.15 + character.getAttributes().getIntelligence() * 0.05);
        if (randomEngine.nextFloat() < character.getAttributes().getLuck() * 0.05) {
            actions += (int) Math.floor(character.getAttributes().getLuck() * 0.1);
        }
    }

    public @NotNull Integer getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(@NotNull Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public @NotNull Float getdodgeChance() {
        return dodgeChance;
    }
    public @NotNull Float getMissChance() {
        return missChance;
    }
    public @NotNull Integer getBaseDamage() {
        return baseDamage;
    }
    public @NotNull Float getCritRatio() { return critRatio; }
    public @NotNull Integer getActions() {
        return actions;
    }

    public void setDodgeChance(@NotNull Float dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setMissChance(@NotNull Float missChance) {
        this.missChance = missChance;
    }

    public void setBaseDamage(@NotNull Integer baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setCritRatio(@NotNull Float critRatio) {
        this.critRatio = critRatio;
    }

    public void setActions(@NotNull Integer actions) {
        this.actions = actions;
    }
}
