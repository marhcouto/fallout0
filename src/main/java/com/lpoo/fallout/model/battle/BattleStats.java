package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.element.Character;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BattleStats {
    private final Integer startingHealthPoints;
    private Integer healthPoints;
    private Float dodgeChance;
    private Float missChance;
    private Integer baseDamage;
    private Float critRatio;
    public static Float CRIT_MULTIPLIER = (float) 1.50;

    public BattleStats(@NotNull Integer healthPoints, @NotNull Float dodgeChance, @NotNull Float missChange, @NotNull Integer baseDamage, @NotNull Float critRatio) {
        this.startingHealthPoints = healthPoints;
        this.healthPoints = healthPoints;
        this.dodgeChance = dodgeChance;
        this.missChance = missChange;
        this.baseDamage = baseDamage;
        this.critRatio = critRatio;
    }

    public BattleStats(@NotNull Character character) {
        this.healthPoints = 15 + character.getAttributes().getStrength() * character.getLevel();
        this.startingHealthPoints = this.healthPoints;
        this.dodgeChance = (float) (character.getAttributes().getIntelligence() / 100);
        this.missChance = (float) ((80 - character.getAttributes().getLuck()) / 100);
        this.baseDamage = character.getInventory().getWeapon().getDamage();
        this.critRatio = (float) (character.getAttributes().getIntelligence() / 100 + character.getAttributes().getLuck() / 100);
    }

    public @NotNull Integer getHealthPoints() {
        return healthPoints;
    }
    public @NotNull Integer getStartingHealthPoints() {
        return startingHealthPoints;
    }
    public @NotNull Float getDodgeChance() {
        return dodgeChance;
    }
    public @NotNull Float getMissChance() {
        return missChance;
    }
    public @NotNull Integer getBaseDamage() {
        return baseDamage;
    }
    public @NotNull Float getCritRatio() { return critRatio; }


    public void setHealthPoints(@NotNull Integer healthPoints) {
        this.healthPoints = healthPoints;
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
}
